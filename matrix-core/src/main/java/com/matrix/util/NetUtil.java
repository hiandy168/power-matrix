package com.matrix.util;

import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.util.Enumeration;

import org.apache.commons.lang.StringUtils;

import com.matrix.base.BaseClass;


/**
 * @description: 与网路相关的工具集合
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2016年9月29日 下午3:09:07 
 * @version 1.0.0
 */
public class NetUtil extends BaseClass {

	/**
	 * @description: 获取本机IP地址信息
	 * 
	 * @return
	 * @author Yangcl 
	 * @date 2016年9月29日 下午3:08:41 
	 * @version 1.0.0.1
	 */
	public static String getLocalIP() {
		String address = "";
		try {
			Enumeration<?> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress ine = null;
			while (allNetInterfaces.hasMoreElements() && address.equals("")) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
				if (!netInterface.isVirtual()) {
					Enumeration<?> addresses = netInterface.getInetAddresses();
					while (addresses.hasMoreElements() && address.equals("")) {
						ine = (InetAddress) addresses.nextElement();
						if (ine != null && ine instanceof Inet4Address) {
							if (!ine.getHostAddress().equals("127.0.0.1") && !netInterface.isVirtual()) {
								address = ine.getHostAddress();
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return address.trim();
	}

	/**
	 * @description: 判断url根域是否可以访问 |比如传入http://www.srnpr.com/a/b/c.html
	 * 							 只会判断http://www.srnpr.com是否可访问
	 * 
	 * @param url
	 * @return
	 * @author Yangcl 
	 * @date 2016年9月29日 下午3:09:35 
	 * @version 1.0.0.1
	 */
	public static boolean checkUrlHost(String url) {
		// 判断如果没有带标记 则增加标记
		if (!StringUtils.containsIgnoreCase(url, "://")) {
			url = "http://" + url;
		}
		String sHttpString = StringUtils.substringBefore(url, "//");
		url = sHttpString + "//" + StringUtils.substringBefore(StringUtils.substringAfter(url, "//"), "/");
		return checkUrlStatus(url);
	}
 
	/**
	 * @description: 判断url是否可以访问
	 * 
	 * @param urlStr
	 * @return
	 * @author Yangcl 
	 * @date 2016年9月29日 下午3:11:42 
	 * @version 1.0.0.1
	 */
	private static boolean checkUrlStatus(String urlStr) {
		boolean bFlag = false;
		int counts = 0;
		if (urlStr == null || urlStr.length() <= 0) {
			return bFlag;
		}
		
		// 只检测一次
		while (counts < 1) {
			try {
				URL url = new URL(urlStr);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setConnectTimeout(2000);
				int state = con.getResponseCode();
				if (state == 200||state==404) {
					bFlag = true;
				} else {
					logger.logWarn(NetUtil.class, "connect to " + urlStr + " return status " + state);
				}
				break;
			} catch (Exception ex) {
				counts++;
				ex.printStackTrace();
				continue;
			}
		}
		return bFlag;
	}

}
