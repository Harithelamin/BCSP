package com.bcsp.project.service;


import com.bcsp.project.dao.DimensionsDocumentDao;
import com.bcsp.project.model.DimensionsDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("DimensionsDocumentService")
@Transactional
public class DimensionsDocumentServiceImpl implements DimensionsDocumentService {

	@Autowired
	DimensionsDocumentDao dao;


	@Override
	public DimensionsDocument findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<DimensionsDocument> findAll() {
		return null;
	}

	@Override
	public List<DimensionsDocument> findAllByDimensionId(int id) {
		return null;
	}

	@Override
	public void saveDocument(DimensionsDocument document) {

	}

	@Override
	public void deleteById(int id) {

	}
}
