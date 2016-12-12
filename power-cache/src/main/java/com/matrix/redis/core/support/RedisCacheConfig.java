package com.matrix.redis.core.support;

import com.matrix.cache.RootCache;
import com.matrix.redis.core.interfaces.IRedisCall;

/**
 * @descriptions redis操作的缓存的类 | TODO 目前默认只支持一个实例
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2016年12月12日 下午9:36:15
 * @version 1.0.1
 */
public class RedisCacheConfig extends RootCache<String, IRedisCall>{

	@Override
	public void refresh() {
		// TODO 
		System.out.println("RedisCacheConfig refresh....."); 
	}

	@Override
	public IRedisCall getOneSetCatch(String k) {
		String redisUrls = getConfig("power-cache.cache_url_" + k);
		return new RedisCall(redisUrls);
	} 

}
