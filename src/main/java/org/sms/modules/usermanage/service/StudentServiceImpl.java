package org.sms.modules.usermanage.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.sms.core.DataGrid;
import org.sms.core.PagerHelper;
import org.sms.core.SessionInfo;
import org.sms.modules.basemanage.dao.SchoolDaoI;
import org.sms.modules.basemanage.model.SmsSchool;
import org.sms.modules.usermanage.dao.StudentDaoI;
import org.sms.modules.usermanage.dao.UserDaoI;
import org.sms.modules.usermanage.model.SmsStudent;
import org.sms.modules.usermanage.model.SmsUser;
import org.sms.modules.usermanage.modelPage.Student;
import org.sms.util.ZmDateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentServiceI{
	@Autowired
	private StudentDaoI stuDao;
	@Autowired
	private SchoolDaoI schoolDao;
	@Autowired
	private UserDaoI userDao;

	@Override
	public DataGrid dataGrid(Student stu, SessionInfo sessionInfo) {
		int id = sessionInfo.getId();
		String roleId = sessionInfo.getRoleId();
		int userId = sessionInfo.getId();
		int schoolId = sessionInfo.getSchoolId();
		DataGrid dg = new DataGrid();
		List<Object[]> l = null;
		List<Student> sl = new ArrayList<Student>();
		Student s = null;
		String finalSql = "";
		String countSql = "";
		String sql = "select s.id sid,s.QQ,s.card,s.comAddr,s.company,s.email1,s.email2,s.name sname,s.phone1,s.phone2,s.sex ssex,s.signDate,s.tel stel,s.stuType,s.firstName,s.lastName,u.id,u.name,s.createDate ";
		String joinSql = " from sms_student s" +
				" left join sms_user u on s.user_id = u.id where s.isdelete = 0 ";
		String whereSql = " and s.user_id = "+userId ;
		String schoolSql = " and s.school_id = "+schoolId;
		if(id == 1){
			finalSql = sql + joinSql + whereSql(stu);
		}else if("jl".equals(roleId) || "bzr".equals(roleId)){
			finalSql = sql + joinSql + schoolSql + whereSql(stu);
		}else{
			finalSql = sql + joinSql + schoolSql + whereSql + whereSql(stu);
		}
		l = stuDao.findBySql(finalSql, stu.getPage(), stu.getRows());
		if(l != null && l.size() > 0){
			for(int i = 0;i<l.size();i++){
				s = new Student();
				Object[] obj = (Object[])l.get(i);
				
				s.setId((String)obj[0]);
				s.setQQ((String)obj[1]);
				s.setCard((String)obj[2]);
				s.setComAddr((String)obj[3]);
				s.setCompany((String)obj[4]);
				s.setEmail1((String)obj[5]);
				s.setEmail2((String)obj[6]);
				s.setName((String)obj[7]);
				s.setPhone1((String)obj[8]);
				s.setPhone2((String)obj[9]);
				s.setSex((String)obj[10]);
				s.setSignDate((Date)obj[11]);
				s.setTel((String)obj[12]);
				s.setStuType((Integer)obj[13]);
				s.setFirstName((String)obj[14]);
				s.setLastName((String)obj[15]);
				s.setUserId((Integer)obj[16]);
				s.setUserName((String)obj[17]);
				s.setCreateDate((Date)obj[18]);
				
				sl.add(s);
			}
		}
		String csql = "select count(s.id) ";
		if(id == 1){
			countSql = csql + joinSql;
		}else if("jl".equals(roleId) || "bzr".equals(roleId)){
			countSql = csql + joinSql + schoolSql;
		}else{
			countSql = csql + joinSql + schoolSql + whereSql;
		}
		Long total = stuDao.countBySql(countSql).longValue();
		
		dg.setRows(sl);
		dg.setTotal(total);
		
		return dg;
	}
	
	//查询条件
	private String whereSql(Student stu){
		String sql = "";
		if(stu != null){
			//根据关键字查询
			String key = stu.getName();
			if(key != null && !"".equals(key)){
				sql += " and (s.name like '%"+key+"%' or s.firstName like '%"+key+"%' or s.lastName like '%"+key+"%' or s.sex like '%"+key+"%' or s.company like '%"+key+"%' or s.tel like '%"+key+"%' or s.phone1 like '%"+key+"%' or s.phone2 like '%"+key+"%' or s.email1 like '%"+key+"%' or s.email2 like '%"+key+"%' or s.QQ like '%"+key+"%' or s.comAddr like '%"+key+"%' or s.card like '%"+key+"%')";
			}
			//根据学员类型查询
			if(stu.getStuType() != 0){
				sql += " and s.stuType = "+stu.getStuType();
			}
			//根据学员顾问
			if(stu.getUserId() != 0){
				sql += " and s.user_id = "+stu.getUserId();
			}
			//根据签约时间查询
			if(stu.getSignDateStart() != null){
				String signDateStart = ZmDateUtil.dateToStrLong_FormStr(stu.getSignDateStart(), "yyyy-MM-dd");
				sql += " and s.signDate >= '"+signDateStart+"'";
			}
			if(stu.getSignDateEnd() != null){
				String signDateEnd = ZmDateUtil.dateToStrLong_FormStr(stu.getSignDateEnd(), "yyyy-MM-dd");
				sql += " and s.signDate <= '"+signDateEnd+"'";
			}
		}
		return sql;
	}
	
	//排序
	private String orderSql(PagerHelper ph){
		String orderString = "";
		if(ph.getOrder() != null && ph.getSort() != null){
			orderString = "order by s."+ph.getSort()+" "+ph.getOrder();
		}
		return orderString;
	}

	@Override
	public void add(Student stu) {
		SmsStudent sstu = new SmsStudent();
		BeanUtils.copyProperties(stu, sstu);
		sstu.setSchool(schoolDao.get(SmsSchool.class, stu.getSchoolId()));
		sstu.setUser(userDao.get(SmsUser.class, stu.getUserId()));
		stuDao.save(sstu);
	}

	@Override
	public String getStuNo() {
		String sql = "select max(sid) from sms_student";
		String shortStuNo = "";
		List<Object[]> l = stuDao.findBySql(sql);
		if(l != null && l.size() > 0){
			for(int i=0;i<l.size();i++){
				shortStuNo = String.valueOf(l.get(i));
			}
		}
		return shortStuNo;
	}

	@Override
	public void edit(Student stu) {
		SmsStudent sstu = stuDao.get(SmsStudent.class, stu.getId());
		BeanUtils.copyProperties(stu, sstu);
		sstu.setSchool(schoolDao.get(SmsSchool.class, stu.getSchoolId()));
		sstu.setUser(userDao.get(SmsUser.class, stu.getUserId()));
		stuDao.update(sstu);
	}

	@Override
	public SmsStudent get(String id) {
		SmsStudent stu = stuDao.get(SmsStudent.class, id);
		return stu;
	}
	
	public void delete(String id){
		String sql = "update sms_student set isdelete = 1 where id = '"+id+"'";
		stuDao.executeSql(sql);
	}

}
