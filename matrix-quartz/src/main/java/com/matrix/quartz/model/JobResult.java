package com.matrix.quartz.model;

import com.matrix.base.interfaces.IBaseResult;

public class JobResult implements IBaseResult {
	private int code;
	private String message;
	
	public JobResult() {}
	
	public JobResult(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
