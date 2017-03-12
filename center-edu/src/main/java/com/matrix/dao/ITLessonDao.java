package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.TLesson;
import com.matrix.pojo.view.LessonView;

public interface ITLessonDao extends IBaseDao<TLesson, Integer>{ 
	public TLesson findEntityByCode(String lcode);
	
	
	public List<LessonView> findLessonListByTcode(String tcode);
	
	public List<LessonView> findClassLessonListByTcode(String tcode);
}
