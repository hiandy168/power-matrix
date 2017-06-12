package com.matrix.uploadSupport;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import com.matrix.support.WebClientSupport;

public class WebUpload {
	
	public static WebUpload create() {
		return new WebUpload();
	};
	/**
	 * 获取request的上传文件
	 * 
	 * @param request
	 * @return
	 */
	public List<FileItem> upFileFromRequest(HttpServletRequest request) {

		List<FileItem> items = null;
		String sContentType = request.getContentType();
		if (StringUtils.contains(sContentType, "multipart/form-data")) {
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
	
	/**
	 * 远程上传文件
	 * 
	 * @param sTarget
	 * @param sFileName
	 * @param b
	 * @return
	 */
	public String remoteUpload(String sTarget, String sFileName, byte[] b) {


		String sReturnString = "";
		try {

			String sUrl = "http://cfiles.beta.huijiayou.cn/cfiles/upload/realsave?zw_s_target=" + sTarget;
			MultipartEntityBuilder mb = MultipartEntityBuilder.create();

			mb.addBinaryBody("file", b, ContentType.MULTIPART_FORM_DATA, sFileName);

			sReturnString = WebClientSupport.create().doRequest(sUrl, mb.build());

		} catch (Exception e) {
			e.printStackTrace();

		}

		return sReturnString;

	}

}
