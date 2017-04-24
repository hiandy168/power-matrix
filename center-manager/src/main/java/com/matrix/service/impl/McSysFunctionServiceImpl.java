package com.matrix.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.matrix.base.BaseServiceImpl;
import com.matrix.cache.CacheLaunch;
import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.inf.IBaseLaunch;
import com.matrix.cache.inf.ICacheFactory;
import com.matrix.dao.IMcRoleDao;
import com.matrix.dao.IMcRoleFunctionDao;
import com.matrix.dao.IMcSysFunctionDao;
import com.matrix.dao.IMcUserInfoDao;
import com.matrix.dao.IMcUserRoleDao;
import com.matrix.pojo.cache.McRoleCache;
import com.matrix.pojo.cache.McUserRoleCache;
import com.matrix.pojo.dto.McUserRoleDto;
import com.matrix.pojo.entity.McRole;
import com.matrix.pojo.entity.McRoleFunction;
import com.matrix.pojo.entity.McSysFunction;
import com.matrix.pojo.entity.McUserInfo;
import com.matrix.pojo.entity.McUserRole;
import com.matrix.pojo.view.McUserRoleView;
import com.matrix.service.IMcSysFunctionService;
import com.matrix.util.UuidUtil;

@Service("mcSysFunctionService") 
public class McSysFunctionServiceImpl extends BaseServiceImpl<McSysFunction, Integer> implements IMcSysFunctionService {

	private IBaseLaunch<ICacheFactory> launch = CacheLaunch.getInstance().Launch();
	
	@Resource
	private IMcSysFunctionDao dao;
	
	@Resource
	private IMcRoleDao roleDao;
	
	@Resource
	private IMcRoleFunctionDao roleFunctionDao;
	
	@Resource
	private IMcUserRoleDao userRoleDao;
	
	@Resource
	private IMcUserInfoDao mcUserInfoDao;
	
	/**
	 * @description: 添加一个节点到数据库
	 * 
	 * @param e
	 * @param session 
	 * @author Yangcl 
	 * @date 2017年3月1日 上午11:05:51 
	 * @version 1.0.0.1
	 */
	public JSONObject addInfo(McSysFunction entity, HttpSession session) {
		JSONObject result = new JSONObject();
		if(StringUtils.isNotBlank(entity.getName()) && StringUtils.isNotBlank(entity.getParentId()) ){
			McUserInfo userInfo = (McUserInfo) session.getAttribute("userInfo");
			entity.setCreateTime(new Date());
			entity.setUpdateTime(new Date());
			entity.setCreateUserId(userInfo.getId());
			entity.setUpdateUserId(userInfo.getId());
			if(entity.getNavType() == 2){
				entity.setStyleKey(UuidUtil.uid());
			}else{
				entity.setStyleKey(""); 
			}
			int count = dao.insertSelective(entity);
			if(count == 1){
				result.put("status", "success");
				result.put("msg", "添加成功!");
				// 开始创建缓存
				launch.loadDictCache(DCacheEnum.McSysFunc).setCache(entity.getId().toString(), JSONObject.toJSONString(entity)); 
			}else{
				result.put("status", "error");
				result.put("msg", "添加失败!");
			}
		}else{
			result.put("status", "error");
			result.put("msg", "功能名称|父节点不能为空!");
		}
		
		return result;
	}

	/**
	 * @description: 更新一个节点到数据库
	 * 
	 * @param e
	 * @param session
	 * @author Yangcl 
	 * @date 2017年3月1日 下午5:33:30 
	 * @version 1.0.0.1
	 */
	public JSONObject editInfo(McSysFunction entity, HttpSession session) {
		JSONObject result = new JSONObject();
		if(StringUtils.isNotBlank(entity.getName())){
			McUserInfo userInfo = (McUserInfo) session.getAttribute("userInfo");
			entity.setUpdateTime(new Date());
			entity.setUpdateUserId(userInfo.getId());
			int count = dao.updateSelective(entity);
			if(count == 1){
				result.put("status", "success");
				result.put("msg", "修改成功!");
				// 开始修改缓存
				launch.loadDictCache(DCacheEnum.McSysFunc).updateCache(entity.getId().toString(), JSONObject.toJSONString(entity)); 
			}else{
				result.put("status", "error");
				result.put("msg", "修改失败!");
			}
		}else{
			result.put("status", "error");
			result.put("msg", "功能名称不能为空!");
		}
		
		return result;
	}


