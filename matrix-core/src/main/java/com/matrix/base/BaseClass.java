package com.matrix.base;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import com.matrix.annotation.Inject;
import com.matrix.system.SpringCtxUtil;

/**
 * @description: 顶层基类，提供多样化的注解功能、配置文件访问等等|TODO PropVisitor功能尚未完成，等待处理中 
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2016年9月29日 下午2:40:02 
 * @version 1.0.0
 */
public class BaseClass {
	
	public static BaseLog logger = new BaseLog();

	public BaseClass() {
		inject(this.getClass());
	}

	public void inject(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Inject.class)) {
				Inject inject = field.getAnnotation(Inject.class);
				String className = inject.className();
				try {
					if (StringUtils.isNotBlank(className)) {
						Object obj = this.getBean(className);
						field.setAccessible(true);
						field.set(this, obj);
					} else {
						Object obj = this.getBean(field.getType());
						field.setAccessible(true);
						field.set(this, obj);
					}
				} catch (NoSuchBeanDefinitionException e) {
					e.printStackTrace();
					getLogger().logError(e.getMessage());
				} catch(IllegalAccessException e) {
					e.printStackTrace();
					getLogger().logError(e.getMessage());
				}
			}
		}
		Class<?> parentClazz = clazz.getSuperclass();
		if(parentClazz != null)
			inject(parentClazz);
	}
	
	public <T> T getBean(Class<T> clazz) throws BeansException {
		return (T) SpringCtxUtil.getBean(clazz);
	}

	@SuppressWarnings("unchecked")
	public <T> T getBean(String beanName) throws BeansException {
		return (T) SpringCtxUtil.getBean(beanName);
	}
	
	public BaseLog getLogger() {
		return logger;
	}
	
	/**
	 * @description: 通过访问每一个项目的 config.*****.properties文件，获取其配置内容
	 * 
	 * @param key 配置主键
	 * @return 配置内容字符串
	 * 
	 * @author Yangcl 
	 * @date 2016年9月29日 下午2:42:48 
	 * @version 1.0.0.1
	 */
	public String getConfig(String key) {
//		return PropVisitor.getConfig(key);                 
		
		return "";
	}

	
}



































