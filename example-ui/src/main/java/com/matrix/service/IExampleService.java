package com.matrix.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.interfaces.IBaseService;
import com.matrix.pojo.entity.UserDemo;

public interface IExampleService  extends IBaseService<UserDemo, Integer> {

	public JSONObject addInfo(UserDemo entity , HttpSession session);
	
	public JSONObject deleteOne(UserDemo entity);

	public JSONObject ajaxUploadFileCfile(String type , HttpServletRequest request);  
}
