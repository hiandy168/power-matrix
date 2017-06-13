package com.matrix.support;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import com.matrix.base.BaseClass;

/**
 * @description: 文件上传组件|将图片内容等上传到cfile服务器中
 * 	配置参照：config.matrix-core.properties
 *  FileUpload.getInstance().upFileFromRequest(request)
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2017年6月12日 下午2:24:03 
 * @version 1.0.0
 */
public class FileUploadSupport extends BaseClass{
	
	private String url = "";
	private FileUploadSupport(){
		String model = this.getConfig("matrix-core.model"); // dev or master 
		if(!model.equals("master")){
			model = "beta";
		}
		url = this.getConfig("matrix-core.upload_pic_url_" + model); 
	}
	private static class LazyHolder{
		private static final FileUploadSupport INSTANCE = new FileUploadSupport();
	}
	public static final FileUploadSupport getInstance() {
		return LazyHolder.INSTANCE; 
	}
	
	
	/**
	 * @description: 获取request的上传文件
	 * 
	 * @param request
	 * @return
	 * @author 付强
	 * @date 2017年6月12日 下午2:01:26 
	 * @version 1.0.0.1
	 */
	public List<FileItem> getFileFromRequest(HttpServletRequest request) {
		List<FileItem> items = null;   // 得到所有的文件
		String sContentType = request.getContentType();
		if (StringUtils.contains(sContentType, "multipart/form-data")) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			} 
		}
		return items;
	}
	
	
	/**
	 * @description: 远程上传文件
	 * 
	 * @param target cfile服务器接口的识别码
	 * @param fileName 
	 * @param b
	 * @return
	 * @author 付强
	 * @date 2017年6月12日 下午2:02:10 
	 * @version 1.0.0.1
	 */
	public String remoteUpload(String target, String fileName, byte[] b) {
		String returnString = "";
		try {
			String sUrl = url + target;
			MultipartEntityBuilder mb = MultipartEntityBuilder.create();
			mb.addBinaryBody("file", b, ContentType.MULTIPART_FORM_DATA, fileName);
			returnString = WebClientSupport.create().doRequest(sUrl, mb.build());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnString;
	}
}


















