package com.matrix.dao;

import java.util.List;
import java.util.Map;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.TExamPaper;

public interface ITExamPaperDao extends IBaseDao<TExamPaper, Integer> {

	public List<TExamPaper> findListByScheduleCode(String scheduleCode);   

	public List<TExamPaper> findListByMap(Map<String , String> map);
}
