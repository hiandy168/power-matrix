package com.matrix.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseServiceImpl;
import com.matrix.dao.IUserDemoDao;
import com.matrix.pojo.entity.UserDemo;
import com.matrix.service.IExampleService;
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
		result.put("state", "文件上传失败!");  
		result.put("title", "");  
		result.put("original", "");   
    	result.put("url", "");  
    	
    	
		String cfileUrl = "http://hjy-manage.huijiayou.cn/cfamily/upload/";
		if(type.equals("uploadimage")){
			cfileUrl += "realsave";
		}else{
			cfileUrl += "upload"; 
		}
		
		RequestDispatcher  dispatcher = request.getRequestDispatcher(cfileUrl);  
		try {
			dispatcher.forward(request, response); 
			if (response != null) {  
				ServletOutputStream  os  =response.getOutputStream();
				
				String msg = os.toString();
				
				result.put("state", "SUCCESS");  
				result.put("title", "1496889480565005232.png");  
				result.put("original", "QQ图片20161222141428.png");  
				result.put("type", ".png");  
				result.put("url", "/cfiles/staticfiles/upload/ueditor/1496889480565005232.png");  
				result.put("size", "127769");  
		    }
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	private String parseString(OutputStream out){
        ByteArrayOutputStream baos = new   ByteArrayOutputStream();
        baos = (ByteArrayOutputStream) out;
        ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
        return swapStream.toString();
    }
}



















