package org.sms.modules.basemanage.service;

import javax.servlet.http.HttpSession;

import org.sms.core.DataGrid;
import org.sms.core.PagerHelper;
import org.sms.modules.basemanage.modelPage.Remind;

public interface RemindServiceI {
	/**
	 * 分页显示提醒列表
	 * @param ph
	 * @param session
	 * @return
	 */
	public DataGrid dataGrid(PagerHelper ph,HttpSession session);
	
	/**
	 * 关闭提醒
	 * @param id
	 */
	public void closeRemind(Integer id);
	
	/**
	 * 发布提醒
	 * @param remind
	 * @param session
	 */
	public void openRemind(Remind remind, HttpSession session);
}
