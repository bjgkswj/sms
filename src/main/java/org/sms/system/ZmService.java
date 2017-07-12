package org.sms.system;

import java.util.Date;

import javax.servlet.http.HttpSession;

/**
 * 如果想让某个service方法使用AOP特性，请将自己的Service实现该类
 * @author ZMZY
 *
 */
public abstract class ZmService {
	public String username;
	public String aliasname;
	public Date optyTime;
	public String IpAddress;
	public HttpSession session;
	public String getUsername() {
		return username;
	}
	/**
	 * 设置用户名
	 * @param username
	 */
	public abstract void setUsername(String username);
	public String getAliasname() {
		return aliasname;
	}
	/**
	 * 设置别名
	 * @param aliasname
	 */
	public abstract void setAliasname(String aliasname);
	public Date getOptyTime() {
		return optyTime;
	}
	/**
	 * 设置操作时间
	 * @param optyTime
	 */
	public abstract void setOptyTime(Date optyTime);
	public String getIpAddress() {
		return IpAddress;
	}
	/**
	 * 设置操作IP
	 * @param ipAddress
	 */
	public abstract void setIpAddress(String ipAddress);
	public HttpSession getSession() {
		return session;
	}
	/**
	 * 设置HttpSession
	 * @param session
	 */
	public abstract void setSession(HttpSession session);
}