	/**
	 * @description: 更新拖拽后的同层节点
	 * 
	 * @param ustring id@seqnum,id@seqnum 
	 * @param session
	 * @author Yangcl 
	 * @date 2017年3月2日 下午5:33:07 
	 * @version 1.0.0.1
	 */
	public JSONObject updateTreeNodes(String ustring, HttpSession session) {
		McUserInfo userInfo = (McUserInfo) session.getAttribute("userInfo");
		String [] arr = ustring.split(",");
		for(int i = 0 ; i < arr.length ; i ++){
			McSysFunction e = new McSysFunction();
			e.setId( Integer.valueOf(arr[i].split("@")[0]) );
			e.setSeqnum( Integer.valueOf(arr[i].split("@")[1]) );
			e.setUpdateTime(new Date());
			e.setUpdateUserId(userInfo.getId());
			dao.updateSelective(e);
			// 开始修改缓存
			launch.loadDictCache(DCacheEnum.McSysFunc).updateCache(e.getId().toString(), JSONObject.toJSONString(e)); 
		}
		return null;
	}


	/**
	 * @description:系统权限分配 如果type=role则同时获得角色列表
	 * 
	 * @return
	 * @author Yangcl 
	 * @date 2017年4月13日 下午5:30:03 
	 * @version 1.0.0.1
	 */
	public JSONObject treeList(HttpServletRequest request) {
		JSONObject result = new JSONObject();
		McSysFunction e = new McSysFunction();	
		e.setFlag(1);
		List<McSysFunction> list = dao.findList(e);
		if (list != null && list.size() > 0) {
			result.put("status", "success");
			result.put("list", list);
			if(request.getParameter("type").equals("role")){
				List<McRoleCache> roles = new ArrayList<McRoleCache>(); 
				McRole role = new McRole();
				role.setFlag(1); 
				List<McRole> roleList = roleDao.findList(role);
				if(roleList.size() != 0){
					for(McRole m : roleList){
						String json = launch.loadDictCache(DCacheEnum.McRole).getCache(m.getId().toString());
						if(StringUtils.isBlank(json)){
							continue;
						}
						McRoleCache d = JSONObject.parseObject(json, McRoleCache.class);
						roles.add(d);
					}
				}
				result.put("roles", roles);
			}
		} else {
			result.put("status", "error");
			result.put("msg", this.getInfo(100090001)); // 结果集为空
		}
		return result;  
	}


	/**
	 * @descriptions 删除节点 mc_sys_function表 	TODO 删除功能存在缺陷，等待完善中。
	 *										TODO 此处需要单独写一个内存树，将mc_sys_function表的数据组织到二叉树中
	 *													 指定一个颗树，可以获得他的所有父节点以及所有子节点 
	 * @param id
	 * @param session
	 * @date 2017年4月23日 下午6:53:32
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public JSONObject deleteNode(Integer id, HttpSession session) {
		JSONObject result = new JSONObject();
		Integer flag = dao.deleteById(id);
		if(flag == 1){
			result.put("status", "success");
			result.put("msg", this.getInfo(500090001)); // 删除成功
		}else{
			result.put("status", "error");
			result.put("msg", this.getInfo(500090001)); // 删除失败
		}
		return result;
	}
	
	/**
	 * @description: 创建系统角色
	 * 
	 * @param d
	 * @param session
	 * @return
	 * @author Yangcl 
	 * @date 2017年4月11日 上午11:22:52 
	 * @version 1.0.0.1
	 */
	public JSONObject addMcRole(McRoleCache d, HttpSession session) {
		JSONObject result = new JSONObject();
		if(StringUtils.isBlank(d.getIds())){
			result.put("status", "error");
			result.put("msg", this.getInfo(500090003)); // 请勾选系统功能
		}else{
			Date createTime = new Date();
			McUserInfo userInfo = (McUserInfo) session.getAttribute("userInfo");
			
			McRole role = new McRole();
			role.setRoleName(d.getRoleName());
			role.setRoleDesc(d.getRoleDesc());
			role.setFlag(1);
			role.setCreateTime(createTime);
			role.setUpdateTime(createTime);
			role.setRemark("");
			role.setCreateUserId(userInfo.getId());
			role.setUpdateUserId(userInfo.getId());
			try {
				roleDao.insertSelectiveGetZid(role);
				
				String[] arr = d.getIds().split(",");
				for(int i = 0 ; i < arr.length ; i ++){
					McRoleFunction rf = new McRoleFunction();
					rf.setMcRoleId(role.getId());
					rf.setMcSysFunctionId(Integer.valueOf(arr[i])); 
					rf.setFlag(1);
					rf.setRemark("");
					rf.setCreateTime(createTime);
					rf.setUpdateTime(createTime);
					rf.setCreateUserId(userInfo.getId());
					rf.setUpdateUserId(userInfo.getId());
					roleFunctionDao.insertSelective(rf);
				}
				result.put("status", "success");
				d.setMcRoleId(role.getId()); 
				
				launch.loadDictCache(DCacheEnum.McRole).setCache(d.getMcRoleId().toString() , JSONObject.toJSONString(d));  
				List<McRoleCache> list = new ArrayList<McRoleCache>();
				list.add(d);
				result.put("cache", list); 
			} catch (Exception e) {
				e.printStackTrace();
				result.put("status", "error");
				result.put("msg", this.getInfo(500090004)); // 系统角色创建失败
			}
		}
		return result;
	}


