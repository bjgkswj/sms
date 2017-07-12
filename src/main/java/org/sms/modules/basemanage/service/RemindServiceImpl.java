package org.sms.modules.basemanage.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.sms.core.DataGrid;
import org.sms.core.PagerHelper;
import org.sms.core.SessionInfo;
import org.sms.modules.basemanage.dao.RemindDaoI;
import org.sms.modules.basemanage.model.SmsRemind;
import org.sms.modules.basemanage.modelPage.Remind;
import org.sms.modules.usermanage.dao.UserDaoI;
import org.sms.modules.usermanage.model.SmsUser;
import org.sms.util.ConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemindServiceImpl implements RemindServiceI{
	@Autowired
	private RemindDaoI remindDao;
	@Autowired
	private UserDaoI userDao;

	@Override
	public DataGrid dataGrid(PagerHelper ph, HttpSession session) {
		DataGrid dg = new DataGrid();
		//Map<String, Object> params = new HashMap<String, Object>();
		List<Remind> rl = new ArrayList<Remind>();
		SessionInfo sessionInfo = (SessionInfo)session.getAttribute(ConfigUtil.getSessionInfoName());
		
		String whereSql = " where r.isopen = 0 and r.user_id = " + sessionInfo.getId();
		//String whereHql = " where r.isopen = 0 and r.user.id = :userId";
		
		String sql = "select id,content,isopen,rdate,user_id from sms_remind r " + whereSql;
		//String hql = "select r from SmsRemind r" + whereHql;
		//params.put("userId", sessionInfo.getId());
		//List<SmsRemind> remindList = remindDao.find(hql, params);
		List<Object[]> remindList = remindDao.findBySql(sql);
		if(remindList != null && remindList.size() > 0){
			for(int i=0;i<remindList.size();i++){
				Remind remind = new Remind();
				Object[] obj = remindList.get(i);
				if(obj != null){
					remind.setId((Integer)obj[0]);
					remind.setContent((String)obj[1]);
					remind.setIsopen((Integer)obj[2]);
					remind.setRdate((Date)obj[3]);
					remind.setUserId(sessionInfo.getId());
				}
				rl.add(remind);
			}
		}
		String countSql = "select count(id) from sms_remind r "+whereSql;
		Long total = remindDao.countBySql(countSql).longValue();
		
		dg.setRows(rl);
		dg.setTotal(total);
		
		return dg;
	}
	
	public void closeRemind(Integer id){
		String sql = "update sms_remind set isopen = 1 where id = "+id;
		remindDao.executeSql(sql);
	}
	
	public void openRemind(Remind remind, HttpSession session){
		SessionInfo sessionInfo = (SessionInfo)session.getAttribute(ConfigUtil.getSessionInfoName());
		SmsUser user = userDao.get(SmsUser.class, sessionInfo.getId());
		
		SmsRemind r = new SmsRemind();
		r.setContent(remind.getContent());
		r.setIsopen(0);
		r.setRdate(remind.getRdate());
		r.setUser(user);
		
		remindDao.save(r);
	}
}
