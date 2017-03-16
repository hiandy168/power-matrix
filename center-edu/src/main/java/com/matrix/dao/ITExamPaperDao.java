package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.TExamPaper;

public interface ITExamPaperDao extends IBaseDao<TExamPaper, Integer> {

	List<TExamPaper> findListByScheduleCode(String scheduleCode);   

}
