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
import com.matrix.pojo.cache.McRoleCache;

/**
 * @descriptions 加载角色相关缓存到数据库
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2017年4月17日 下午8:25:32
 * @version 1.0.1
 */
public class LoadCacheMcRole extends BaseClass implements IBaseCache{
	
	private IBaseLaunch<ICacheFactory> launch = CacheLaunch.getInstance().Launch();
	
	private List<McRoleCache> list;
	 
	@Inject
	private IMcRoleDao roleDao; 
	
	
	@Override
	public void refresh() {
		try {
			list = roleDao.findMcRoleDtoList();
			if(list != null && list.size() != 0){
				for(McRoleCache d : list){
					launch.loadDictCache(DCacheEnum.McRole).setCache(d.getMcRoleId().toString() , JSONObject.toJSONString(d));
				}
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}
		System.out.println(this.getClass().getName() + "********* 初始化完成!"); 
	}

	@Override
	public void removeAll() {
		try {
			list = roleDao.findMcRoleDtoList();
			if(list != null && list.size() != 0){
				for(McRoleCache d : list){
					launch.loadDictCache(DCacheEnum.McRole).deleteCache(d.getMcRoleId().toString()); 
				}
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}
		System.out.println(this.getClass().getName() + "********* 缓存删除完成!"); 
	}
}










































