package com.bcsp.project.dao;


import com.bcsp.project.model.DimensionsDocument;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dimensionsDocumentDao")
public class DimensionsDocumentDaoImpl extends AbstractDao<Integer, DimensionsDocument> implements DimensionsDocumentDao {

	@SuppressWarnings("unchecked")
	public List<DimensionsDocument> findAll() {
		Criteria crit = createEntityCriteria();
		return (List<DimensionsDocument>)crit.list();
	}

	public void save(DimensionsDocument document) {
		persist(document);
	}

	
	public DimensionsDocument findById(int id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	public List<DimensionsDocument> findAllByPatientId(int dimensionsId){
		Criteria crit = createEntityCriteria();
		Criteria patientCriteria = crit.createCriteria("dimensions");
		patientCriteria.add(Restrictions.eq("id", dimensionsId));
		return (List<DimensionsDocument>)crit.list();
	}

	
	public void deleteById(int id) {
		DimensionsDocument document =  getByKey(id);
		delete(document);
	}

}
