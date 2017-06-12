package com.matrix.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseServiceImpl;
import com.matrix.dao.IUserDemoDao;
import com.matrix.pojo.entity.UserDemo;
import com.matrix.service.IExampleService;
import com.matrix.uploadSupport.WebUpload;
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
	 * @author Yangcl 
	 * @date 2017年6月8日 下午3:21:48 
	 * @version 1.0.0.1
	 */
	public JSONObject ajaxUploadFileCfile(String type , HttpServletRequest request, HttpServletResponse response) {
		
		JSONObject result = new JSONObject();
		//上传图片
		
		
		List<FileItem> items = WebUpload.create().upFileFromRequest(request);
		
		if (items != null && items.size() > 0) {
			
			for (FileItem fi : items) {
				
				String remoteUpload = WebUpload.create().remoteUpload("upload",fi.getName(),fi.get());
				System.out.println(remoteUpload);
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
		
		/*
		JSONObject result = new JSONObject();
		result.put("state", "文件上传失败!");  
		result.put("title", "");  
		result.put("original", "");   
    	result.put("url", "");  
    	// TODO upload image ... 
    	
    	
    	
    	
    	
		if (type != null) {  
			result.put("state", "SUCCESS");  
			result.put("title", "1496889480565005232.png");  
			result.put("original", "QQ图片20161222141428.png");  
			result.put("type", ".png");  
			result.put("url", "/cfiles/staticfiles/upload/ueditor/1496889480565005232.png");  
			result.put("size", "127769");  
	    }*/
		return result;
	}
	
	
	public void getFile(String url) throws ClientProtocolException, IOException {
		
	    CloseableHttpClient httpclient = HttpClients.createDefault();// 生成一个httpclient对象
	    HttpPost post = new HttpPost(url);
	    HttpResponse response = httpclient.execute(post);
//	    HttpEntity entity = response.getEntity();
	    
	    
	    httpclient.close();
	}
	
	
	
	
	
	
	
	
	
	
	public JSONObject ajaxUploadFileCfileTest(String type , HttpServletRequest request, HttpServletResponse response) {
		List<FileItem> upfile = analysisRequest(request);
		if(null !=upfile && upfile.size() > 0) {
			FileItem fileItem = upfile.get(0);
			fileItem.getFieldName();
			fileItem.getName();
			System.out.println(fileItem.getName());
		}
		
		JSONObject result = new JSONObject();
		return result;
	}

	public List<FileItem> analysisRequest(HttpServletRequest request) {
		List<FileItem> items = null;
		String sContentType = request.getContentType();
		if (StringUtils.contains(sContentType, "multipart/form-data")) {  // 如果是上传二进制数据
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);

			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			} // 得到所有的文件
			/*
			 * for (FileItem fUploadFileItem : items) { if
			 * (!fUploadFileItem.isFormField()) { fi = fUploadFileItem; } }
			 */
		}
		return items;
	}
	
}



















