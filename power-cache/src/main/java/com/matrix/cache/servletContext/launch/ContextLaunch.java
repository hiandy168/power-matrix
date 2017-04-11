package com.matrix.cache.servletContext.launch;

import javax.servlet.ServletContext;

import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.enums.SCacheEnum;
import com.matrix.cache.redis.core.support.RedisFactory;
import com.matrix.cache.redis.launch.RedisLaunch;
import com.matrix.cache.servletContext.core.ContextCore;
import com.matrix.cache.servletContext.core.ContextFactory;

public class ContextLaunch {
	
	
	/**
	 * @descriptions 操作业务相关的缓存数据
	 *
	 * @param enum_
	 * @date 2016年12月12日 下午10:55:31
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public static ContextFactory setFactoryService(SCacheEnum enum_) {
		return new ContextFactory("s-" + enum_.toString() + "-");
	}
	
	/**
	 * @descriptions 操作字典相关的缓存数据
	 *
	 * @param enum_
	 * @date 2016年12月12日 下午10:55:58
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public static RedisFactory setFactoryDict(DCacheEnum enum_) {
		return new RedisFactory("d-" + enum_.toString() + "-");
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		ServletContext application = ContextCore.getInstance().getApplication();

		RedisLaunch.setFactoryService(SCacheEnum.Test).get("aweqtwr");  
	}
	
}
