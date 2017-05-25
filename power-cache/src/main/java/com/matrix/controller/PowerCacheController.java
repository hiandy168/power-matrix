package com.matrix.controller;


import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matrix.base.BaseController;
import com.matrix.service.IPowerCacheService;

@Controller
@RequestMapping("cache")
public class PowerCacheController extends BaseController{
	private static Logger logger=Logger.getLogger(PowerCacheController.class);

	@Autowired
	private IPowerCacheService powerApiService;
	
	/**
	 * @description: 前往缓存查看页面
	 * 
	 * @author Yangcl 
	 * @date 2017年5月25日 下午4:52:23 
	 * @version 1.0.0.1
	 */
	@RequestMapping("page_cache_get_value")  
	public String pageCacheGetValue(HttpSession session){ 
		super.userBehavior(session, logger, "page_cache_get_value", "前往缓存查看页面");
		return "jsp/cache/addExample"; 
	}
}
