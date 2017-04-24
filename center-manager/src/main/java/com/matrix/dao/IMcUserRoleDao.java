package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.dto.McUserRoleDto;
import com.matrix.pojo.entity.McUserRole;
import com.matrix.pojo.view.McUserRoleView;

public interface IMcUserRoleDao extends IBaseDao<McUserRole, Integer>{

	public List<McUserRoleView> userRoleFuncList(McUserRoleDto dto);  
	
}