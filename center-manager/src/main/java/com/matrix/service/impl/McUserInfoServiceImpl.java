package com.matrix.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseServiceImpl;
import com.matrix.cache.CacheLaunch;
import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.inf.IBaseLaunch;
import com.matrix.cache.inf.ICacheFactory;
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
	
	private IBaseLaunch<ICacheFactory> launch = CacheLaunch.getInstance().Launch();
	
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
			String userId = info.getId().toString(); 
		    String pageJson = launch.loadDictCache(DCacheEnum.McUserRole).getCache(userId);
			
			result.put("data" , pageJson);  
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




























