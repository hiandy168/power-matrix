package com.matrix.cache.inf;

import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.enums.SCacheEnum;
import com.matrix.cache.redis.core.support.RedisFactory;

public interface IBaseLaunch<T> {
	
	public T loadServiceCache(SCacheEnum enum_);
	
	public T loadDictCache(DCacheEnum enum_); 
}
