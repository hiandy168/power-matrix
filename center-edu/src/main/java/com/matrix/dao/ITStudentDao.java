package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.TStudent;
import com.matrix.pojo.view.SignListView;
import com.matrix.pojo.view.StudentView;

public interface ITStudentDao extends IBaseDao<TStudent, Integer> {

	public List<SignListView> findSignList(String lcode);
	
	public List<StudentView>  findListByCodes(List<String> list); 

	/**
	 * 
	 * 方法: findStudentSignByLessonAndClass <br>
	 * 描述: 根据课程编码，班级编码查询学生签到信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月17日 下午2:11:30
	 * 
	 * @param scheduleCode
	 * @return
	 */
	List<TStudent> findStudentSignByLessonAndClass(String scheduleCode);
}
