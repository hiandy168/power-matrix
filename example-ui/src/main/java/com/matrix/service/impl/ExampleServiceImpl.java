package com.matrix.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseServiceImpl;
import com.matrix.dao.IUserDemoDao;
import com.matrix.pojo.entity.UserDemo;
import com.matrix.service.IExampleService;
import com.matrix.support.FileUploadSupport;
import com.matrix.util.SignUtil;

@Service("exampleService")
public class ExampleServiceImpl  extends BaseServiceImpl<UserDemo, Integer> implements IExampleService {
	@Resource
	private IUserDemoDao userDemoDao;

	public JSONObject addInfo(UserDemo entity, HttpSession session) {
		JSONObject result = new JSONObject();
		String pass = SignUtil.md5Sign(entity.getPassword());
		entity.setPassword(pass); 
		entity.setCreateTime(new Date());
		Integer count = userDemoDao.insertSelective(entity);
		if(count == 1){
			result.put("status", true);
			result.put("msg", "数据插入成功！");
		}else{
			result.put("status", false);
			result.put("msg", "数据插入异常！");
		}
		return result;
	}

	public JSONObject deleteOne(UserDemo entity) {
		JSONObject result = new JSONObject();
		if(StringUtils.isNotBlank(entity.getId().toString())){
			Integer count = userDemoDao.deleteById(entity.getId());
			if(count == 1){
				result.put("status", "success");
				result.put("msg", "删除成功");
			}else{
				result.put("status", "error");
				result.put("msg", "删除失败");
			}
		}else{
			result.put("status", "error");
			result.put("msg", "删除记录Id不可为空");
		}
		return result;
	}

	
	/**
	 * @description: 针对UE，采用自定义的上传图片方式|
	 * 	此种方式使用cfile接口将图片上传到图片服务器
	 * 
	 * @param type uploadimage:上传图片|uploadfile:上传文件
	 * @param request
	 * @param response
	 * @return
	 * @author 付强 
	 * @date 2017年6月8日 下午3:21:48 
	 * @version 1.0.0.1
	 */
	public JSONObject ajaxUploadFileCfile(String type , HttpServletRequest request, HttpServletResponse response) {
		JSONObject result = new JSONObject();
		List<FileItem> items = FileUploadSupport.getInstance().getFileFromRequest(request);
		if (items != null && items.size() > 0) {
			for (FileItem fi : items) {
				String remoteUpload = FileUploadSupport.getInstance().remoteUpload("upload" , fi.getName() , fi.get());
//				System.out.println(remoteUpload);
				JSONObject t = JSONObject.parseObject(remoteUpload, result.getClass());
				String imgs = t.getString("resultObject");
				if(t.getInteger("resultCode") == 1 && StringUtils.isNotBlank(imgs) && imgs.length() > 0) {
					//编辑器编辑上传图片，暂时只支持上传一张图片
					result.put("state", "SUCCESS");
					result.put("title", imgs.substring(imgs.lastIndexOf("/")+1));
					result.put("original", fi.getName());
					result.put("type", imgs.substring(imgs.lastIndexOf(".")));
					result.put("url", imgs);
					result.put("size", fi.getSize());
				} else {
					result.put("state", "上传失败");
					result.put("title", "");
					result.put("original", "");
					result.put("type", "");
					result.put("url", "");
					result.put("size", "");
				}
			}
		}
		return result;
	}
}



















