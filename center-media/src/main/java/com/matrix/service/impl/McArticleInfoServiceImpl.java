package com.matrix.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseServiceImpl;
import com.matrix.dao.IMcArticleInfoDao;
import com.matrix.dao.IMcArticleTypeDao;
import com.matrix.pojo.entity.McArticleInfo;
import com.matrix.service.IMcArticleInfoService;

@Service("mcArticleInfoService")
public class McArticleInfoServiceImpl extends BaseServiceImpl<McArticleInfo, Integer> implements IMcArticleInfoService {

	@Resource
	private IMcArticleInfoDao mcArticleInfoDao;
	
	@Resource
	private IMcArticleTypeDao mcArticleTypeDao;
	
	
	/**
	 * @description: 根据release_type，获取对应状态的分类列表
	 * 	release_type：发布状态， 01:未发布|02:已发布|03:草稿箱|04:回收站
	 * 
	 * @param e
	 * @param request
	 * @param session
	 * @author Yangcl 
	 * @date 2017年6月28日 下午3:08:44 
	 * @version 1.0.0.1
	 */
	public JSONObject ajaxArticleList(McArticleInfo e, HttpServletRequest request, HttpSession session) {
		JSONObject r = super.ajaxPageData(e, request);
		if(r.getString("status").equals("success")){
			JSONObject data = r.getJSONObject("data");
			JSONArray list = new JSONArray();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for(int i = 0 ; i < data.getJSONArray("list").size() ; i ++){
				Date rtime = data.getJSONArray("list").getJSONObject(i).getDate("releaseTime");
				String rdate = sdf.format(rtime); 
				Date ctime = data.getJSONArray("list").getJSONObject(i).getDate("createTime");
				String cdate = sdf.format(ctime); 
				Date utime = data.getJSONArray("list").getJSONObject(i).getDate("updateTime");
				String udate = sdf.format(utime); 
				JSONObject o = data.getJSONArray("list").getJSONObject(i);
				o.put("releaseTime", rdate); 
				o.put("createTime", cdate);
				o.put("updateTime", udate);
				list.add(o);
			}  
			data.put("list", list); 
			r.put("data", data); 
		}
		return r;
	}  


}





































