package com.matrix.cache;

import org.apache.commons.codec.language.bm.Lang;

import com.matrix.base.BaseClass;
import com.matrix.cache.inf.IBaseLaunch;
import com.matrix.cache.redis.launch.RedisLaunch;
import com.matrix.cache.servletContext.launch.ContextLaunch;

/**
 * @description: 缓存对外服务入口|单例
 * 	
 * 	使用cglib动态为Java类添加方法
 * 	http://rensanning.iteye.com/blog/1924274
 * 
 * 	https://zhidao.baidu.com/question/1540712568691888627.html
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2017年4月12日 下午6:51:17 
 * @version 1.0.0
 */
public class CacheLaunch extends BaseClass{ 
 
	private IBaseLaunch<?> launch; 
	
	private CacheLaunch() {
		String cacheLaunchType = this.getConfig("power-cache.cache_launch_type");
		if(cacheLaunchType.equals("redis")){ 
			launch = new RedisLaunch();
		}else if(cacheLaunchType.equals("application")){ 
			launch = new ContextLaunch();
		}
	} 
	private static class LazyHolder {
		private static final CacheLaunch INSTANCE = new CacheLaunch();
	}
	public static final CacheLaunch getInstance() {
		return LazyHolder.INSTANCE; 
	}
	
	public IBaseLaunch<?> Launch(){ 
		return launch;
	}
}




















