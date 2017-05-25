package com.matrix.dict;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.matrix.annotation.Inject;
import com.matrix.base.BaseClass;
import com.matrix.base.interfaces.IBaseCache;
import com.matrix.cache.CacheLaunch;
import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.inf.IBaseLaunch;
import com.matrix.cache.inf.ICacheFactory;
import com.matrix.dao.IMcUserInfoDao;
import com.matrix.dao.IMcUserRoleDao;
import com.matrix.pojo.cache.McRoleCache;
import com.matrix.pojo.cache.McUserRoleCache;
import com.matrix.pojo.entity.McSysFunction;
import com.matrix.pojo.entity.McUserInfo;
import com.matrix.pojo.entity.McUserRole;

/**
 * @descriptions 加载用户权限
 *		注意：此处需要这两个类先加载完成，否则无法取得缓存，会报错。LoadCacheMcRole和LoadCacheSysFunction
 *
 * key: xd-McUserRole-1
 	value: 
				{
				    "mcUserId": 1,
				    "msfList": [
				        {
				            "createTime": 1491383651000,
				            "createUserId": 1,
				            "eleType": "",
				            "eleValue": "",
				            "flag": 1,
				            "funcUrl": "",
				            "id": 75,
				            "mcSellerCompanyId": 1,
				            "name": "惠家有促销系统",
				            "navType": 0,
				            "parentId": "1",
				            "remark": "惠家有促销系统2",
				            "seqnum": 1,
				            "styleClass": "",
				            "styleKey": "",
				            "updateTime": 1492933675000,
				            "updateUserId": 2
				        },
				        {
				            "createTime": 1491383733000,
				            "createUserId": 1,
				            "eleType": "",
				            "eleValue": "",
				            "flag": 1,
				            "funcUrl": "",
				            "id": 77,
				            "mcSellerCompanyId": 1,
				            "name": "导航栏A",
				            "navType": 1,
				            "parentId": "75",
				            "remark": "导航栏A",
				            "seqnum": 1,
				            "styleClass": "",
				            "styleKey": "",
				            "updateTime": 1491383733000,
				            "updateUserId": 1
				        },
				        {
				            "createTime": 1491383808000,
				            "createUserId": 1,
				            "eleType": "",
				            "eleValue": "",
				            "flag": 1,
				            "funcUrl": "",
				            "id": 79,
				            "mcSellerCompanyId": 1,
				            "name": "一级菜单栏A",
				            "navType": 2,
				            "parentId": "77",
				            "remark": "一级菜单栏A",
				            "seqnum": 1,
				            "styleClass": "editor",
				            "styleKey": "37c694131c304c2588c4b906567631b1",
				            "updateTime": 1492683714000,
				            "updateUserId": 1
				        },
				        {
				            "createTime": 1491383880000,
				            "createUserId": 1,
				            "eleType": "",
				            "eleValue": "",
				            "flag": 1,
				            "funcUrl": "exa/sdf.do",
				            "id": 83,
				            "mcSellerCompanyId": 1,
				            "name": "二级菜单A1",
				            "navType": 3,
				            "parentId": "79",
				            "remark": "二级菜单A",
				            "seqnum": 1,
				            "styleClass": "",
				            "styleKey": "",
				            "updateTime": 1492696775000,
				            "updateUserId": 1
				        },
				        {
				            "createTime": 1492697410000,
				            "createUserId": 1,
				            "eleType": "elementId",
				            "eleValue": "添加",
				            "flag": 1,
				            "funcUrl": "",
				            "id": 164,
				            "mcSellerCompanyId": 1,
				            "name": "添加",
				            "navType": 4,
				            "parentId": "129",
				            "remark": "添加",
				            "seqnum": 4,
				            "styleClass": "",
				            "styleKey": "",
				            "updateTime": 1492697410000,
				            "updateUserId": 1
				        }
				    ]
				} 	
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2017年4月23日 下午9:46:50
 * @version 1.0.1
 */
public class LoadCacheUserRole extends BaseClass implements IBaseCache {

	private IBaseLaunch<ICacheFactory> launch = CacheLaunch.getInstance().Launch();
	
	 
	@Inject
	private IMcUserInfoDao userInfoDao;
	@Inject
	private IMcUserRoleDao userRoleDao;
	
	public void refresh() {
		List<McUserInfo> list = userInfoDao.queryPage(null);
		if(list != null && list.size() != 0){
			for(McUserInfo u : list){
				this.reloadUserFunction(u.getId()); 
			}
		}
		System.out.println(this.getClass().getName() + "********* 初始化完成!"); 
	}
	
	/**
	 * @description: 实例化用户功能缓存   
	 * 
	 * @param userId
	 * @author Yangcl 
	 * @date 2017年5月24日 下午3:05:35 
	 * @version 1.0.0.1
	 */
	private void reloadUserFunction(Integer userId){
		McUserRoleCache cache = new McUserRoleCache();
		cache.setMcUserId(userId);
		List<McUserRole> list = userRoleDao.selectByMcUserId(userId);
		if(list != null && list.size() != 0){
			Set<Integer> set = new TreeSet<Integer>();  
			for(McUserRole r : list){
				String roleJson = launch.loadDictCache(DCacheEnum.McRole).get(r.getMcRoleId().toString());
				if(StringUtils.isNotBlank(roleJson)){
					McRoleCache role = JSONObject.parseObject(roleJson, McRoleCache.class);
					if(role == null){
						continue;
					}
					if(StringUtils.isNotBlank(role.getIds())){
						String [] arr = role.getIds().split(",");
						for(String s : arr){
							set.add(Integer.valueOf(s)); 
						}
					}
				}
			}
			if(set != null && set.size() != 0){
				for(Integer id : set){
					String rfJson = launch.loadDictCache(DCacheEnum.McSysFunc).get(id.toString());
					if(StringUtils.isNotBlank(rfJson)){
						McSysFunction rf = JSONObject.parseObject(rfJson, McSysFunction.class);
						if(rf == null){
							continue;
						}
						cache.getMsfList().add(rf); 
					}
				}
			}
			launch.loadDictCache(DCacheEnum.McUserRole).set(userId.toString(), JSONObject.toJSONString(cache)); 
		}
	}

	public void removeAll() {
		List<McUserInfo> list = userInfoDao.queryPage(null);
		if(list != null && list.size() != 0){
			for(McUserInfo u : list){
				launch.loadDictCache(DCacheEnum.McUserRole).del(u.getId().toString());  
			}
		} 
		System.out.println(this.getClass().getName() + "********* 缓存删除完成!");
	}

}































