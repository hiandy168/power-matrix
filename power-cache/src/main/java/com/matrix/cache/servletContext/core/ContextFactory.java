package com.matrix.cache.servletContext.core;

import javax.servlet.ServletContext;

public class ContextFactory <T>{
	
	private String baseKey = "";
	private ServletContext context = ContextCore.getInstance().getApplication();

	public ContextFactory(String baseKey) {
		this.baseKey = baseKey;
	}
	
	/**
	 * @descriptions 根据泛型类型获取一个缓存
	 *
	 * @param key
	 * @return
	 * @date 2017年4月11日 下午11:09:33
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	@SuppressWarnings("unchecked")
	public T get(String key){
		return (T) context.getAttribute(this.baseKey + key);
	}
	
	/**
	 * @descriptions 设置一个泛型指定类型的缓存 
	 *
	 * @param key
	 * @param t
	 * @date 2017年4月11日 下午11:09:58
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public void set(String key , T t){
		context.setAttribute(key, t);
	}
}


























