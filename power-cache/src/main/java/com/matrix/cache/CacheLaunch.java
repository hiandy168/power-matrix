package com.matrix.cache;

import com.matrix.base.BaseClass;
import com.matrix.cache.redis.launch.RedisLaunch;
import com.matrix.cache.servletContext.launch.ContextLaunch;

/**
 * @description: 缓存对外服务入口|单例
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2017年4月12日 下午6:51:17 
 * @version 1.0.0
 */
public class CacheLaunch extends BaseClass{ 
	private ContextLaunch contextLaunch;
	private RedisLaunch redisLaunch;   

	public static final CacheLaunch getInstance() {
		return LazyHolder.INSTANCE; 
	}
	private CacheLaunch() {
		String cacheLaunchType = this.getConfig("power-cache.cache_launch_type");
		if(cacheLaunchType.equals("redis")){
			
		}else if(cacheLaunchType.equals("application")){
			
		}
	}
	private static class LazyHolder {
		private static final CacheLaunch INSTANCE = new CacheLaunch();
	}
	
	
	
}




















