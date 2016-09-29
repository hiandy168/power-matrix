package com.matrix.api;

import com.matrix.annotation.MatrixApi;

/**
 * @description: api 接口基础输入类 
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2016年9月29日 下午2:57:46 
 * @version 1.0.0
 */
public class RootInput {
	/**
	 * 版本标记 默认值为1 该参数用于扩展使用
	 */
	@MatrixApi(value="版本号",remark="仅用于扩展，无需传入",require=0)
	private int version = 1;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
