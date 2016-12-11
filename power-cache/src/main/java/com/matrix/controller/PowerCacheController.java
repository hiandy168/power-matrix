package com.matrix.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matrix.service.IPowerCacheService;

@Controller
@RequestMapping("cache")
public class PowerCacheController {
	private static Logger logger=Logger.getLogger(PowerCacheController.class);

	@Autowired
	private IPowerCacheService powerApiService;
	
}
