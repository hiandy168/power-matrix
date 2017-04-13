package com.matrix.cache.servletContext.launch;

import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.enums.SCacheEnum;
import com.matrix.cache.inf.IBaseLaunch;
import com.matrix.cache.inf.ICacheFactory;
import com.matrix.cache.servletContext.core.ContextFactory;

/**
 * @description: ServletContext 核心工具类，供外部调用。
 * @test String value = ContextLaunch.initServiceCache(SCacheEnum.Test).getCache("xs-Test-001");
 * @warning 
 * 					1. 使用该类型的缓存需要设置Java虚拟机的内存大小，避免内存溢出
 * 					2. 该类型缓存只允许设置String类型的值：Key(String) - value(String) 
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2017年4月12日 下午6:21:24 
 * @version 1.0.0
 */
public class ContextLaunch  implements IBaseLaunch<ICacheFactory>{
	
	/**
	 * @descriptions 操作业务相关的缓存数据 
	 *
	 * @param enum_
	 * @date 2016年12月12日 下午10:55:31
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public static ContextFactory initServiceCache(SCacheEnum enum_) {
		return new ContextFactory("xs-" + enum_.toString() + "-");
	}
	
	/**
	 * @descriptions 操作字典相关的缓存数据
	 *
	 * @param enum_
	 * @date 2016年12月12日 下午10:55:58
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public static ContextFactory initDictCache(DCacheEnum enum_) {
		return new ContextFactory("xd-" + enum_.toString() + "-");
	}

	@Override
	public ContextFactory loadServiceCache(SCacheEnum enum_) {
		return new ContextFactory("xs-" + enum_.toString() + "-");
	}

	@Override
	public ContextFactory loadDictCache(DCacheEnum enum_) {
		return new ContextFactory("xd-" + enum_.toString() + "-");
	}
}







