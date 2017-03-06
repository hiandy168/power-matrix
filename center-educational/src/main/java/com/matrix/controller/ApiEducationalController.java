package com.matrix.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matrix.service.IEducationalService;

@Controller
@RequestMapping("edu")
public class ApiEducationalController {
	
	private static Logger logger=Logger.getLogger(ApiEducationalController.class);

	@Autowired
	private IEducationalService service;
	
	
	
}







