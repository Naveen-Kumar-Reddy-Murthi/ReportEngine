package org.mnr.dao;

import java.util.List;

import org.mnr.entity.ReportScheuduleEntity;

/**
 * @author naveen.reddy
 * @version 1.0
 */
public interface ReportDAO {

	void save(ReportScheuduleEntity entity);

	void update(ReportScheuduleEntity entity);

	void delete(int id);

	ReportScheuduleEntity getById(int id);

	List<ReportScheuduleEntity> getAll();

}
