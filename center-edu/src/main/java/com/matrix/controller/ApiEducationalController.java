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
import com.matrix.pojo.entity.TTeacher;
import com.matrix.pojo.entity.TUser;
import com.matrix.service.IEducationalService;

@Controller
@RequestMapping("edu")
public class ApiEducationalController {
	
	private static Logger logger=Logger.getLogger(ApiEducationalController.class);

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
	public JSONObject signList(String lcode , HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");  // 临时性解决跨域访问限制问题
		
		return service.findSignList(null, lcode);
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
	
	@RequestMapping(value = "registe", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject registe(RegisteDto entity , HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");  // 临时性解决跨域访问限制问题
		return service.registe(entity);  
	}
	
	@RequestMapping(value = "lesson_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject lessonList(TTeacher entity , HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");  // 临时性解决跨域访问限制问题
		return service.lessonList(entity);  
	}
}






































