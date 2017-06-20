package com.matrix.pojo.entity;

import java.util.Date;

import com.matrix.pojo.EduBaseEntity;

public class TUser  extends EduBaseEntity{
    private String code;
    private String username;
    private String password;
    private String type;
    private String email;
    
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
    
}