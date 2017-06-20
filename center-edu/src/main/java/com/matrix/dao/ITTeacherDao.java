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
	 * 
	 * @param code
	 * @return
	 */
	List<TTeacher> getSyllabus(String code);

	/**
	 * 
	 * 方法: getLessons <br>
	 * 描述: 获取教师授课列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月17日 上午11:06:16
	 * 
	 * @param code
	 * @return
	 */
	List<TTeacher> getLessons(String code);

	/**
	 * 
	 * 方法: getTeacherDetail <br>
	 * 描述: 根据编码查询教师详情 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月21日 下午5:37:15
	 * 
	 * @param code
	 * @return
	 */
	TTeacher getTeacherDetail(String code);
}
