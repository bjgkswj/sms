package org.sms.system;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sms.core.SessionInfo;
import org.sms.util.ConfigUtil;

public class ZmServiceSimple extends ZmService{

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void setAliasname(String aliasname) {
		this.aliasname = aliasname;
	}

	@Override
	public void setOptyTime(Date optyTime) {
		this.optyTime = optyTime;
	}

	@Override
	public void setIpAddress(String ipAddress) {
		this.IpAddress = ipAddress;
	}

	@Override
	public void setSession(HttpSession session) {
		this.session = session;
	}
	
	/**
	 * 初始化 日志记录参数
	 * @param sessioin
	 */
	public void initLogParam(HttpSession sessioin){
		SessionInfo sessionInfo = (SessionInfo)session.getAttribute(ConfigUtil.getSessionInfoName());
		this.setAliasname(sessionInfo.getName());
		this.setIpAddress(sessionInfo.getIp());
		this.setOptyTime(new Date());
		this.setUsername(sessionInfo.getUsername());
	}
	
	public void initLogParam(HttpServletRequest request){
		
	}

}
