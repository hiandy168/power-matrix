package com.matrix.pojo.dto;

import java.util.Date;

public class McUserInfoDto {
    private Integer id;
    private Integer mcSellerCompanyId;
    private String userName;
    private Date createTime;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMcSellerCompanyId() {
		return mcSellerCompanyId;
	}
	public void setMcSellerCompanyId(Integer mcSellerCompanyId) {
		this.mcSellerCompanyId = mcSellerCompanyId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
    
}