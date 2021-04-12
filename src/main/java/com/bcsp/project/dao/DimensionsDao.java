package com.bcsp.project.dao;

import com.bcsp.project.model.Dimensions;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface DimensionsDao {

	Dimensions findById(int id);

	Dimensions findByDID(String did);
	
	void save(Dimensions dimensions);

	void deleteByDID(String did);
	
	List<Dimensions> findAllDimensions();

	List<Dimensions> findDimensionsByValues(int control, int meaning, int exposure, int encouragement, int timing, int empathy, int obtrusiveness, int importance, int direction);

	List<Dimensions> findBy(int conrtol);

	List<Dimensions> findAll();

	void insert(Dimensions dimensions, MultipartFile photo) throws IOException;

	int getMaxNum();
	List<Dimensions> review(int dControl,int dMeaning, int dExposure, int dEncouragement,int dTiming, int dEmpathy,int dObtrusiveness, int dImportance, int dDirection );

}

