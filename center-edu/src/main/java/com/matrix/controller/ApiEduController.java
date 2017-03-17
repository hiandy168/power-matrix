package com.matrix.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.matrix.pojo.dto.ExamPaperDto;
import com.matrix.pojo.dto.RegisteDto;
import com.matrix.pojo.entity.TStudentEvaluate;
import com.matrix.pojo.entity.TStudySchedule;
import com.matrix.pojo.entity.TTeacher;
import com.matrix.pojo.entity.TUser;
import com.matrix.pojo.model.Answer;
import com.matrix.service.IEducationalService;

@Controller
@RequestMapping("edu")
public class ApiEduController {

	private static Logger logger = Logger.getLogger(ApiEduController.class);

	@Autowired
	private IEducationalService service;

	/**
	 * @description: 获取签到学生列表
	 * @test: http://localhost:8080/matrix-admin/edu/sign_list.do?lcode=l1
	 * 
	 * @param lcode
	 *            lesson code
	 * @return
	 * @author Yangcl
	 * @date 2017年3月7日 下午2:43:02
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "sign_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject signList(String scheduleCode, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问题

		return service.findSignList(scheduleCode);
	}

	/**
	 * @descriptions 教师开课接口
	 *
	 * @date 2017年3月7日 下午11:37:10
	 * @author Yangcl
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "start_lesson", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject startLesson(String tcode, String scheduleCode, HttpServletResponse response,
			HttpServletRequest request) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return service.startLesson(tcode, scheduleCode, request);
	}

	@RequestMapping(value = "student_sign", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject studentSign(String scode, String scheduleCode, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问题
		return service.studentSign(scode, scheduleCode);
	}

	@RequestMapping(value = "login", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject login(TUser entity, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问题
		return service.login(entity);
	}

	@RequestMapping(value = "register", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject registe(RegisteDto entity, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问题
		return service.registe(entity);
	}

	/**
	 * @description: 生成二维码时所需的课程列表
	 * 
	 * @param entity
	 * @param response
	 * @author Yangcl
	 * @date 2017年3月10日 下午8:57:22
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "lesson_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject lessonList(TTeacher entity, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问题
		return service.lessonList(entity);
	}

	/**
	 * @description: 查看签到时所需的课程列表
	 * 
	 * @param entity
	 * @param response
	 * @author Yangcl
	 * @date 2017年3月10日 下午8:56:53
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "sign_lesson_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject signLessonList(TTeacher entity, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问题
		return service.signLessonList(entity);
	}

	/**
	 * @descriptions 题库列表页面 - 学生
	 *
	 * @param entity
	 * @param response
	 * @return
	 * @date 2017年3月11日 下午9:00:21
	 * @author Yangcl
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "question_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject questionList(String studentCode, String paperCode, String qcodes, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问题
		return service.questionList(studentCode, paperCode, qcodes);
	}

	/**
	 * @descriptions 题库列表页面 - 教师
	 *
	 * @param lessonCode
	 * @param response
	 * @return
	 * @date 2017年3月16日 下午10:26:16
	 * @author Yangcl
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "question_list_teacher", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject questionListTeacher(String lessonCode, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问题
		return service.questionListTeacher(lessonCode);
	}

	@RequestMapping(value = "lesson_schedule_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject lessonScheduleList(TStudySchedule e, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问题
		return service.lessonScheduleList(e);
	}

	@RequestMapping(value = "exam_paper_insert", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject examPaperInsert(String json, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问题

		ExamPaperDto d = JSONObject.parseObject(json, ExamPaperDto.class);
		return service.examPaperInsert(d);
	}

	/**
	 * @descriptions 学生的排课列表
	 *
	 * @param classesCode
	 * @return
	 * @date 2017年3月15日 下午11:03:47
	 * @author Yangcl
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "student_schedule_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject studentScheduleList(String classesCode, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问题
		return service.studentScheduleList(classesCode);
	}

	/**
	 * @description: 学生在某一节课的试卷列表，一节课可以包含多个课堂测验试卷
	 * 
	 * @param scheduleCode
	 *            t_exam_paper 的 schedule_code
	 * @param response
	 * @return
	 * @author Yangcl
	 * @date 2017年3月16日 上午11:36:56
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "student_paper_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject studentPaperList(String scheduleCode, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问题
		return service.studentPaperList(scheduleCode);
	}

	@RequestMapping(value = "student_insert_answer", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject studentInsertAnswer(String paperCode, String studentCode, String answers,
			HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问题
		List<Answer> ans = JSONObject.parseArray(answers, Answer.class);
		return service.studentInsertAnswer(paperCode, studentCode, answers);
	}

	/**
	 * @descriptions 查看测验时的班级学生列表 htm/inspection/list.html
	 *
	 * @param classCodes
	 * @param response
	 * @return
	 * @date 2017年3月16日 下午11:56:51
	 * @author Yangcl
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "class_student_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject classStudentList(String classCodes, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问题
		return service.classStudentList(classCodes);
	}

	/**
	 * 
	 * 方法: teacherSyllabus <br>
	 * 描述: 个人中心-教师-课程表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月17日 上午11:13:18
	 * 
	 * @param code
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "info/teacher_syllabus", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject teacherSyllabus(String code, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问题
		return service.teacherSyllabus(code);
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
	public JSONObject studentEvaluateByTeacher(TStudentEvaluate entity) {
		return service.studentEvaluateByTeacher(entity);
	}
}