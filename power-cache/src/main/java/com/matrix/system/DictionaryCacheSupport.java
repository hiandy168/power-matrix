package com.matrix.system;

import org.apache.commons.lang3.StringUtils;

import com.matrix.base.BaseClass;
import com.matrix.base.interfaces.IBaseDictCache;
import com.matrix.system.init.RootInit;

/**
 * @description: 为DictionaryTableCacheInit.java 提供远程火力 
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2016年11月30日 下午5:00:55 
 * @version 1.0.0
 */
public class DictionaryCacheSupport extends BaseClass{

	
	public boolean supportInit(){
		try {
			// TODO 加载缓存数据字典相关的表中的内容到Redis中
			String cacheLaunchType = this.getConfig("power-cache.cache_launch_type");
			if(cacheLaunchType.equals("redis")){ 
				
			}else if(cacheLaunchType.equals("context")){ 
				String package_ = this.getConfig("power-cache.default_package_url");
				String dictCacheClass = this.getConfig("power-cache.sub_project_cache_init");
				if(StringUtils.isNotBlank(dictCacheClass)){
					String [] arr = dictCacheClass.split(",");
					for(int i = 0 ; i < arr.length ; i ++){
						Class<?> clazz = Class.forName(package_ + arr[i]);   
						if (clazz != null && clazz.getDeclaredMethods() != null){
							RootInit dictCache = (RootInit) clazz.newInstance();
							dictCache.init();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean supportDelete(){
		try {
			// TODO 服务器关闭前，删除Redis中的字典缓存数据内容
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
