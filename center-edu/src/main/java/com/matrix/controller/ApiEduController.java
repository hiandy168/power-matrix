package com.matrix.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.matrix.pojo.dto.RegisteDto;
import com.matrix.pojo.entity.TStudySchedule;
import com.matrix.pojo.entity.TTeacher;
import com.matrix.pojo.entity.TUser;
import com.matrix.service.IEducationalService;

@Controller
@RequestMapping("edu")
public class ApiEduController {
	
	private static Logger logger=Logger.getLogger(ApiEduController.class);

	@Autowired
	private IEducationalService service;
	
	/**
	 * @description: 获取签到学生列表
	 * @test: http://localhost:8080/matrix-admin/edu/sign_list.do?lcode=l1
	 * 
	 * @param lcode lesson code
	 * @return
	 * @author Yangcl 
	 * @date 2017年3月7日 下午2:43:02 
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "sign_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject signList(String scheduleCode , HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");  // 临时性解决跨域访问限制问题
		
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
	public JSONObject startLesson(String tcode , String lcode , HttpServletResponse response , HttpServletRequest request){
		response.setHeader("Access-Control-Allow-Origin", "*"); 
		return service.startLesson(tcode, lcode , request);
	}
	
	@RequestMapping(value = "student_sign", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject studentSign(String scode, String lcode, HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");  // 临时性解决跨域访问限制问题
		return service.studentSign(scode, lcode);
	}
	
	@RequestMapping(value = "login", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject login(TUser entity , HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");  // 临时性解决跨域访问限制问题
		return service.login(entity);  
	}
	
	@RequestMapping(value = "register", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject registe(RegisteDto entity , HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");  // 临时性解决跨域访问限制问题
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
	public JSONObject lessonList(TTeacher entity , HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");  // 临时性解决跨域访问限制问题
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
	public JSONObject signLessonList(TTeacher entity , HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");  // 临时性解决跨域访问限制问题
		return service.signLessonList(entity);  
	}
	
	/**
	 * @descriptions
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
	public JSONObject questionList(String lessonCode , HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");  // 临时性解决跨域访问限制问题
		return service.questionList(lessonCode);    
	}
	
	
	@RequestMapping(value = "lesson_schedule_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject lessonScheduleList(TStudySchedule e , HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");  // 临时性解决跨域访问限制问题
		return service.lessonScheduleList(e);    
	}
	
}






































