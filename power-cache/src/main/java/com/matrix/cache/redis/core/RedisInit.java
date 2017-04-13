package com.matrix.cache.redis.core;

import com.matrix.base.BaseClass;
import com.matrix.cache.inf.IRedisCall;

public class RedisInit extends BaseClass {
	private static RedisCacheConfig CONFIG = new RedisCacheConfig();
	
	/**
	 * @descriptions 读取 config.power-cache.properties 中的Redis默认配置路径 cache_url_default
	 * 
	 * @date 2016年8月1日上午10:29:53
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public static IRedisCall getDefault() {
		return CONFIG.getValue("default");   // default or power-cache.cache_url_default         T ODO 潜在的异常点  
	}
	
	/**
	 * @descriptions 读取 config.power-cache.properties 中的Redis其他自定义的配置路径 示例如右：cache_url_other
	 * 此方法项目中暂无应用，作为示例扩展。
	 * 如果您是第一个使用了此方法的人，请备注为已使用。
	 * 
	 * @date 2016年8月1日上午10:29:53
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public static IRedisCall getOtherConfig() {
		return CONFIG.getValue("power-cache.cache_url_other");
	}
}
