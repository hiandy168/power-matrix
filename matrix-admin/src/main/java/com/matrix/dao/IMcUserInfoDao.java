package com.matrix.dao;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.McUserInfo;

public interface IMcUserInfoDao extends IBaseDao<McUserInfo, Integer>{ 
	public McUserInfo login(McUserInfo entity); 
}