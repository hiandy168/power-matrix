package com.matrix.system;

import org.apache.commons.lang3.StringUtils;

import com.matrix.base.BaseClass;
import com.matrix.base.interfaces.IBaseCache;

/**
 * @description: 为DictionaryTableCacheInit.java 提供远程火力 
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2016年11月30日 下午5:00:55 
 * @version 1.0.0
 */
public class DictionaryCacheSupport extends BaseClass{

	private IBaseCache dictCache ;
	
	/**
	 * @descriptions 加载缓存数据字典相关的内容到缓存中
	 *
	 * @date 2017年4月18日 上午12:22:28
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public boolean supportInit(){
		try {
//			String cacheLaunchType = this.getConfig("power-cache.cache_launch_type");
//			if(cacheLaunchType.equals("redis")){ 
//			}else if(cacheLaunchType.equals("context")){ 
//			}
			String package_ = this.getConfig("power-cache.default_package_url");
			String dictCacheClass = this.getConfig("power-cache.sub_project_cache_init");
			if(StringUtils.isNotBlank(dictCacheClass)){
				String [] arr = dictCacheClass.split(",");
				for(int i = 0 ; i < arr.length ; i ++){
					Class<?> clazz = Class.forName(package_ + arr[i]);   
					if (clazz != null && clazz.getDeclaredMethods() != null){
						dictCache = (IBaseCache) clazz.newInstance();
						dictCache.refresh();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * @descriptions 服务器关闭前，删除缓存中的字典缓存数据内容
	 *
	 * @date 2017年4月18日 上午12:21:55
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public boolean supportDelete(){
		try {
			String package_ = this.getConfig("power-cache.default_package_url");
			String dictCacheClass = this.getConfig("power-cache.sub_project_cache_init");
			if(StringUtils.isNotBlank(dictCacheClass)){
				String [] arr = dictCacheClass.split(",");
				for(int i = 0 ; i < arr.length ; i ++){
					Class<?> clazz = Class.forName(package_ + arr[i]);   
					if (clazz != null && clazz.getDeclaredMethods() != null){
						dictCache = (IBaseCache) clazz.newInstance();
						dictCache.removeAll(); 
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
