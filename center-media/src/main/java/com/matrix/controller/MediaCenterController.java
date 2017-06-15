package com.matrix.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matrix.base.BaseController;
import com.matrix.service.IMediaCenterService;

/**
 * @description: 媒体库相关服务 
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2017年6月15日 下午5:12:38 
 * @version 1.0.0
 */

@Controller
@RequestMapping("media")
public class MediaCenterController extends BaseController {
	private static Logger logger = Logger.getLogger(MediaCenterController.class);
	
	@Autowired
	private IMediaCenterService service;
}
