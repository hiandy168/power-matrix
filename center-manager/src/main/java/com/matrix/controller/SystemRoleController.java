package com.matrix.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.matrix.pojo.cache.McRoleCache;
import com.matrix.pojo.dto.McUserRoleDto;
import com.matrix.pojo.entity.McRole;
import com.matrix.pojo.entity.McSysFunction;
import com.matrix.pojo.entity.McUserInfo;
import com.matrix.pojo.entity.McUserRole;
import com.matrix.service.IManagerCenterService;
import com.matrix.service.IMcRoleService;
import com.matrix.service.IMcSysFunctionService;
import com.matrix.service.IMcUserInfoService;

/**
 * @description: 系统权限控制器
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2017年3月1日 上午10:14:02 
 * @version 1.0.0
 */
@Controller
@RequestMapping("sysrole")
public class SystemRoleController {
	private static Logger logger = Logger.getLogger(SystemRoleController.class);
	
	@Autowired
	private IManagerCenterService service;  // 系统权限主服务
	
	@Autowired
	private IMcSysFunctionService mcSysFunctionService;   
	
	@Autowired
	private IMcRoleService mcRoleService;
	 
	
	/**
	 * @description: 前往树形维护页面
	 * 
	 * @param model 
	 * @author Yangcl 
	 * @date 2017年3月1日 上午11:03:16 
	 * @version 1.0.0.1
	 */
	@RequestMapping("tree_page_index") 
	public String treePageIndex(ModelMap model){
//		McSysFunction e = new McSysFunction();	
//		e.setFlag(1);
//		model.put("jsonTree", mcSysFunctionService.jsonList(e)); 
		return "jsp/syssetting/sysFunction"; 
	}
	
	@RequestMapping(value = "tree_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject treeList(HttpServletRequest request){
		return mcSysFunctionService.treeList(request);
	}
	
	

	/**
	 * @description: 前往权限列表页 
	 * 
	 * @param model
	 * @return
	 * @author Yangcl 
	 * @date 2017年5月19日 下午2:05:03 
	 * @version 1.0.0.1
	 */
	@RequestMapping("sys_mc_role_page") 
	public String sysMcRolePage(ModelMap model){ 
		return "jsp/syssetting/role/sysMcRoleList";   
	}
	
	
	@RequestMapping(value = "sys_role_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject sysRoleList(McRole role , HttpServletRequest request) {
		role.setFlag(1); 
		return mcRoleService.ajaxPageData(role, request);
	}
	
	/**
	 * @description: 前往添加权限页面 
	 * 
	 * @author Yangcl 
	 * @date 2017年5月19日 下午8:41:07 
	 * @version 1.0.0.1
	 */
	@RequestMapping("show_role_add_page") 
	public String sysMcRoleAddPage(ModelMap model){ 
		return "jsp/syssetting/role/sysMcRoleAdd";   
	}
	
	/**
	 * @description: 添加一个角色，不勾选系统功能|如果同时需要勾选系统功能请使用 @ public JSONObject addMcRole(McRoleCache d , HttpSession session)
	 * 
	 * @author Yangcl 
	 * @date 2017年5月19日 下午9:10:56 
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "add_mc_role_only", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject addMcRoleOnly(McRole info , HttpSession session) {
		return mcRoleService.addMcRole(info , session);
	}
	
	/**
	 * @description: 前往修改权限页面 
	 * 
	 * @author Yangcl 
	 * @date 2017年5月19日 下午10:00:02 
	 * @version 1.0.0.1
	 */
	@RequestMapping("show_role_edit_page") 
	public String sysMcRoleEditPage(Integer id , ModelMap model){ 
		McRole entity = mcRoleService.find(id);
		if(entity != null){
			model.addAttribute("entity", entity);  
		}
		return "jsp/syssetting/role/sysMcRoleEdit";   
	}
	
	
	
	/**
	 * @description: 获取有效商户列表 
	 * 
	 * @author Yangcl 
	 * @date 2017年3月1日 上午10:57:09 
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "company_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject companyList(){
		return service.companyList();
	}
	
	/**
	 * @description: 添加一个节点到数据库
	 * 
	 * @param e
	 * @param session 
	 * @author Yangcl 
	 * @date 2017年3月1日 上午11:05:51 
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "add_tree_node", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject addTreeNode(McSysFunction e , HttpSession session){
		return mcSysFunctionService.addInfo(e, session);	
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
	@RequestMapping(value = "edit_tree_node", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject editTreeNode(McSysFunction e , HttpSession session){
		return mcSysFunctionService.editInfo(e, session);	
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
	@RequestMapping(value = "update_tree_nodes", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject updateTreeNodes(String ustring , HttpSession session){
		return mcSysFunctionService.updateTreeNodes(ustring, session);	
	}
	
	
	@RequestMapping(value = "delete_node", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject deleteNode(Integer id , HttpSession session){
		return mcSysFunctionService.deleteNode(id, session);	
	}
	
	/**
	 * @description: 创建系统角色
	 * 
	 * @param d
	 * @param session
	 * @author Yangcl 
	 * @date 2017年4月11日 上午10:45:06 
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "add_mc_role", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject addMcRole(McRoleCache d , HttpSession session){
		return mcSysFunctionService.addMcRole(d, session);	
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
	@RequestMapping(value = "edit_mc_role", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject editMcRole(McRoleCache d , HttpSession session){
		return mcSysFunctionService.editMcRole(d, session);	
	}
	
	/**
	 * @description: 删除系统角色
	 * 
	 * @param d
	 * @param session
	 * @author Yangcl 
	 * @date 2017年4月20日 上午11:02:30 
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "delete_mc_role", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject deleteMcRole(McRoleCache d , HttpSession session){
		return mcSysFunctionService.deleteMcRole(d, session);	
	}
	
	/**
	 * @description: 【系统角色创建】->【勾选用户】->【后台人员列表】
	 * 
	 * @param entity			 
	 * @param request
	 * @author Yangcl 
	 * @date 2017年4月20日 下午7:25:12 
	 * @version 1.0.0.1
	 */
//	@RequestMapping(value = "mc_user_list", produces = { "application/json;charset=utf-8" })
//	@ResponseBody
//	public JSONObject mcUserList(McUserInfo entity , HttpServletRequest request){
//		return mcSysFunctionService.mcUserList(entity, request);
//	}
	
	
	/**
	 * @description: 关联用户与某一个角色
	 * 
	 * @param entity
	 * @return
	 * @author Yangcl 
	 * @date 2017年4月20日 下午7:29:12 
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "add_user_role", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject addUserRole(McUserRole entity , HttpSession session){
		return mcSysFunctionService.addUserRole(entity , session);
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
	@RequestMapping(value = "user_role_func_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject userRoleFuncList(McUserRoleDto dto , HttpServletRequest request){
		return mcSysFunctionService.userRoleFuncList(dto , request);
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
	@RequestMapping(value = "delete_user_role", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject deleteUserRole(McUserRoleDto d , HttpSession session){
		return mcSysFunctionService.deleteUserRole(d, session);	
	}
}





















































