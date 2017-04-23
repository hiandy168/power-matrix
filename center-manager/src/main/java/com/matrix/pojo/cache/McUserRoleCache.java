package com.matrix.pojo.cache;

import java.util.ArrayList;
import java.util.List;

import com.matrix.pojo.entity.McRoleFunction;

public class McUserRoleCache {
	private Integer mcUserId;
	private Integer mcRoleId;
	private String roleName;
	private String roleDesc;
	private List<McRoleFunction> mrfList = new ArrayList<McRoleFunction>();
	
	public Integer getMcUserId() {
		return mcUserId;
	}
	public void setMcUserId(Integer mcUserId) {
		this.mcUserId = mcUserId;
	}
	public Integer getMcRoleId() {
		return mcRoleId;
	}
	public void setMcRoleId(Integer mcRoleId) {
		this.mcRoleId = mcRoleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public List<McRoleFunction> getMrfList() {
		return mrfList;
	}
	public void setMrfList(List<McRoleFunction> mrfList) {
		this.mrfList = mrfList;
	}
}
