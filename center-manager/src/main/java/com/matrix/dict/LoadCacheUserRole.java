package com.matrix.dict;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

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
import com.matrix.dao.IMcUserRoleDao;
import com.matrix.pojo.cache.McRoleCache;
import com.matrix.pojo.cache.McUserRoleCache;
import com.matrix.pojo.entity.McRoleFunction;
import com.matrix.pojo.entity.McUserRole;

/**
 * @descriptions 加载用户权限
 *		注意：此处需要这两个类先加载完成，否则无法取得缓存，会报错。LoadCacheMcRole和LoadCacheSysFunction
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2017年4月23日 下午9:46:50
 * @version 1.0.1
 */
public class LoadCacheUserRole extends BaseClass implements IBaseCache {

	private IBaseLaunch<ICacheFactory> launch = CacheLaunch.getInstance().Launch();
	
	private List<McUserRole> list;
	
	@Inject
	private IMcSysFunctionDao sysFunctionDao;
	@Inject
	private IMcRoleDao roleDao;
	@Inject
	private IMcRoleFunctionDao roleFunctionDao;
	@Inject
	private IMcUserRoleDao userRoleDao;
	
	public void refresh() {
		McUserRole entity = new McUserRole();
		entity.setFlag(1); 
		list = userRoleDao.findList(entity);  
		if(list != null && list.size() != 0){
			for(McUserRole e : list){
				String roleJson = launch.loadDictCache(DCacheEnum.McRole).getCache(e.getMcRoleId().toString());
				if(StringUtils.isNotBlank(roleJson)){
					McRoleCache role = JSONObject.parseObject(roleJson, McRoleCache.class);
					if(role == null){
						continue;  
					}
					McUserRoleCache cache = new McUserRoleCache();
					cache.setMcUserId(e.getMcUserId());
					cache.setMcRoleId(e.getMcRoleId());
					cache.setRoleName(role.getRoleName());
					cache.setRoleDesc(role.getRoleDesc());
					if(StringUtils.isNotBlank(role.getIds())){
						String [] arr = role.getIds().split(",");
						for(String s : arr){
							String rfJson = launch.loadDictCache(DCacheEnum.McSysFunc).getCache(s);
							if(StringUtils.isNotBlank(rfJson)){
								McRoleFunction rf = JSONObject.parseObject(rfJson, McRoleFunction.class);
								if(rf == null){
									continue;
								}
								cache.getMrfList().add(rf);
							}
						}
					}
					
					launch.loadDictCache(DCacheEnum.McUserRole).setCache(e.getMcUserId().toString(), JSONObject.toJSONString(cache)); 
				}
			}
		}
		System.out.println(this.getClass().getName() + "********* 初始化完成!"); 
	}

	public void removeAll() {
		if(list == null){
			McUserRole entity = new McUserRole();
			entity.setFlag(1); 
			list = userRoleDao.findList(entity);  
		}
		if(list != null && list.size() != 0){
			for(McUserRole e : list){
				launch.loadDictCache(DCacheEnum.McUserRole).deleteCache(e.getMcUserId().toString());  
			}
		}
		
		System.out.println(this.getClass().getName() + "********* 缓存删除完成!");
	}

}































