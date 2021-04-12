package com.bcsp.project.dao;

import com.bcsp.project.model.Dimensions;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.persistence.NonUniqueResultException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Repository("diminsionDao")
public class DimensionsDaoImpl extends AbstractDao<Integer, Dimensions> implements DimensionsDao {

    Session session = null;
    Transaction transaction = null;

    @Override
    public Dimensions findById(int id) throws NonUniqueResultException
    {
        Dimensions dimensions = getByKey(id);
        return dimensions;
    }

    @Override
    public Dimensions findByDID(String did)
    {
       // System.out.println("DID : "+did);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("dimensionId", did));
        Dimensions dimensions = (Dimensions) crit.uniqueResult();
        return dimensions;
    }

    @Override
    public void save(Dimensions dimensions)
    {

            persist(dimensions);

    }

    @Override
    public void deleteByDID(String did)
    {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("dimensionId", did));
        Dimensions dimensions = (Dimensions) crit.uniqueResult();
        delete(dimensions);

    }




    @Override
    public List<Dimensions> findAllDimensions()
    {
        byte[] repCurrentImage = null;
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("dateOfIdea"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Dimensions> dimensionss = (List<Dimensions>) criteria.list();
        return dimensionss;
    }

    @Override
    public List<Dimensions> findDimensionsByValues(int control, int meaning, int exposure, int encouragement, int timing, int empathy, int obtrusiveness, int importance, int direction) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("dimensionId", control));
        crit.add(Restrictions.eq("dimensionId", meaning));
        crit.add(Restrictions.eq("dimensionId", exposure));
        crit.add(Restrictions.eq("dimensionId", encouragement));
        crit.add(Restrictions.eq("dimensionId", timing));
        crit.add(Restrictions.eq("dimensionId", empathy));
        crit.add(Restrictions.eq("dimensionId", obtrusiveness));
        crit.add(Restrictions.eq("dimensionId", importance));
        crit.add(Restrictions.eq("dimensionId", direction));
        List<Dimensions> dimensionsList = (List<Dimensions>) crit.list();
        return dimensionsList;
    }

    @Override
    public List<Dimensions> findBy(int conrtol) {
        //session = getSession().getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<Dimensions> dimensionsList = session.createQuery("SELECT * FROM Dimension" ).list();
        return dimensionsList;
    }

    @Override
    public List<Dimensions> findAll() {
        String hql = "FROM Dimensions D WHERE D.id = 1";
        Query query= getSession().createQuery(hql);
        List results = query.list();
        return results;
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
    //
    @Override
    public void insert(Dimensions dimensions, MultipartFile photo) throws IOException {


        //
        // Crop the image (uploadfile is an object of type MultipartFile)
        BufferedImage croppedImage = cropImageSquare(photo.getBytes());


        //byte[] photoBytes = photo.getBytes();
        byte[] byteArray = toByteArrayAutoClosable(croppedImage, "jpg");
       // byte[] photoBytes = c.getBytes();
        String BCSBcode="BCSB" + getMaxNum();
        dimensions.setDimensionId(BCSBcode);
        dimensions.setData(byteArray);

        persist(dimensions);
    }

    @Override
    public int getMaxNum() {
        String hql = "SELECT COALESCE(MAX(id),0) FROM Dimensions";
        Query query= getSession().createQuery(hql);
        int results = ((int) query.uniqueResult())+1 ;
        return results;
    }

    @Override
    public List<Dimensions> review(int dControl, int dMeaning, int dExposure, int dEncouragement, int dTiming, int dEmpathy, int dObtrusiveness, int dImportance, int dDirection) {

        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("dControl", dControl));
        crit.add(Restrictions.eq("dMeaning", dMeaning));
        crit.add(Restrictions.eq("dExposure", dExposure));
        crit.add(Restrictions.eq("dEncouragement", dEncouragement));
        crit.add(Restrictions.eq("dTiming", dTiming));
        crit.add(Restrictions.eq("dEmpathy", dEmpathy));
        crit.add(Restrictions.eq("dObtrusiveness", dObtrusiveness));
        crit.add(Restrictions.eq("dImportance", dImportance));
        crit.add(Restrictions.eq("dDirection", dDirection));
        List<Dimensions> dimensions = (List<Dimensions>) crit.list();
        return dimensions;




        //String hql = "FROM Dimensions D WHERE D.dControl = dControl";
        //Query query= getSession().createQuery(hql);
        //List results = query.list();
        //return results;
    }
}