	/**
	 * @description: 修改系统角色
	 * 
	 * @param d
	 * @param session
	 * @author Yangcl 
	 * @date 2017年4月19日 下午4:22:28 
	 * @version 1.0.0.1
	 */
	public JSONObject editMcRole(McRoleCache d, HttpSession session) {
		JSONObject result = new JSONObject();
		if(StringUtils.isBlank(d.getIds())){
			result.put("status", "error");
			result.put("msg", this.getInfo(500090003)); // 请勾选系统功能
		}else{
			Date currentTime = new Date();
			McUserInfo userInfo = (McUserInfo) session.getAttribute("userInfo");
			
			McRole role = new McRole();
			role.setId(d.getMcRoleId()); 
			role.setRoleName(d.getRoleName());
			role.setRoleDesc(d.getRoleDesc()); 
			role.setUpdateTime(currentTime); 
			role.setUpdateUserId(userInfo.getId());
			try {
				roleDao.updateSelective(role);
				
				roleFunctionDao.deleteByMcRoleId(d.getMcRoleId()); 
				launch.loadDictCache(DCacheEnum.McRole).deleteCache(d.getMcRoleId().toString());  
				
				String[] arr = d.getIds().split(",");
				for(int i = 0 ; i < arr.length ; i ++){
					McRoleFunction rf = new McRoleFunction();
					rf.setMcRoleId(role.getId());
					rf.setMcSysFunctionId(Integer.valueOf(arr[i])); 
					rf.setFlag(1);
					rf.setRemark("");
					rf.setCreateTime(currentTime);
					rf.setUpdateTime(currentTime);
					rf.setCreateUserId(userInfo.getId());
					rf.setUpdateUserId(userInfo.getId());
					roleFunctionDao.insertSelective(rf);
				}
				result.put("status", "success");
				launch.loadDictCache(DCacheEnum.McRole).setCache(d.getMcRoleId().toString() , JSONObject.toJSONString(d));  
				result.put("cache", d);
			} catch (Exception e) {
				e.printStackTrace();
				result.put("status", "error");
				result.put("msg", this.getInfo(500090005)); // 系统角色修改失败
			}
		}
		return result;
	}


