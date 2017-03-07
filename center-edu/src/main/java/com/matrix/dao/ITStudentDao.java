package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.TStudent;
import com.matrix.pojo.view.SignListView;

public interface ITStudentDao extends IBaseDao<TStudent, Integer>{

	public List<SignListView> findSignList(String lcode);
}
