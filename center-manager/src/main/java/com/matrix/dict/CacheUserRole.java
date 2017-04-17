package com.matrix.dict;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.matrix.annotation.Inject;
import com.matrix.base.BaseClass;
import com.matrix.base.interfaces.IBaseCache;
import com.matrix.cache.CacheLaunch;
import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.inf.IBaseLaunch;
import com.matrix.cache.inf.ICacheFactory;
import com.matrix.dao.IMcRoleDao;
import com.matrix.dao.IMcRoleFunctionDao;
import com.matrix.dao.IMcSysFunctionDao;
import com.matrix.pojo.dto.McRoleDto;

/**
 * @descriptions 加载角色相关缓存到数据库
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2017年4月17日 下午8:25:32
 * @version 1.0.1
 */
public class CacheUserRole extends BaseClass implements IBaseCache{
	
	private IBaseLaunch<ICacheFactory> launch = CacheLaunch.getInstance().Launch();
	
	@Inject
	private IMcSysFunctionDao sysFunctionDao;
	@Inject
	private IMcRoleDao roleDao;
	@Inject
	private IMcRoleFunctionDao roleFunctionDao;
	
	
	@Override
	public void refresh() {
		try {
			List<McRoleDto> list = roleDao.findMcRoleDtoList();
			if(list != null && list.size() != 0){
				for(McRoleDto d : list){
					// TODO 需要对ids字段进行大小顺序排列 TreeMap
					launch.loadDictCache(DCacheEnum.UserRole).setCache(d.getMcRoleId().toString() , JSONObject.toJSONString(d));
				}
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}

	@Override
	public void removeAll() {
		try {
			List<McRoleDto> list = roleDao.findMcRoleDtoList();
			if(list != null && list.size() != 0){
				for(McRoleDto d : list){
					launch.loadDictCache(DCacheEnum.UserRole).deleteCache(d.getMcRoleId().toString()); 
				}
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}

}










































