package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.McUserInfo;

public interface IMcUserInfoDao extends IBaseDao<McUserInfo, Integer>{ 
	public McUserInfo login(McUserInfo entity);

	public List<McUserInfo> mcUserList(McUserInfo entity);  
}