package org.mnr.service;

import java.util.List;

import javax.persistence.Transient;

import org.mnr.dao.ReportDAO;
import org.mnr.entity.ReportScheuduleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author naveen.reddy
 * @version 1.0
 */
@Service(value = "reportService")
public class ReportServiceImpl implements ReportService {

	@Autowired
	ReportDAO reportDao;

	public void setReportDao(ReportDAO reportDao) {
		this.reportDao = reportDao;
	}

	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void saveOrUpdate(ReportScheuduleEntity entity) {
		if (getById(entity.getId()) == null) {
			reportDao.save(entity);
		} else {
			reportDao.update(entity);
		}

	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void delete(int id) {
		reportDao.delete(id);

	}

	@Override
	public ReportScheuduleEntity getById(int id) {

		return reportDao.getById(id);
	}

	@Override
	public List<ReportScheuduleEntity> getAll() {

		return reportDao.getAll();
	}

}
