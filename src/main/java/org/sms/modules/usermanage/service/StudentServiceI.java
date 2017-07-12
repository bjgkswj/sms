package org.sms.modules.usermanage.service;

import org.sms.core.DataGrid;
import org.sms.core.SessionInfo;
import org.sms.modules.usermanage.model.SmsStudent;
import org.sms.modules.usermanage.modelPage.Student;

public interface StudentServiceI {
	public DataGrid dataGrid(Student stu, SessionInfo sessionInfo);
	
	public void add(Student stu);
	
	public void edit(Student stu);
	
	public void delete(String id);
	
	public String getStuNo();
	
	public SmsStudent get(String id);
}
