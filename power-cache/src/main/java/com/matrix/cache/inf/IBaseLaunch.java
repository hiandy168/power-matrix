package com.matrix.cache.inf;

import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.enums.SCacheEnum;
import com.matrix.cache.redis.core.RedisFactory;

public interface IBaseLaunch<T> {
	
	public T loadServiceCache(SCacheEnum enum_);
	
	public T loadDictCache(DCacheEnum enum_); 
	
	public T loadServiceCache(String baseKey);
	
	public T loadDictCache(String baseKey); 
}
