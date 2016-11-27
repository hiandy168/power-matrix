package com.matrix.service.impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseServiceImpl;
import com.matrix.dao.IUserDemoDao;
import com.matrix.pojo.entity.UserDemo;
import com.matrix.service.IExampleService;
import com.matrix.util.SignUtil;

@Service("exampleService")
public class ExampleServiceImpl  extends BaseServiceImpl<UserDemo, Integer> implements IExampleService {
	@Resource
	private IUserDemoDao userDemoDao;

	public JSONObject addInfo(UserDemo entity, HttpSession session) {
		JSONObject result = new JSONObject();
		String pass = SignUtil.md5Sign(entity.getPassword());
		entity.setPassword(pass); 
		entity.setCreateTime(new Date());
		Integer count = userDemoDao.insertSelective(entity);
		if(count == 1){
			result.put("status", true);
			result.put("msg", "数据插入成功！");
		}else{
			result.put("status", false);
			result.put("msg", "数据插入异常！");
		}
		return result;
	}
	
	
}
