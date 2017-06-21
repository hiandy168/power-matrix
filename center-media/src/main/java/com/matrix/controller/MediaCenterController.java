package com.matrix.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseController;
import com.matrix.pojo.entity.McArticleType;
import com.matrix.service.IMcArticleTypeService;
import com.matrix.service.impl.McArticleTypeServiceImpl;

/**
 * @description: 媒体库相关服务
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2017年6月15日 下午5:12:38
 * @version 1.0.0
 */

@Controller
@RequestMapping("media")
public class MediaCenterController extends BaseController {
	private static Logger logger = Logger.getLogger(MediaCenterController.class);

	@Autowired
	private IMcArticleTypeService mcArticleTypeService;

	/**
	 * @description: 已发布文章列表|已发布文章，所有人都可以见
	 * 
	 * @param session
	 * @author Yangcl
	 * @date 2017年6月16日 上午10:14:52
	 * @version 1.0.0.1
	 */
	@RequestMapping("page_media_released_list")
	public String mediaReleasedListPage(HttpSession session) {
		super.userBehavior(session, logger, "page_media_released_list", "已发布文章列表 mediaReleasedList.jsp");
		return "jsp/center-manager/article/mediaReleasedList";
	}

	/**
	 * @description: 未发布文章列表| 未发布文章列表，保存的是编辑从草稿箱中提交的文章。只有主管可见，内容发布行为则由主管负责
	 * 
	 * @param session
	 * @author Yangcl
	 * @date 2017年6月16日 上午10:18:28
	 * @version 1.0.0.1
	 */
	@RequestMapping("page_media_unreleased_list")
	public String mediaUnreleasedListPage(HttpSession session) {
		super.userBehavior(session, logger, "page_media_unreleased_list", "未发布文章列表 mediaUnreleasedList.jsp");
		return "jsp/center-manager/article/mediaUnreleasedList";
	}

	/**
	 * @description: 草稿箱列表| 保存了编辑尚未提交到未发布状态的文章，只有编辑人员可见，编辑人员可以看到自己的草稿，不能看到别人的草稿
	 * 
	 * @param session
	 * @author Yangcl
	 * @date 2017年6月16日 上午10:21:11
	 * @version 1.0.0.1
	 */
	@RequestMapping("page_media_drafts_list")
	public String mediaDraftsListPage(HttpSession session) {
		super.userBehavior(session, logger, "page_media_drafts_list", "草稿箱列表 mediaDraftsList.jsp");
		return "jsp/center-manager/article/mediaDraftsList";
	}

	/**
	 * @description: 回收站列表| 回收站里是编辑人员从草稿箱中删除的文章，如果在回收站中删除了一片文章，则再也无法找回。
	 * 
	 * @param session
	 * @author Yangcl
	 * @date 2017年6月16日 上午10:25:01
	 * @version 1.0.0.1
	 */
	@RequestMapping("page_media_recycle_bin_list")
	public String mediaRecycleBinListPage(HttpSession session) {
		super.userBehavior(session, logger, "page_media_recycle_bin_list", "回收站列表 mediaRecycleBinList.jsp");
		return "jsp/center-manager/article/mediaRecycleBinList";
	}
	
	
	/**
	 * @description: 文章分类管理|文章分类管理：海外购、生活电器、厨房用品等等。
	 * 
	 * @param session
	 * @author Yangcl
	 * @date 2017年6月16日 上午10:29:44
	 * @version 1.0.0.1
	 */
	@RequestMapping("page_media_article_assort_manage")
	public String mediaArticleAssortList(HttpSession session) {
		super.userBehavior(session, logger, "page_media_article_assort_manage", "已发布文章列表mediaArticleAssortList.jsp");
		return "jsp/center-manager/assort/mediaArticleAssortList";
	}
	
	/**
	 * @description: 获取文章分类管理列表数据
	 * 
	 * @param session
	 * @author Yangcl 
	 * @date 2017年6月16日 下午3:01:44 
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "ajax_article_assort_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject ajaxArticleAssortList(McArticleType e , HttpServletRequest request , HttpSession session) {
		super.userBehavior(session , logger , "ajax_article_assort_list" , "获取文章分类管理列表数据");   
		return mcArticleTypeService.ajaxArticleAssortList(e , request , session); 
	}
	
	/**
	 * @description: 添加一条记录 
	 * 
	 * @param e
	 * @param request
	 * @param session
	 * @author Yangcl 
	 * @date 2017年6月21日 下午3:17:53 
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "ajax_add_assort", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject ajaxAddAssort(McArticleType e , HttpServletRequest request , HttpSession session) {
		super.userBehavior(session , logger , "ajax_add_assort" , "添加分类记录");   
		return mcArticleTypeService.ajaxAddAssort(e , request , session); 
	}
	
	/**
	 * @description: 更新一条记录
	 * 
	 * @param e
	 * @param request
	 * @param session
	 * @author Yangcl 
	 * @date 2017年6月21日 下午5:54:53 
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "ajax_edit_assort", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject ajaxEditAssort(McArticleType e , HttpServletRequest request , HttpSession session) {
		super.userBehavior(session , logger , "ajax_edit_assort" , "更新分类记录");   
		return mcArticleTypeService.ajaxEditAssort(e , request , session);  
	}
	
	
	/**
	 * @description: 异步删除一条数据 
	 * 
	 * @param e
	 * @param request
	 * @param session
	 * @author Yangcl 
	 * @date 2017年6月21日 下午6:08:05 
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "ajax_delete_assort", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject ajaxDeleteAssort(McArticleType e , HttpServletRequest request , HttpSession session) {
		super.userBehavior(session , logger , "ajax_delete_assort" , "删除分类记录");   
		return mcArticleTypeService.ajaxDeleteAssort(e , request , session);  
	}
	
	
}



















