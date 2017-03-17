package com.matrix.service;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.matrix.pojo.dto.ExamPaperDto;
import com.matrix.pojo.dto.RegisteDto;
import com.matrix.pojo.entity.TStudentEvaluate;
import com.matrix.pojo.entity.TStudySchedule;
import com.matrix.pojo.entity.TTeacher;
import com.matrix.pojo.entity.TUser;

public interface IEducationalService {
	/**
	 * @description: 获取签到列表
	 * 
	 * @param tcode
	 *            teacher code
	 * @param lcode
	 *            lesson code
	 * @return
	 * @author Yangcl
	 * @date 2017年3月7日 下午2:01:34
	 * @version 1.0.0.1
	 */
	public JSONObject findSignList(String scheduleCode);

	/**
	 * @descriptions 教师开课
	 *
	 * @param tcode
	 *            teacher code
	 * @param lcode
	 *            lesson code
	 * @date 2017年3月7日 下午11:03:14
	 * @author Yangcl
	 * @version 1.0.0.1
	 */
	public JSONObject startLesson(String tcode, String scheduleCode, HttpServletRequest request);

	/**
	 * @description: 学生签到接口
	 * 
	 * @param scode
	 *            学生编码
	 * @param lcode
	 *            课程编码
	 * @param request
	 * @return
	 * @author Yangcl
	 * @date 2017年3月8日 下午4:47:00
	 * @version 1.0.0.1
	 */
	public JSONObject studentSign(String scode, String scheduleCode);

	public JSONObject login(TUser entity);

	public JSONObject registe(RegisteDto entity);

	public JSONObject lessonList(TTeacher entity);

	public JSONObject signLessonList(TTeacher entity);

	public JSONObject questionList(String studentCode, String paperCode, String qcodes);

	public JSONObject lessonScheduleList(TStudySchedule e);

	public JSONObject examPaperInsert(ExamPaperDto d);

	public JSONObject studentScheduleList(String classesCode);

	public JSONObject studentPaperList(String scheduleCode);

	public JSONObject studentInsertAnswer(String paperCode, String studentCode, String answers);

	public JSONObject questionListTeacher(String lessonCode);

	public JSONObject classStudentList(String classCodes);

	public JSONObject inspectStudentPaperList(String scheduleCode, String studentCode);               
 

	/**
	 * 
	 * 方法: teacherSyllabus <br>
	 * 描述: 个人中心-教师-课程表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月17日 上午9:06:37
	 * 
	 * @param code
	 * @return
	 */
	JSONObject teacherSyllabus(String code);

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
}
