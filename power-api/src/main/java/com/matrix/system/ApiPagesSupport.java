package com.matrix.system;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.matrix.system.cache.SysWorkDir;
import com.matrix.util.IoUtil;

/**
 * @description: 为ApiSystemInit.java提供远程火力 
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2016年11月30日 下午5:00:55 
 * @version 1.0.0
 */
public class ApiPagesSupport {

	public boolean supportInit(){
		try {
			String path = new SysWorkDir().getServerletPath("jsp/api_pages/");
			FileUtils.deleteDirectory(new File(path));
			IoUtil.createDir(path);
			new IoUtil().copyDir("classpath*:META-INF/api_pages/" ,  path);    
			System.out.println("power-api 加载完成"); 
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean supportDelete(){
		try {
			String path = new SysWorkDir().getServerletPath("jsp/api_pages/");
			FileUtils.deleteDirectory(new File(path));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
