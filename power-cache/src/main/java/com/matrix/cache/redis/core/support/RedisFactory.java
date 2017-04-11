package com.matrix.cache.redis.core.support;

import com.matrix.cache.redis.core.interfaces.IRedisCall;
import com.matrix.map.MDataMap;

/**
 * @descriptions
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2016年12月12日 下午10:50:56
 * @version 1.0.1
 */
public class RedisFactory implements IRedisCall {

	private String baseKey = "";

	public RedisFactory(String sKey) {
		baseKey = sKey;
	}
	
	public String hget(final String key, final String field) {
		return RedisInit.getDefault().hget(baseKey + key , field); 
	}
	
	public Long hdel(String key, String field) {
		return RedisInit.getDefault().hdel(baseKey + key, field);
	}
	
	public Long hset(String key, String field, String value) {
		return RedisInit.getDefault().hset(baseKey + key , field , value); 
	}
	
	public String setex(String key, int seconds, String value) {
		return RedisInit.getDefault().setex(baseKey + key, seconds, value);
	}

	public String set(String key, String value) {
		return RedisInit.getDefault().set(baseKey + key, value);
	}

	public String get(String key) {
		return RedisInit.getDefault().get(baseKey + key);
	}

	public Long incrBy(String key, long integer) {
		return RedisInit.getDefault().incrBy(baseKey + key, integer);
	}

	public Long setnx(String key, String value) {
		return RedisInit.getDefault().setnx(baseKey + key, value);
	}

	public Long del(String key) {
		return RedisInit.getDefault().del(baseKey + key);
	}

	public Boolean exists(String key) {
		return RedisInit.getDefault().exists(baseKey + key);
	}

	public MDataMap hgetAll(String key) {
		return (MDataMap)RedisInit.getDefault().hgetAll(baseKey + key);
	}

	public Long hincrBy(String key, String field, long value) {
		return RedisInit.getDefault().hincrBy(baseKey + key, field, value);
	}

	public Long expire(String key, int seconds) {
		return RedisInit.getDefault().expire(baseKey + key, seconds);
	}

	public Long ttl(String key) {
		return RedisInit.getDefault().ttl(baseKey + key);
	}
}
