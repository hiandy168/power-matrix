package com.matrix.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseClass;
import com.matrix.pojo.entity.McUserInfo;
import com.matrix.service.IMcUserInfoService;

/**
 * @description: 权限、角色、后台登录等等操作 
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2016年11月25日 下午3:11:25 
 * @version 1.0.0
 */

@Controller
@RequestMapping("manager")
public class ManagerCenterController extends BaseClass{
	private static Logger logger = Logger.getLogger(ManagerCenterController.class);
	
	@Autowired
	private IMcUserInfoService mcUserInfoService;
	
	
	/**
	 * @description: 验证用户登录信息
	 * 
	 * @author Yangcl 
	 * @date 2016年11月25日 下午4:17:47 
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "login", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject login(McUserInfo info, HttpSession session) {
		getLogger().logInfo(info.getUserName() + " 正在尝试登录");
		return mcUserInfoService.login(info, session);
	}

	/**
	 * @description: 登录验证完成后跳转到指定页面
	 * 
	 * @author Yangcl 
	 * @date 2016年11月25日 下午4:18:10 
	 * @version 1.0.0.1
	 */
	@RequestMapping("index")
	public String loginPageIndex() {
		getLogger().logInfo(" to index.jsp  ... ");
		return "redirect:/index.jsp";
	}
}




























