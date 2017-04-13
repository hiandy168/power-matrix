package com.matrix.system;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.matrix.base.BaseClass;
import com.matrix.system.cache.SysWorkDir;
import com.matrix.util.IoUtil;

/**
 * @description: 为DictionaryTableCacheInit.java 提供远程火力 
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2016年11月30日 下午5:00:55 
 * @version 1.0.0
 */
public class DictionaryCacheSupport extends BaseClass{

	public boolean supportInit(){
		try {
			// TODO 加载缓存数据字典相关的表中的内容到Redis中
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean supportDelete(){
		try {
			// TODO 服务器关闭前，删除Redis中的字典缓存数据内容
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
