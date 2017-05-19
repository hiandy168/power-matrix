package com.matrix.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import com.alibaba.fastjson.JSONObject;
import com.matrix.base.interfaces.IBaseService;
import com.matrix.pojo.cache.McRoleCache;
import com.matrix.pojo.dto.McUserRoleDto;
import com.matrix.pojo.entity.McSysFunction;
import com.matrix.pojo.entity.McUserInfo;
import com.matrix.pojo.entity.McUserRole;

public interface IMcSysFunctionService  extends IBaseService<McSysFunction, Integer> {

	public JSONObject addInfo(McSysFunction entity , HttpSession session);
	
	public JSONObject editInfo(McSysFunction entity , HttpSession session);

	public JSONObject updateTreeNodes(String ustring, HttpSession session);

	public JSONObject treeList(HttpServletRequest request);

	public JSONObject deleteNode(Integer id, HttpSession session);

	public JSONObject addMcRole(McRoleCache d, HttpSession session);

	public JSONObject editMcRole(McRoleCache d, HttpSession session);

	public JSONObject deleteMcRole(McRoleCache d, HttpSession session);

	public JSONObject addUserRole(McUserRole entity , HttpSession session);

//	public JSONObject mcUserList(McUserInfo entity, HttpServletRequest request);

	public JSONObject userRoleFuncList(McUserRoleDto dto, HttpServletRequest request);

	public JSONObject deleteUserRole(McUserRoleDto d, HttpSession session);          
	
}
