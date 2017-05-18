package com.matrix.service;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.interfaces.IBaseService;
import com.matrix.pojo.entity.McUserInfo;

public interface IMcUserInfoService extends IBaseService<McUserInfo, Integer> { 
	public JSONObject login(McUserInfo userInfo , HttpSession session);

	public JSONObject addSysUser(McUserInfo info);

	public JSONObject editSysUser(McUserInfo info);

	public JSONObject deleteUser(Integer id);      
	
}
