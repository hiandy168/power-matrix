package com.matrix.dao;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.TLesson;

public interface ITLessonDao extends IBaseDao<TLesson, Integer>{ 
	public TLesson findEntityByCode(String lcode);
}
