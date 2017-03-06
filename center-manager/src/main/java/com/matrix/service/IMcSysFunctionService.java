package com.matrix.service;

import javax.servlet.http.HttpSession;


import com.alibaba.fastjson.JSONObject;
import com.matrix.base.interfaces.IBaseService;
import com.matrix.pojo.entity.McSysFunction;

public interface IMcSysFunctionService  extends IBaseService<McSysFunction, Integer> {

	public JSONObject addInfo(McSysFunction entity , HttpSession session);
	
	public JSONObject editInfo(McSysFunction entity , HttpSession session);

	public JSONObject updateTreeNodes(String ustring, HttpSession session); 
	
}