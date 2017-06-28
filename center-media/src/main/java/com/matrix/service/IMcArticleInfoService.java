package com.matrix.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.interfaces.IBaseService;
import com.matrix.pojo.entity.McArticleInfo;

public interface IMcArticleInfoService extends IBaseService<McArticleInfo, Integer> {

	public JSONObject ajaxArticleList(McArticleInfo e, HttpServletRequest request, HttpSession session); 

}
