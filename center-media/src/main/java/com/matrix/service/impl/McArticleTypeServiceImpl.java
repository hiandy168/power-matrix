package com.matrix.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.matrix.base.BaseServiceImpl;
import com.matrix.dao.IMcArticleInfoDao;
import com.matrix.dao.IMcArticleTypeDao;
import com.matrix.pojo.entity.McArticleType;
import com.matrix.service.IMcArticleTypeService;

@Service("mcArticleTypeService")
public class McArticleTypeServiceImpl extends BaseServiceImpl<McArticleType, Integer> implements IMcArticleTypeService {
	@Resource
	private IMcArticleInfoDao mcArticleInfoDao;
	
	@Resource
	private IMcArticleTypeDao mcArticleTypeDao;

	/**
	 * @description: 返回页面格式数据，同时 格式化时间 
	 * 
	 * @param e
	 * @param request
	 * @param session
	 * @author Yangcl 
	 * @date 2017年6月16日 下午3:15:12 
	 * @version 1.0.0.1
	 */
	@Override
	public JSONObject ajaxArticleAssortList(McArticleType e , HttpServletRequest request, HttpSession session) {
		JSONObject r = super.ajaxPageData(e, request);
		if(r.getString("status").equals("success")){
			JSONObject data = r.getJSONObject("data");
			JSONArray list = new JSONArray();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for(int i = 0 ; i < data.getJSONArray("list").size() ; i ++){
				Date ctime = data.getJSONArray("list").getJSONObject(i).getDate("createTime");
				String cdate = sdf.format(ctime); 
				Date utime = data.getJSONArray("list").getJSONObject(i).getDate("updateTime");
				String udate = sdf.format(utime); 
				JSONObject o = data.getJSONArray("list").getJSONObject(i);
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



















