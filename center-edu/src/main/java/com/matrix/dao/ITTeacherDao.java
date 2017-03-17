package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.TTeacher;

public interface ITTeacherDao extends IBaseDao<TTeacher, Integer> {

	public TTeacher findEntityByCode(String tcode);
	
	/**
	 * 
	 * 方法: getSyllabus <br>
	 * 描述: 根据教师编码查询教师课程表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月17日 上午8:50:42
	 * @param code
	 * @return
	 */
	List<TTeacher> getSyllabus(String code);
}
