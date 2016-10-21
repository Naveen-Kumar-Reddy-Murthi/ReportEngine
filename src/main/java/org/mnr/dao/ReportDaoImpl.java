package org.mnr.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.mnr.entity.ReportScheuduleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author naveen.reddy
 * @version 1.0
 */
@Repository(value = "reportDaoImpl")
public class ReportDaoImpl implements ReportDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(ReportScheuduleEntity entity) {
		sessionFactory.getCurrentSession().save(entity);

	}

	@Override
	public void update(ReportScheuduleEntity entity) {
		sessionFactory.getCurrentSession().update(entity);

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ReportScheuduleEntity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReportScheuduleEntity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
