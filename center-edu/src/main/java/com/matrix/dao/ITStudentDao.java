package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.dto.LessonSignDto;
import com.matrix.pojo.entity.TStudent;
import com.matrix.pojo.view.SignListView;

public interface ITStudentDao extends IBaseDao<TStudent, Integer> {

	public List<SignListView> findSignList(String lcode);

	/**
	 * 
	 * 方法: findStudentSignByLessonAndClass <br>
	 * 描述: 根据课程编码，班级编码查询学生签到信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月17日 下午2:11:30
	 * 
	 * @param dto
	 * @return
	 */
	List<TStudent> findStudentSignByLessonAndClass(LessonSignDto dto);
}
