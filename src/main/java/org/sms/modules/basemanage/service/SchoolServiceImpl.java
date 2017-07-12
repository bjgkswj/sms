package org.sms.modules.basemanage.service;

import java.util.List;

import org.sms.modules.basemanage.dao.SchoolDaoI;
import org.sms.modules.basemanage.model.SmsSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl implements SchoolServiceI{
	@Autowired
	private SchoolDaoI schoolDao;
	
	@Override
	public List<SmsSchool> getShoolList() {
		String hql = "from SmsSchool";
		List<SmsSchool> schoolList = schoolDao.find(hql);
		return schoolList;
	}

}
