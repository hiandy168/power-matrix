package com.matrix.dao;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.McRoleFunction;

public interface IMcRoleFunctionDao extends IBaseDao<McRoleFunction , Integer>{
	public Integer deleteByMcRoleId(Integer mcRoleId);
}