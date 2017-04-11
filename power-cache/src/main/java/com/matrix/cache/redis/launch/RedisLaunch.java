package com.matrix.cache.redis.launch;

import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.enums.SCacheEnum;
import com.matrix.cache.redis.core.support.RedisFactory;

/**
 * @descriptions redis核心工具类，供外部调用。
 * 
 * @test RedisLaunch.setFactoryService(SRedisEnum.Product).del(i);
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2016年12月11日 下午4:56:24
 * @version 1.0.1
 */
public class RedisLaunch {
	/**
	 * @descriptions 操作业务相关的缓存数据
	 *
	 * @param enum_
	 * @date 2016年12月12日 下午10:55:31
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public static RedisFactory setFactoryService(SCacheEnum enum_) {
		return new RedisFactory("s-" + enum_.toString() + "-");
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
}
