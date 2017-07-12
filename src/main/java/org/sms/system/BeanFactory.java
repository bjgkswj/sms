package org.sms.system;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;

public class BeanFactory {
	public static ApplicationContext myapplicationContext;
	private static ServletContext servletContext;
	
	public static <T extends Object> T getBean(String name,Class<T> entityClass){
		return myapplicationContext.getBean(name, entityClass);
	}
	
	public static ServletContext getServletContext() {
		return servletContext;
	}
	public static void setServletContext(ServletContext servletContext) {
		BeanFactory.servletContext = servletContext;
	}
}
