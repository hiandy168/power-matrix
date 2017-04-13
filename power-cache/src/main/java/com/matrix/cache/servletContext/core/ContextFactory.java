package com.matrix.cache.servletContext.core;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;

import com.matrix.cache.inf.ICacheFactory;

/**
 * @description: 针对缓存提供基本的增删改查操作 
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2017年4月12日 下午6:31:56 
 * @version 1.0.0
 */
public class ContextFactory implements ICacheFactory{
	
	private String baseKey = "";
	private ServletContext context = ContextCore.getInstance().getApplication();

	public ContextFactory(String baseKey) {
		this.baseKey = baseKey;
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
	public void setCache(String key , String value){
		context.setAttribute(key, value);
	}
	
	/**
	 * @description: 删除一个缓存
	 * 
	 * @param key
	 * @author Yangcl 
	 * @date 2017年4月12日 下午6:27:44 
	 * @version 1.0.0.1
	 */
	public void deleteCache(String key){
		context.removeAttribute(key);  
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
	public void updateCache(String key , String value){
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
	public String getCache(String key){
		return (String) context.getAttribute(this.baseKey + key);
	}
	
	/**
	 * @description: 批量删除缓存，多参数
	 * 
	 * @param keys
	 * @author Yangcl 
	 * @date 2017年4月12日 下午6:36:28 
	 * @version 1.0.0.1
	 */
	public void batchDeleteCache(String... keys){
		if(keys.length == 0){
			return;
		}
		for(String key : keys){
			context.removeAttribute(key);  
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
	public void batchDeleteCache(String keys){
		if(StringUtils.isBlank(keys)){
			return;
		}
		String [] arr = keys.split(",");
		for(String key : arr){
			context.removeAttribute(key);  
		}
	}
}


























