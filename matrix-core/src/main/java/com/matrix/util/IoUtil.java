package com.matrix.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

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

	/**
	 * @descriptions 文件夹拷贝(文件内含有文件和文件夹) 
	 *
	 * @param sources 源
	 * @param target 目标路径
	 * @date 2016年11月30日 下午10:01:42
	 * @author Yangcl 
	 * @version 1.0.0.1
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	public void copyDir(String sources, String target) throws IOException, URISyntaxException {  
		Resource[] resources = upResources(sources);
		File file1 = null;  
		FileInputStream fis = null;
		for (Resource r : resources) {
			String path = StringUtils.substringAfter(r.getURI().toString(), "jar:file:/");
			String jarName = path.split("!")[0];
			JarFile jar = new JarFile(jarName);
			Enumeration<JarEntry>  ens = jar.entries();
			while(ens.hasMoreElements()){
				JarEntry e = ens.nextElement();
				if(e.getName().equals("META-INF/api_pages/")){
					InputStream input = jar.getInputStream(e);
//					fis = new FileInputStream(input);
				}
			}
		}
		
        File[] fs=file1.listFiles();  
        File file2=new File(target);  
        if(!file2.exists()){  
            file2.mkdirs();  
        }  
        for (File f : fs) {  
            if(f.isFile()){  
                this.fileCopy(f.getPath(),target+"\\"+f.getName()); //调用文件拷贝的方法  
            }else if(f.isDirectory()){  
            	copyDir(f.getPath(),target+"\\"+f.getName());  
            }  
        }  
    }
	
	private void fileCopy(String src, String des) {  
        BufferedReader br=null;  
        PrintStream ps=null;  
        try {  
            br=new BufferedReader(new InputStreamReader(new FileInputStream(src)));  
            ps=new PrintStream(new FileOutputStream(des));  
            String s=null;  
            while((s=br.readLine())!=null){  
                ps.println(s);  
                ps.flush();  
            }  
              
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally{  
                try {  
                    if(br!=null)  br.close();  
                    if(ps!=null)  ps.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
        }  
    }
	
}













