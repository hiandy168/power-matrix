package com.matrix.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.matrix.base.BaseServiceImpl;
import com.matrix.dao.IMcArticleInfoDao;
import com.matrix.dao.IMcArticleTypeDao;
import com.matrix.pojo.entity.McArticleInfo;
import com.matrix.service.IMediaCenterService;

@Service("mediaCenterService")
public class MediaCenterServiceImpl extends BaseServiceImpl<McArticleInfo, Integer> implements IMediaCenterService {
	@Resource
	private IMcArticleInfoDao mcArticleInfoDao;
	
	@Resource
	private IMcArticleTypeDao mcArticleTypeDao;  
	
	
}
