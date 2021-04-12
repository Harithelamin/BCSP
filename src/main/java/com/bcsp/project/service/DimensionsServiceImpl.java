package com.bcsp.project.service;


import com.bcsp.project.dao.DimensionsDao;
import com.bcsp.project.model.Dimensions;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


@Service("dimensionService")
@Transactional
public class DimensionsServiceImpl implements DimensionsService {

	@Autowired
	private DimensionsDao dao;

	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}


	@Override
	public Dimensions findById(int id) {
		return null;
	}

	@Override
	public Dimensions findByDID(String did) {
		Dimensions dimensions = dao.findByDID(did);
		return dimensions;
	}

	@Override
	public void saveDimensions(Dimensions dimensions)
	{
		dimensions.setCreatedBy(getPrincipal());
		dimensions.setCreatedOn(new Date());
		dao.save(dimensions);
	}

	//
	private static MultipartFile resize(MultipartFile image, int width, int height) {
		BufferedImage resizedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage((Image) image, 0, 0, width, height, null);
		g.dispose();
		return (MultipartFile) resizedImage;
	}

	//
	private BufferedImage cropImageSquare(byte[] image) throws IOException {
		// Get a BufferedImage object from a byte array
		InputStream in = new ByteArrayInputStream(image);
		BufferedImage originalImage = ImageIO.read(in);

		// Get image dimensions
		int height = originalImage.getHeight();
		int width =  originalImage.getWidth();
		int targetSize=10;

		// The image is already a square
		if (height == width) {
			return originalImage;
		}

		// Compute the size of the square
		int squareSize = (height > width ? width : height);

		// Coordinates of the image's middle
		int xc = width / 2;
		int yc = height / 2;


		BufferedImage croppedImage = Scalr.resize(originalImage, Scalr.Method.ULTRA_QUALITY,600,Scalr.OP_ANTIALIAS);

		// Crop
		//1//
		//BufferedImage croppedImage = Scalr.resize(originalImage, Scalr.Method.SPEED, Scalr.Mode.AUTOMATIC,10,10);
		//2//
		//BufferedImage croppedImage = Scalr.resize(originalImage, Scalr.Mode.AUTOMATIC, width, height);

		//3
		//BufferedImage croppedImage = Scalr.resize(originalImage, Scalr.Method.QUALITY, width, height, Scalr.OP_ANTIALIAS) ;

		//4
		//BufferedImage croppedImage = Scalr.resize(originalImage, targetSize);

		return croppedImage;
	}

	//
	private static byte[] toByteArrayAutoClosable(BufferedImage image, String type) throws IOException {
		try (ByteArrayOutputStream out = new ByteArrayOutputStream()){
			ImageIO.write(image, type, out);
			return out.toByteArray();
		}
	}

	@Override
	public void updateDimensions(Dimensions dimensions, MultipartFile photo) throws IOException {
		BufferedImage croppedImage = cropImageSquare(photo.getBytes());


		//byte[] photoBytes = photo.getBytes();
		byte[] byteArray = toByteArrayAutoClosable(croppedImage, "jpg");

		Dimensions entity = dao.findByDID(dimensions.getDimensionId());
		if(entity!=null){
			entity.setUpdatedBy(getPrincipal());
			entity.setUpdatedOn(new Date());
			entity.setDimensionName(dimensions.getDimensionName());
			entity.setData(byteArray);
			entity.setDateOfIdea(dimensions.getDateOfIdea());
			entity.setName(dimensions.getName());
			entity.setMobileNumber(dimensions.getMobileNumber());
			entity.setEmail(dimensions.getEmail());
			entity.setCountry(dimensions.getCountry());
			entity.setDimensiondescription(dimensions.getDimensiondescription());
			entity.setPersonalOrInstitute(dimensions.getPersonalOrInstitute());
			//entity.setDimensionsDocuments(dimensions.getDimensionsDocuments());
			entity.setdControl(dimensions.getdControl());
			entity.setdMeaning(dimensions.getdMeaning());
			entity.setdExposure(dimensions.getdExposure());
			entity.setdEncouragement(dimensions.getdEncouragement());
			entity.setdTiming(dimensions.getdTiming());
			entity.setdEmpathy(dimensions.getdEmpathy());
			entity.setdObtrusiveness(dimensions.getdObtrusiveness());
			entity.setdImportance(dimensions.getdImportance());
			entity.setdDirection(dimensions.getdDirection());
			entity.setdControl(dimensions.getdControl());


		}
	}

	@Override
	public void deleteDimensionsByDID(String did) {
		dao.deleteByDID(did);
	}

	@Override
	public List<Dimensions> findAllDimensions() {
		return dao.findAllDimensions();
	}

	@Override
	public int getMaxNum() {
		return dao.getMaxNum();
	}

	@Override
	public boolean isDimensionDIDUnique(Integer id, String did) {
		Dimensions dimensions = findByDID(did);
		return ( dimensions == null || ((id != null) && (dimensions.getId() == id)));
	}

	@Override
	public List<Dimensions> findDimensionsByValues(int control, int meaning, int exposure, int encouragement, int timing, int empathy, int obtrusiveness, int importance, int direction) {
		return dao.findDimensionsByValues(control, meaning, exposure, encouragement, timing, empathy, obtrusiveness, importance, direction);
	}

	@Override
	public void insert(Dimensions dimensions, MultipartFile photo) throws IOException {
		dimensions.setCreatedBy(getPrincipal());
		dimensions.setCreatedOn(new Date());
		dao.insert(dimensions,photo);
	}

    @Override
    public List<Dimensions> review(int dControl, int dMeaning, int dExposure, int dEncouragement, int dTiming, int dEmpathy, int dObtrusiveness, int dImportance, int dDirection) {
        return dao.review(dControl,dMeaning,dExposure, dEncouragement, dTiming,dEmpathy, dObtrusiveness, dImportance, dDirection);
    }


}
