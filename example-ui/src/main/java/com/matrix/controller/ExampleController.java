package com.matrix.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.matrix.pojo.entity.UserDemo;
import com.matrix.service.IExampleService;

/**
 * @descriptions 所有【示例】相关的后台方法都在这里 
 * 
 * @author Yangcl
 * @date 2016年5月28日-下午4:40:04
 * @version 1.0.0
 */
@Controller
@RequestMapping("example")
public class ExampleController{
	private static Logger logger=Logger.getLogger(ExampleController.class);
	
	@Autowired
	private IExampleService exampleService;
	
	
	/**
	 * @descriptions 前往添加页面 addExample.jsp
	 * 
	 * @author Yangcl
	 * @date 2016年6月13日-下午10:53:55
	 * @version 1.0.0.1
	 */
	@RequestMapping("addInfoPage")
	public String toAddPage(HttpSession session){ 
		return "jsp/example/addExample"; 
	}
	
	/**
	 * @descriptions 添加一条信息到数据库，成功后跳转回添加页面|并对密码做MD5加密处理
	 * 
	 * 页面传递到SpringMvc的时候会出现400错误，意味着参数类型与实体的不对应
	 * 数据库中是Data类型故实体类中的字段也是Date类型，但页面传的是String类型
	 * 所以才导致400错误。此时需要将Date类型的字段改成String类型此问题即可解决。
	 * 且不会影响数据的插入。
	 * 
	 * @author Yangcl
	 * @date 2016年6月13日-下午11:04:45
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "addInfo", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject addInfo(UserDemo entity , HttpSession session){ 
		return exampleService.addInfo(entity, session);  
	}
	
	 
	/**
	 * @descriptions 简单分页示例 Ajax分页 不涉及弹窗分页问题 
	 * 
	 * @date 2016年8月17日下午5:44:52
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	@RequestMapping("ajaxFormExample")
	public String toAjaxFormExample(HttpSession session){ 
		return "jsp/example/ajaxFormExample"; 
	}
	
	@RequestMapping(value = "ajaxPageData", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject ajaxPageData(UserDemo entity , HttpServletRequest request, HttpSession session){
		logger.info(" to ajaxFormExample.jsp  ... "); 
		return exampleService.ajaxPageData(entity, request);  
	}
	
	
	/**
	 * @descriptions Ajax分页 且弹窗同时分页
	 * 
	 * @date 2016年8月17日下午5:44:52
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	@RequestMapping("ajaxFormDialogExample")
	public String toAjaxFormDialogExample(HttpSession session){ 
		return "jsp/example/ajaxFormDialogExample"; 
	}
	
	
	
	/**
	 * @descriptions 自定义 alert confirm note
	 * 
	 * @param session 
	 * @date 2016年8月22日上午11:43:59
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */ 
	@RequestMapping("alertExample")
	public String toAlertExample(HttpSession session){ 
		// TODO 按钮权限控制等等
		return "jsp/example/alertExample"; 
	}

	
	@RequestMapping(value = "deleteOne", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject deleteOne(UserDemo info){
		return exampleService.deleteOne(info); 
	}
	
	
	
	@RequestMapping("editInfoPage")   
	public String editInfoPage(UserDemo info , ModelMap model , HttpServletRequest request, HttpSession session){
//		if(StringUtils.isNotBlank(info.getId().toString())){
//			UserInfo entity = userInfoService.find(info.getId());
//			if(entity != null){
//				model.addAttribute("entity", entity);
//			}
//		}
		
		return "jsp/example/editExample"; 
	}
	
	@RequestMapping(value = "editInfo", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject editInfo(UserDemo info){
//		return userInfoService.editInfo(info);
		return null;
	}
	
	
	
	/**
	 * @descriptions 实际样本-A
	 *  
	 * @date 2016年11月28日 上午10:32:24 
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "example_a")
	public String example_a() { 
		return "jsp/example/reality/questionQuery";
	}

	/**
	 * @description: 实际样本-B
	 * 
	 * @return
	 * @author Yangcl 
	 * @date 2016年11月28日 上午10:32:24 
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "example_b")
	public String example_b() { 
		return "jsp/example/reality/validate";
	}
	// 实际样本-B 
	@RequestMapping(value = "example_b1")
	public String example_c(String key, HttpSession session) { 
		if(key.equals("whosyourdaddy")){ 
			session.setAttribute("kjt-key", "kjt-key"); // 写入session
			return "redirect:/jsp/example/reality/index.jsp";    
		}else{ 
			return "redirect:/jsp/example/reality/validate.jsp";
		} 
	}
	// 离开此页面
	@RequestMapping(value = "leave")
	public String leave(HttpSession session ) { 
		session.setAttribute("kjt-key", null); // 删除session
		return "redirect:/jsp/example/reality/validate.jsp";    
	}
	
	@RequestMapping("block_ui_page")
	public String blockUiPage(HttpSession session){ 
		return "jsp/example/blockUiPageExample"; 
	}
}































