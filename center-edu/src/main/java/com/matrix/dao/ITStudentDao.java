package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.TStudent;
import com.matrix.pojo.view.SignListView;
import com.matrix.pojo.view.StudentView;

public interface ITStudentDao extends IBaseDao<TStudent, Integer> {

	public List<SignListView> findSignList(String lcode);

	public List<StudentView> findListByCodes(List<String> list);

	/**
	 * 
	 * 方法: findStudentSignByLessonAndClass <br>
	 * 描述: 根据scheduleCode查询学生签到信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月17日 下午2:11:30
	 * 
	 * @param scheduleCode
	 * @return
	 */
	List<TStudent> findStudentSignByScheduleCode(String scheduleCode);

	/**
	 * 
	 * 方法: getSyllabus <br>
	 * 描述: 课程表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月18日 下午8:12:38
	 * 
	 * @param code
	 * @return
	 */
	List<TStudent> getSyllabus(String code);

	/**
	 * 
	 * 方法: findStudentSignByScheduleCodeForRollcall <br>
	 * 描述: 根据scheduleCode查询学生签到信息-随机点名 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月21日 下午4:39:21
	 * 
	 * @param scheduleCode
	 * @return
	 */
	List<TStudent> findStudentSignByScheduleCodeForRollcall(String scheduleCode);

	/**
	 * 
	 * 方法: getStudentDetail <br>
	 * 描述: 根据编码查询学生详情 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月21日 下午5:23:30
	 * 
	 * @param code
	 * @return
	 */
	TStudent getStudentDetail(String code);
}
