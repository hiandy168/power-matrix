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
import com.matrix.pojo.dto.McRoleDto;
import com.matrix.pojo.entity.McSysFunction;
import com.matrix.service.IManagerCenterService;
import com.matrix.service.IMcSysFunctionService;

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
	public JSONObject addMcRole(McRoleDto d , HttpSession session){
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
	public JSONObject editMcRole(McRoleDto d , HttpSession session){
		return mcSysFunctionService.editMcRole(d, session);	
	}
}





















































