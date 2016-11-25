package com.matrix.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseServiceImpl;
import com.matrix.dao.IMcUserInfoDao;
import com.matrix.pojo.entity.McUserInfo;
import com.matrix.service.IMcUserInfoService;


/**
 * @description: 后台用户登录、退出等等操作
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2016年11月25日 下午3:30:37 
 * @version 1.0.0
 */
@Service("mcUserInfo") 
public class McUserInfoServiceImpl extends BaseServiceImpl<McUserInfo, Integer> implements IMcUserInfoService{
	@Resource
	private IMcUserInfoDao mcUserInfoDao;
	
	/**
	 * @description: 用户登录操作
	 * 
	 * @param userInfo
	 * @param session
	 * @author Yangcl 
	 * @date 2016年11月25日 下午3:51:36 
	 * @version 1.0.0.1
	 */
	public JSONObject login(McUserInfo userInfo , HttpSession session) {
		JSONObject result = new JSONObject();
		if (StringUtils.isBlank(userInfo.getUserName()) || StringUtils.isBlank(userInfo.getPassword())) {
			result.put("status", "error");
			result.put("msg", "用户名或密码不得为空");
			return result;
		}
		McUserInfo info = mcUserInfoDao.login(userInfo);  
		if (null != info) {
			session.setAttribute("userInfo", info);   // 写入session
			result.put("data", info);
			result.put("status", "success");
			result.put("msg", "调用成功");
			return result;
		} else {
			result.put("status", "error");
			result.put("msg", "用户名或密码错误");
			return result;
		}
	}
}




























