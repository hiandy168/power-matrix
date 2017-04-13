package com.matrix.cache.redis.core;

import org.apache.commons.lang3.StringUtils;

import com.matrix.cache.inf.ICacheFactory;
import com.matrix.cache.inf.IRedisCall;
import com.matrix.map.MDataMap;

/**
 * @descriptions
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2016年12月12日 下午10:50:56
 * @version 1.0.1
 */
public class RedisFactory implements IRedisCall , ICacheFactory{

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

	
	
	/**
	 * @description: 添加一个缓存 
	 * 
	 * @param key
	 * @param value
	 * @author Yangcl 
	 * @date 2017年4月12日 下午6:14:23 
	 * @version 1.0.0.1
	 */
	public void setCache(String key, String value) {
		this.set(key, value);
	}

	/**
	 * @description: 删除一个缓存
	 * 
	 * @param key
	 * @author Yangcl 
	 * @date 2017年4月12日 下午6:27:44 
	 * @version 1.0.0.1
	 */
	public void deleteCache(String key) {
		this.del(key);
	}

	/**
	 * @description: 更新一条缓存信息
	 * 
	 * @param key
	 * @param value
	 * @author Yangcl 
	 * @date 2017年4月12日 下午6:31:03 
	 * @version 1.0.0.1
	 */
	public void updateCache(String key, String value) {
		this.deleteCache(key); 
		this.setCache(key, value); 
	}

	/**
	 * @descriptions 获取一个缓存
	 *
	 * @param key 
	 * @date 2017年4月11日 下午11:09:33
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public String getCache(String key) {
		return this.get(key); 
	}

	/**
	 * @description: 批量删除缓存，多参数
	 * 
	 * @param keys
	 * @author Yangcl 
	 * @date 2017年4月12日 下午6:36:28 
	 * @version 1.0.0.1
	 */
	public void batchDeleteCache(String... keys) {
		if(keys.length == 0){
			return;
		}
		for(String key : keys){
			this.deleteCache(key); 
		}
	}

	/**
	 * @description: 批量删除缓存，逗号分隔
	 * 
	 * @param keys
	 * @author Yangcl 
	 * @date 2017年4月12日 下午6:36:28 
	 * @version 1.0.0.1
	 */
	public void batchDeleteCache(String keys) {
		if(StringUtils.isBlank(keys)){
			return;
		}
		String [] arr = keys.split(",");
		for(String key : arr){
			this.deleteCache(key); 
		}
	}
}














