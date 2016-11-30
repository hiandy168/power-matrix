package com.matrix.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matrix.service.IPowerApiService;

@Controller
@RequestMapping("api")
public class PowerApiController {
	private static Logger logger=Logger.getLogger(PowerApiController.class);

	@Autowired
	private IPowerApiService powerApiService;
	
	
}
