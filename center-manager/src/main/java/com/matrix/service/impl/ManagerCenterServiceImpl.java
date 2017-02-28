package com.matrix.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.matrix.dao.IMcRoleDao;
import com.matrix.dao.IMcRoleFunctionDao;
import com.matrix.dao.IMcSellerCompanyDao;
import com.matrix.dao.IMcSysFunctionDao;
import com.matrix.dao.IMcUserInfoDao;
import com.matrix.dao.IMcUserRoleDao;

@Service("managerCenterService")
public class ManagerCenterServiceImpl {
	@Resource
	private IMcUserInfoDao mcUserInfoDao;
	@Resource
	private IMcRoleDao mcRoleDao;
	@Resource
	private IMcRoleFunctionDao mcRoleFunctionDao;
	@Resource
	private IMcSellerCompanyDao mcSellerCompanyDao; 
	@Resource
	private IMcSysFunctionDao mcSysFunctionDao;
	@Resource
	private IMcUserRoleDao mcUserRoleDao ;
	
	
}

























































