package com.bcsp.project.service;



import com.bcsp.project.model.Dimensions;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface DimensionsService {

	Dimensions findById(int id);

	Dimensions findByDID(String did);
	
	void saveDimensions(Dimensions dimensions);
	
	void updateDimensions(Dimensions dimensions, MultipartFile photo) throws IOException;

	void deleteDimensionsByDID(String did);

	List<Dimensions> findAllDimensions();

	int getMaxNum();
	
	boolean isDimensionDIDUnique(Integer id, String did);

	List<Dimensions> findDimensionsByValues(int control, int meaning, int exposure, int encouragement, int timing, int empathy, int obtrusiveness, int importance, int direction);

	void insert(Dimensions dimensions, MultipartFile photo) throws IOException;

    List<Dimensions> review(int dControl,int dMeaning, int dExposure, int dEncouragement,int dTiming, int dEmpathy,int dObtrusiveness, int dImportance, int dDirection );

}