package com.matrix.pojo;

import java.util.Date;

public class EduBaseEntity {
	   private Integer id;
	    private String uuid;
	    private String createUser;
	    private Date createTime;
	    private String updateUser;
	    private Date updateTime;
	    
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getUuid() {
			return uuid;
		}
		public void setUuid(String uuid) {
			this.uuid = uuid;
		}
		public String getCreateUser() {
			return createUser;
		}
		public void setCreateUser(String createUser) {
			this.createUser = createUser;
		}
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		public String getUpdateUser() {
			return updateUser;
		}
		public void setUpdateUser(String updateUser) {
			this.updateUser = updateUser;
		}
		public Date getUpdateTime() {
			return updateTime;
		}
		public void setUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
		}
}
