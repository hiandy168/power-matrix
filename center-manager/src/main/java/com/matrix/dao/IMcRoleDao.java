package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.dto.McRoleDto;
import com.matrix.pojo.entity.McRole;

public interface IMcRoleDao extends IBaseDao<McRole, Integer>{
	public Integer insertSelectiveGetZid(McRole e);
	
	public List<McRoleDto> findMcRoleDtoList();
}