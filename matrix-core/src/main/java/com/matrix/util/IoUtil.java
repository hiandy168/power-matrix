package com.matrix.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @description: IO工具类 
 * @alias IoHelper
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2016年11月11日 下午8:51:10 
 * @version 1.0.0
 */
public class IoUtil {

	/**
	 * @description:  创建目录
	 * 
	 * @param dirPath 目录地址
	 * @author Yangcl 
	 * @date 2016年11月11日 下午8:52:42 
	 * @version 1.0.0.1
	 */
	public static void createDir(String dirPath) {
		try {
			FileUtils.forceMkdir(new File(dirPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @description: 根据名称获取资源 名称支持正则表达式 
	 * 
	 * @param resourceName
	 * @return
	 * @throws IOException
	 * @author Yangcl 
	 * @date 2016年11月11日 下午8:52:16 
	 * @version 1.0.0.1
	 */
	public Resource[] upResources(String resourceName) throws IOException {
		Resource[] resources = null;
		PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
		resources = patternResolver.getResources(resourceName);
		return resources;
	}
	

	/**
	 * @description: 复制资源
	 * 
	 * @param sFromClass
	 * @param sToPath
	 * @param sKeyName
	 * @author Yangcl 
	 * @date 2016年11月11日 下午8:53:06 
	 * @version 1.0.0.1
	 */
	public void copyResources(String sFromClass, String sToPath, String sKeyName) {
		try {
			Resource[] resources = upResources(sFromClass);
			for (Resource r : resources) {
				String sUrlString = StringUtils.substringAfter(r.getURI().toString(), sKeyName);
				InputStream inStream = r.getInputStream(); // 读入原文件
				new File(sToPath + sUrlString).getParentFile().mkdirs();
				FileOutputStream fs = new FileOutputStream(sToPath + sUrlString);
				IOUtils.copy(inStream, fs);
				fs.flush();
				fs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
