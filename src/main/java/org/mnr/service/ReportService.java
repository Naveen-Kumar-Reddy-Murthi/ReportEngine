package org.mnr.service;

import java.util.List;
import org.mnr.entity.ReportScheuduleEntity;

/**
 * @author naveen.reddy
 * @version 1.0
 */
public interface ReportService {

	void saveOrUpdate(ReportScheuduleEntity entity);

	void delete(int id);

	ReportScheuduleEntity getById(int id);

	List<ReportScheuduleEntity> getAll();

}
