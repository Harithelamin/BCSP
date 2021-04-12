package com.bcsp.project.dao;

import com.bcsp.project.model.DimensionsDocument;

import java.util.List;

public interface DimensionsDocumentDao {

	List<DimensionsDocument> findAll();

	DimensionsDocument findById(int id);
	
	void save(DimensionsDocument document);
	
	List<DimensionsDocument> findAllByPatientId(int patientId);
	
	void deleteById(int id);
}
