package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.cache.McRoleCache;
import com.matrix.pojo.entity.McRole;
import com.matrix.pojo.view.McRoleView;

public interface IMcRoleDao extends IBaseDao<McRole, Integer>{
	public Integer insertSelectiveGetZid(McRole e);
	
	public List<McRoleCache> findMcRoleDtoList();
	
	public List<McRoleView> queryPageView(McRole e);
}