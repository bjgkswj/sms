package org.sms.util;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

/**
 * SystemUtil.java
 * 
 * @author ZMZY
 * 
 */
public class SystemUtil {

	/**
	 * 获取项目的绝对路径  E:/apache-tomcat-6.0.26/apache-tomcat-6.0.26/apache-tomcat-6.0.26/webapps/ZmSchool/
	 * @return
	 */
	public static String getSystemRootPath() {
		URL url = SystemUtil.class.getProtectionDomain().getCodeSource()
				.getLocation();
		String path = url.toString();
		int index = path.indexOf("WEB-INF");
		if (index == -1) {
			index = path.indexOf("classes");
		}
		if (index == -1) {
			index = path.indexOf("bin");
		}
		path = path.substring(0, index);
		if (path.startsWith("zip")) {// 当class文件在war中时，此时返回zip:D:/...这样的路径
			path = path.substring(4);
		} else if (path.startsWith("file")) {// 当class文件在class文件中时，此时返回file:/D:/...这样的路径
			path = path.substring(6);
		} else if (path.startsWith("jar")) {// 当class文件在jar文件里面时，此时返回jar:file:/D:/...这样的路径
			path = path.substring(10);
		}
		try {
			path = URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public static String getProjectName(){
		String realpath = SystemUtil.getSystemRootPath();
		int index = realpath.lastIndexOf("/");
		int length = realpath.length();
		if((index + 1) == length){
			realpath = realpath.substring(0,index);
		}
		index = realpath.lastIndexOf("/");
		int dindex = realpath.lastIndexOf(".");
		if(dindex != -1 && dindex > index){
			return realpath.substring(index, dindex);
		}
		return realpath.substring(index+1);
		
	}
	
	public static String getRelativeRootPath(){
		return "/" + SystemUtil.getProjectName() + "/";
	}
	
	public static void main(String args[]) {
		System.err.println("---" + SystemUtil.getRelativeRootPath());
	}
}
