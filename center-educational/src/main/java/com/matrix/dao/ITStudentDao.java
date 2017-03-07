package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.TStudent;

public interface ITStudentDao extends IBaseDao<TStudent, Integer>{

	public List<TStudent> findSignList(String lcode);
}
