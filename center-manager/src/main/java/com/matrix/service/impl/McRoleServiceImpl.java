package com.matrix.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseServiceImpl;
import com.matrix.dao.IMcRoleDao;
import com.matrix.pojo.entity.McRole;
import com.matrix.service.IMcRoleService;

@Service("mcRoleService") 
public class McRoleServiceImpl extends BaseServiceImpl<McRole, Integer> implements IMcRoleService {
	
	@Resource
	private IMcRoleDao dao;
	
	/**
	 * @description:返回列表数据，格式化时间 
	 * 
	 * @param e
	 * @param request
	 * @return
	 * @author Yangcl 
	 * @date 2017年5月19日 下午2:33:24 
	 * @version 1.0.0.1
	 */
	public JSONObject ajaxPageData(McRole e , HttpServletRequest request){
		JSONObject r = super.ajaxPageData(e, request);
		if(r.getString("status").equals("success")){
			JSONObject data = r.getJSONObject("data");
			JSONArray list = new JSONArray();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for(int i = 0 ; i < data.getJSONArray("list").size() ; i ++){
				Date ctime = data.getJSONArray("list").getJSONObject(i).getDate("createTime");
				String date = sdf.format(ctime); 
				JSONObject o = data.getJSONArray("list").getJSONObject(i);
				o.put("createTime", date);
				list.add(o);
			}  
			data.put("list", list); 
			r.put("data", data); 
		}
		return r;
	}
	
}





























