package com.matrix.pojo.dto;

public class McUserRoleDto {
	private Integer id;    // managercenter.`mc_user_role` id
	private Integer userId;
	private Integer mcRoleId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getMcRoleId() {
		return mcRoleId;
	}
	public void setMcRoleId(Integer mcRoleId) {
		this.mcRoleId = mcRoleId;
	}
}
