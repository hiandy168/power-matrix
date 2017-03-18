package com.matrix.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.matrix.service.ITStudentService;

@Controller
@RequestMapping("edu/student/")
public class TStudentController {

	@Autowired
	private ITStudentService service;

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
	 * 方法: faq <br>
	 * 描述: 查询答疑列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月18日 下午8:48:23
	 * 
	 * @param code
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "faq", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject faq(String code, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问题
		return service.faq(code);
	}

	/**
	 * 
	 * 方法: faqAnswer <br>
	 * 描述: 查询答疑回答列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月18日 下午9:58:26
	 * 
	 * @param code
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "faq_answer", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject faqAnswer(String code, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); // 临时性解决跨域访问限制问题
		return service.faqAnswer(code);
	}
}
