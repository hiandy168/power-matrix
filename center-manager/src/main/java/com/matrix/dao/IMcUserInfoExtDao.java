package com.matrix.dao;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.McUserInfoExt;

public interface IMcUserInfoExtDao extends IBaseDao<McUserInfoExt , Integer>{

	public Integer deleteByUserId(Integer id);
	
	public Integer updateSelectiveByUserId(McUserInfoExt e);  
}
