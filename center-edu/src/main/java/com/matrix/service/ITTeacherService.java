package com.matrix.service;

import com.alibaba.fastjson.JSONObject;
import com.matrix.pojo.entity.TStudentEvaluate;

/**
 * 
 * 类: ITTeacherService <br>
 * 描述: 教师相关业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月18日 下午7:40:27
 */
public interface ITTeacherService {

	/**
	 * 
	 * 方法: teacherLessons <br>
	 * 描述: 个人中心-教师-课程点评 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月17日 上午11:08:27
	 * 
	 * @param code
	 * @return
	 */
	JSONObject teacherLessons(String code);

	/**
	 * 
	 * 方法: lessonClassStudents <br>
	 * 描述: 根据课程编码，班级编码查询学生列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月17日 下午12:54:23
	 * 
	 * @param lessoncCode
	 * @param classCode
	 * @return
	 */
	JSONObject lessonClassStudents(String scheduleCode);

	/**
	 * 
	 * 方法: studentEvaluateByTeacher <br>
	 * 描述: 教师对学生进行课程点评 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月17日 下午4:19:56
	 * 
	 * @param entity
	 * @return
	 */
	JSONObject studentEvaluateByTeacher(TStudentEvaluate entity);
	/**
	 * 
	 * 方法: syllabus <br>
	 * 描述: 获取教师课程表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月18日 下午7:39:16
	 * @return
	 */
	JSONObject syllabus(String code);
	
	
	/**
	 * 
	 * 方法: faq <br>
	 * 描述: 答疑列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月18日 下午7:40:57
	 * @param teacherCode
	 * @return
	 */
	JSONObject faq(String code);
}
