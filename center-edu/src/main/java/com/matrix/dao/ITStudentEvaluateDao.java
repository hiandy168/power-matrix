package com.matrix.dao;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.TStudentEvaluate;

public interface ITStudentEvaluateDao extends IBaseDao<TStudentEvaluate, Integer> {

	TStudentEvaluate selectByPrimaryIds(Integer id);
}