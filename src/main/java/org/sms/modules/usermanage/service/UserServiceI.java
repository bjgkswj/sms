package org.sms.modules.usermanage.service;

import java.util.List;

import org.sms.core.DataGrid;
import org.sms.core.SessionInfo;
import org.sms.modules.usermanage.modelPage.User;

public interface UserServiceI {
	public User login(User user);
	
	public List<User> getXygwList(SessionInfo sessionInfo);
	
	public DataGrid dataGrid(User user);
	
	public void add(User user) throws Exception;
	
	public void edit(User user);
	
	public User get(int id);
}
