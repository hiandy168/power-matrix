package com.matrix.api;

import com.matrix.annotation.MatrixApi;

/**
 * @description: api 接口基础响应类
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2016年9月29日 下午2:57:46 
 * @version 1.0.0
 */
public class RootResponse {

	/**
	 * 返回标记 如果该标记为1则表明返回结果正确 否则都是错误消息
	 */
	@MatrixApi(value="返回标记",remark="如果返回标记1则为API调用成功  否则则是错误编号")
	private int resultCode = 1;

	/**
	 * 返回消息 一般用于返回错误描述或者操作提示
	 */
	@MatrixApi(value="返回消息",remark="返回的消息描述")
	private String resultMessage = "";

	public int getCode() {
		return resultCode;
	}

	public void setCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return resultMessage;
	}

	public void setMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	
}
