package com.matrix.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.matrix.base.BaseServiceImpl;
import com.matrix.dao.IMcArticleInfoDao;
import com.matrix.dao.IMcArticleTypeDao;
import com.matrix.pojo.entity.McArticleType;
import com.matrix.service.IMcArticleTypeService;

@Service("mcArticleTypeService")
public class McArticleTypeServiceImpl extends BaseServiceImpl<McArticleType, Integer> implements IMcArticleTypeService {
	@Resource
	private IMcArticleInfoDao mcArticleInfoDao;
	
	@Resource
	private IMcArticleTypeDao mcArticleTypeDao;  
	
	
}



















