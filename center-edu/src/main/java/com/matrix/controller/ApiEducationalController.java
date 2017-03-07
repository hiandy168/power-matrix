package com.matrix.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONObject;
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
	private JSONObject signList(String lcode , HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");  // 临时性解决跨域访问限制问题
		
		return service.findSignList(null, lcode);
	}
	
}







