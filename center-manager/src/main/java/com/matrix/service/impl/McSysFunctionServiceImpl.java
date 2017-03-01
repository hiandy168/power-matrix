package com.matrix.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseServiceImpl;
import com.matrix.dao.IMcSysFunctionDao;
import com.matrix.pojo.entity.McSysFunction;
import com.matrix.pojo.entity.McUserInfo;
import com.matrix.service.IMcSysFunctionService;

@Service("mcSysFunctionService") 
public class McSysFunctionServiceImpl extends BaseServiceImpl<McSysFunction, Integer> implements IMcSysFunctionService {

	@Resource
	private IMcSysFunctionDao dao;
	
	
	@Override
	public JSONObject addInfo(McSysFunction entity, HttpSession session) {
		JSONObject result = new JSONObject();
		if(StringUtils.isNotBlank(entity.getName()) && StringUtils.isNotBlank(entity.getParentId()) ){
			McUserInfo userInfo = (McUserInfo) session.getAttribute("userInfo");
			entity.setCreateTime(new Date());
			entity.setUpdateTime(new Date());
			entity.setCreateUserId(userInfo.getId());
			entity.setUpdateUserId(userInfo.getId());
			int count = dao.insertSelective(entity);
			if(count == 1){
				result.put("status", "success");
				result.put("msg", "添加成功!");
			}else{
				result.put("status", "error");
				result.put("msg", "添加失败!");
			}
		}else{
			result.put("status", "error");
			result.put("msg", "功能名称|父节点不能为空!");
		}
		
		return result;
	}


	@Override
	public JSONObject editInfo(McSysFunction entity, HttpSession session) {
		JSONObject result = new JSONObject();
		if(StringUtils.isNotBlank(entity.getName())){
			McUserInfo userInfo = (McUserInfo) session.getAttribute("userInfo");
			entity.setUpdateTime(new Date());
			entity.setUpdateUserId(userInfo.getId());
			int count = dao.updateSelective(entity);
			if(count == 1){
				result.put("status", "success");
				result.put("msg", "修改成功!");
			}else{
				result.put("status", "error");
				result.put("msg", "修改失败!");
			}
		}else{
			result.put("status", "error");
			result.put("msg", "功能名称不能为空!");
		}
		
		return result;
	}


}
