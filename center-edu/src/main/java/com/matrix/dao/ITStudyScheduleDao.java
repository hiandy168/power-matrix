package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.TStudySchedule;
import com.matrix.pojo.view.StudyScheduleView;

public interface ITStudyScheduleDao extends IBaseDao<TStudySchedule, Integer> {  

	public List<StudyScheduleView> findListByType(TStudySchedule entity); 
}
