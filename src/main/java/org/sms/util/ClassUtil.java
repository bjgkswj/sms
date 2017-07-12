package org.sms.util;

/**
 * ClassUtil.java
 * @author ZMZY
 *
 */
public class ClassUtil {

	/**
	 * 判断implementclass是否是infertanceclass的实现类:如果implementclass不存在 怎返回false
	 * @param implementclass
	 * @param infertanceclass
	 * @return
	 */
	public static boolean isImplementclass(Class implementclass,Class infertanceclass){
		
		try{
			Object o = implementclass.newInstance();
			infertanceclass.cast(o);
			return true;
		}catch(Exception e){
			
			return false;
		}
	}
	
	/**
	 * 判断类名 是否正确
	 * @param classname
	 * @return
	 */
	public static boolean classIsTrue(String classname){

		classname = (classname == null ? "" : classname.trim());
		if("".equals(classname)){
			return false;
		}
		try{
			ClassLoaderUtil.loadClass(classname);
			return true;
			}catch(Exception e){
				return false;
			}	
	}	
}