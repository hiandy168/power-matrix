package com.matrix.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.matrix.pojo.dto.RollcallDto;
import com.matrix.pojo.entity.TStudentEvaluate;
import com.matrix.service.ITTeacherService;

@Controller
@RequestMapping("edu/teacher/")
public class TTeacherController {

	@Autowired
	private ITTeacherService service;

	/**
	 * 
	 * 方法: syllabus <br>
	 * 描述: 课程表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月17日 上午11:13:18
	 * 
	 * @param code
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "syllabus", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject syllabus(String code, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问题
		return service.syllabus(code);
	}

	/**
	 * 
	 * 方法: teacherLessons <br>
	 * 描述: 个人中心-教师-课程点评 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月17日 上午11:13:32
	 * 
	 * @param code
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "info/teacher_lessons", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject teacherLessons(String code, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问题
		return service.teacherLessons(code);
	}

	/**
	 * 
	 * 方法: lessonClassStudents <br>
	 * 描述: 获取课程班级学生列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月17日 下午4:23:16
	 * 
	 * @param scheduleCode
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "info/teacher_classstudents", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject lessonClassStudents(String scheduleCode, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问
		return service.lessonClassStudents(scheduleCode);
	}

	/**
	 * 
	 * 方法: studentEvaluateByTeacher <br>
	 * 描述: 教师对学生进行课程点评 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月17日 下午4:23:10
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "info/teacher_studentevaluate", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject studentEvaluateByTeacher(TStudentEvaluate entity, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问
		return service.studentEvaluateByTeacher(entity);
	}

	// getEvaluateDetail
	@RequestMapping(value = "student_evaluate", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject getEvaluateDetail(Integer id, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问
		return service.getEvaluateDetail(id);
	}

	@RequestMapping(value = "faq", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject faq(String code, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问
		return service.faq(code);
	}

	@RequestMapping(value = "rollcall_course_students", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject rollcallCourseStudents(String scheduleCode, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问
		return service.rollcallCourseStudents(scheduleCode);
	}

	@RequestMapping(value = "rollcall", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject rollcall(RollcallDto dto, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问
		return service.rollcall(dto);
	}

	@RequestMapping(value = "detail", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject detail(String code, HttpServletResponse response, HttpServletRequest request) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问
		return service.getTeacherDetail(code, request);
	}
}
