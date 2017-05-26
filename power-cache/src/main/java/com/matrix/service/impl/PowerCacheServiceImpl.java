package com.matrix.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseClass;
import com.matrix.cache.CacheLaunch;
import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.inf.IBaseLaunch;
import com.matrix.cache.inf.ICacheFactory;
import com.matrix.service.IPowerCacheService;

@Service("powerCacheService")
public class PowerCacheServiceImpl extends BaseClass implements IPowerCacheService{

	private IBaseLaunch<ICacheFactory> launch = CacheLaunch.getInstance().Launch();
	
	/**
	 * @description: 查看缓存中的数据状态信息
	 * 
	 * @param prefix 缓存key的前缀
	 * @param key 缓存key的后缀
	 * @param type 缓存类型 ：dict|serv
	 * @return
	 * @author Yangcl 
	 * @date 2017年5月26日 下午1:16:56 
	 * @version 1.0.0.1
	 */
	public JSONObject getCacheValue(String prefix , String key  , String type) {
		JSONObject result = new JSONObject();
		
		if(StringUtils.isBlank(key)){
			result.put("status", "error");
			result.put("msg", "缓存key不得为空");
			return result;
		}
		String value = "";
		if(type.equals("dict")){
			value = launch.loadDictCache(prefix).get(key);
		}else{
			value = launch.loadServiceCache(prefix).get(key);
		}
		if(StringUtils.isNotBlank(value)){
			result.put("status", "success");
			result.put("msg", "查询成功");
			result.put("data", JSONObject.parseObject(value)); 
		}else{
			result.put("status", "error");
			result.put("msg", "未找到对应的值");
		}
		return result;
	}

}
