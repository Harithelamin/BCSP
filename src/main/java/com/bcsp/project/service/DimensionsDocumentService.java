package com.bcsp.project.service;



import com.bcsp.project.model.DimensionsDocument;

import java.util.List;

public interface DimensionsDocumentService {

	DimensionsDocument findById(int id);

	List<DimensionsDocument> findAll();
	
	List<DimensionsDocument> findAllByDimensionId(int id);
	
	void saveDocument(DimensionsDocument document);
	
	void deleteById(int id);
}
