package com.matrix.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.interfaces.IBaseService;
import com.matrix.pojo.entity.McArticleType;

public interface IMcArticleTypeService extends IBaseService<McArticleType, Integer> {

	JSONObject ajaxArticleAssortList(McArticleType e , HttpServletRequest request, HttpSession session); 
	
}