	/**
	 * @descriptions 删除一条角色信息
	 * 	
	 *  需要判断 mc_user_role 表中是否已经关联了用户，如果关联了，则不允许删除；
	 *  如果想删除则必选先将用户与该角色解除绑定，即：删除mc_user_role表中的关联记录
	 *
	 * @param d
	 * @param session
	 * @return
	 * @date 2017年4月23日 下午2:50:56
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public JSONObject deleteMcRole(McRoleCache d, HttpSession session) {
		JSONObject result = new JSONObject();
		try {
			if(userRoleDao.selectByPrimaryKey(d.getMcRoleId()).size() != 0){
				result.put("status", "error");
				result.put("msg", this.getInfo(500090009)); // 该角色已经关联了用户，如果想删除则必选先将用户与该角色解除绑定
			}else{
				roleDao.deleteById(d.getMcRoleId());
				roleFunctionDao.deleteByMcRoleId(d.getMcRoleId()); 
				launch.loadDictCache(DCacheEnum.McRole).deleteCache(d.getMcRoleId().toString());  
				result.put("status", "success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "error");
			result.put("msg", this.getInfo(500090006)); // 系统角色删除失败
		}
		
		return result;
	}

	
	/**
	 * @descriptions 【系统角色创建】->【勾选用户】，显示没有关联任何角色的用户列表
	 *
	 * @param entity                  
	 * @param request
	 * @date 2017年4月23日 上午11:25:50
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public JSONObject mcUserList(McUserInfo entity , HttpServletRequest request){
		JSONObject result = new JSONObject();
		String pageNum = request.getParameter("pageNum"); // 当前第几页
		String pageSize = request.getParameter("pageSize"); // 当前页所显示记录条数
		int num = 1;
		int size = 10;
		if (StringUtils.isNotBlank(pageNum)) {
			num = Integer.parseInt(pageNum);
		}
		if (StringUtils.isNotBlank(pageSize)) {
			size = Integer.parseInt(pageSize);
		}
		
		PageHelper.startPage(num, size);
		List<McUserInfo> list = mcUserInfoDao.mcUserList(entity);
		if (list != null && list.size() > 0) {
			result.put("status", "success");
		} else {
			result.put("status", "error");
			result.put("msg", this.getInfo(100090002));  // 没有查询到可以显示的数据 
		}
		PageInfo<McUserInfo> pageList = new PageInfo<McUserInfo>(list);
		result.put("data", pageList);
		result.put("entity", entity);
		return result;
	}

	
	/**
	 * @descriptions 关联用户与某一个角色
	 *
	 * @param e
	 * @param session
	 * @date 2017年4月23日 上午11:55:29
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public JSONObject addUserRole(McUserRole e , HttpSession session) {
		JSONObject result = new JSONObject();
		Date createTime = new Date();
		McUserInfo userInfo = (McUserInfo) session.getAttribute("userInfo");
		e.setFlag(1);
		e.setRemark("");
		e.setCreateTime(createTime);
		e.setUpdateTime(createTime);
		e.setCreateUserId(userInfo.getId());
		e.setUpdateUserId(userInfo.getId());
		try {
			Integer count = userRoleDao.insertSelective(e);
			if(count != 0){
				result.put("status", "success");
				// 实例化缓存   
				String roleJson = launch.loadDictCache(DCacheEnum.McRole).getCache(e.getMcRoleId().toString());
				if(StringUtils.isNotBlank(roleJson)){
					McRoleCache role = JSONObject.parseObject(roleJson, McRoleCache.class);
					if(role == null){
						return result;
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
								McSysFunction rf = JSONObject.parseObject(rfJson, McSysFunction.class);
								if(rf == null){
									continue;
								}
								cache.getMsfList().add(rf); 
							}
						}
					}
					
					launch.loadDictCache(DCacheEnum.McUserRole).setCache(e.getMcUserId().toString(), JSONObject.toJSONString(cache)); 
				}
			}else{
				result.put("status", "error");
				result.put("msg", this.getInfo(500090007)); // 用户与角色关联失败
			}
		} catch (Exception e2) {
			result.put("status", "error");
			result.put("msg", this.getInfo(500090008)); // 系统异常
		}
		return result;
	}

	/**
	 * @description: 已赋权限用户列表
	 * 
	 * @param dto
	 * @param session
	 * @author Yangcl 
	 * @date 2017年4月24日 下午2:43:35 
	 * @version 1.0.0.1
	 */
	public JSONObject userRoleFuncList(McUserRoleDto dto, HttpServletRequest request) {
		JSONObject result = new JSONObject();
		String pageNum = request.getParameter("pageNum"); // 当前第几页
		String pageSize = request.getParameter("pageSize"); // 当前页所显示记录条数
		int num = 1;
		int size = 10;
		if (StringUtils.isNotBlank(pageNum)) {
			num = Integer.parseInt(pageNum);
		}
		if (StringUtils.isNotBlank(pageSize)) {
			size = Integer.parseInt(pageSize);
		}
		
		PageHelper.startPage(num, size);
		List<McUserRoleView> list = userRoleDao.userRoleFuncList(dto);
		if (list != null && list.size() > 0) {
			result.put("status", "success");
		} else {
			result.put("status", "error");
			result.put("msg", this.getInfo(100090002));  // 没有查询到可以显示的数据 
		}
		PageInfo<McUserRoleView> pageList = new PageInfo<McUserRoleView>(list);
		result.put("data", pageList); 
		return result;
	}

	
	/**
	 * @description: 解除角色绑定，同时删除缓存
	 * 
	 * @param d
	 * @param session
	 * @author Yangcl 
	 * @date 2017年4月24日 下午3:27:22 
	 * @version 1.0.0.1
	 */
	public JSONObject deleteUserRole(McUserRoleDto d, HttpSession session) {
		JSONObject result = new JSONObject();
		try {
			userRoleDao.deleteById(d.getId());
			launch.loadDictCache(DCacheEnum.McUserRole).deleteCache(d.getUserId().toString()); 
			
			result.put("status", "success");
			result.put("msg", this.getInfo(500090010)); // 角色绑定解除成功! 
		} catch (Exception e) {
			e.printStackTrace(); 
			result.put("status", "error");
			result.put("msg", this.getInfo(500090008)); // 系统异常
		}
		return result;
	}

}


























