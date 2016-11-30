package com.matrix.system.init;

import com.matrix.system.ApiPagesSupport;

/**
 * @description: 复制api_pages下的资源到jsp中 
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2016年11月30日 下午4:58:17 
 * @version 1.0.0
 */
public class ApiSystemInit extends RootInit {

	public boolean onInit() {
		return new ApiPagesSupport().supportInit();
	}

	public boolean onDestory() {
		return new ApiPagesSupport().supportDelete();
	}

}
