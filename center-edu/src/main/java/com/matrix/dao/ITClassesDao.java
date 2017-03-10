package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.TClasses;

public interface ITClassesDao extends IBaseDao<TClasses, Integer>{ 
	public List<TClasses> findAllClasses();
}
