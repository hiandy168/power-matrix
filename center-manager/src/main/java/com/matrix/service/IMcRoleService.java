package com.matrix.service;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.interfaces.IBaseService;
import com.matrix.pojo.entity.McRole;

public interface IMcRoleService extends IBaseService<McRole, Integer> {

	JSONObject addMcRole(McRole info , HttpSession session);

	JSONObject editSysRole(McRole info, HttpSession session);   

}
