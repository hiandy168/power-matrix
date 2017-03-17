package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.TStudent;
import com.matrix.pojo.view.SignListView;
import com.matrix.pojo.view.StudentView;

public interface ITStudentDao extends IBaseDao<TStudent, Integer>{

	public List<SignListView> findSignList(String lcode);
	
	public List<StudentView>  findListByCodes(List<String> list); 
}
