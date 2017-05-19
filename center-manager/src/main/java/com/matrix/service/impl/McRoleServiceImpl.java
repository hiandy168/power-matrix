package com.matrix.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseServiceImpl;
import com.matrix.cache.CacheLaunch;
import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.inf.IBaseLaunch;
import com.matrix.cache.inf.ICacheFactory;
import com.matrix.dao.IMcRoleDao;
import com.matrix.pojo.cache.McRoleCache;
import com.matrix.pojo.entity.McRole;
import com.matrix.pojo.entity.McUserInfo;
import com.matrix.service.IMcRoleService;

@Service("mcRoleService") 
public class McRoleServiceImpl extends BaseServiceImpl<McRole, Integer> implements IMcRoleService {
	
	private IBaseLaunch<ICacheFactory> launch = CacheLaunch.getInstance().Launch();
	
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

	
	@Override
	public JSONObject addMcRole(McRole role , HttpSession session) {
		JSONObject result = new JSONObject();
		if(StringUtils.isBlank(role.getRoleName())){
			result.put("status", "error");
			result.put("msg", "角色名称不得为空");
			return result;
		}
		Date createTime = new Date();
		McUserInfo userInfo = (McUserInfo) session.getAttribute("userInfo");
		role.setFlag(1);
		role.setCreateTime(createTime);
		role.setUpdateTime(createTime);
		role.setRemark("");
		role.setCreateUserId(userInfo.getId());
		role.setUpdateUserId(userInfo.getId());
		try {
			int count = dao.insertSelectiveGetZid(role);
			if(count == 1){
				result.put("status", "success");
				result.put("msg", "添加成功");
				McRoleCache c = new McRoleCache();
				c.setMcRoleId(role.getId());
				c.setRoleName(role.getRoleName());
				c.setRoleDesc(role.getRoleDesc());               // 添加时候 缓存信息不完整
				launch.loadDictCache(DCacheEnum.McRole).setCache(role.getId().toString() , JSONObject.toJSONString(c));   
			}else{
				result.put("status", "error");
				result.put("msg", "添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "error");
			result.put("msg", "服务器异常");
		}
		return result;
	}
	
}





























