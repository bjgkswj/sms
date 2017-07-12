package org.sms.modules.usermanage.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.sms.core.DataGrid;
import org.sms.core.SessionInfo;
import org.sms.modules.basemanage.dao.SchoolDaoI;
import org.sms.modules.basemanage.model.SmsSchool;
import org.sms.modules.usermanage.dao.UserDaoI;
import org.sms.modules.usermanage.model.SmsRole;
import org.sms.modules.usermanage.model.SmsUser;
import org.sms.modules.usermanage.modelPage.User;
import org.sms.util.MD5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceI{
	@Autowired
	private UserDaoI userDao;
	@Autowired
	private SchoolDaoI schoolDao;
	

	@Override
	public User login(User user) {
		String hql = "from SmsUser t left join fetch t.school school where t.username = :username and t.password = :password and t.school.id = :schoolId ";
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("username", user.getUsername());
		params.put("password", MD5Util.md5(user.getPassword()));   //MD5加密
		params.put("schoolId", user.getSchoolId());
		SmsUser suser = userDao.get(hql, params);
		if(suser != null){
			BeanUtils.copyProperties(suser, user);
			user.setSchoolId(suser.getSchool().getId());
			user.setSchoolName(suser.getSchool().getSchoolname());
			return user;
		}
		return null;
	}
	
	@Override
	public List<User> getXygwList(SessionInfo sessionInfo){
		List<User> userList = new ArrayList<User>();
		Map<String, Object> params = new HashMap<String, Object>();
		int id = sessionInfo.getId();
		int schoolId = sessionInfo.getSchoolId();
		String hql = "from SmsUser t join fetch t.troles role";
		String whereSql = "";
		if(id == 1){
			whereSql = "";
		}else{
			whereSql = " where t.school.id = :schoolId";
			params.put("schoolId", schoolId);
		}
		List<SmsUser> users = userDao.find(hql + whereSql,params);
		//去重
		if(users != null && users.size() > 0){
			for(int i = 0;i<users.size();i++){
				for(int j = users.size()-1;j>i;j--){
					if(users.get(i).getUsername().equals(users.get(j).getUsername())){
						users.remove(j);
					}
				}
			}
			for(SmsUser user : users){
				Set<SmsRole> roles = user.getTroles();
				for(SmsRole role : roles){
					if("xygw".equalsIgnoreCase(role.getId())){
						User u = new User();
						BeanUtils.copyProperties(user, u);
						userList.add(u);
					}
				}
			}
		}
		return userList;
	}

	@Override
	public DataGrid dataGrid(User user) {
		DataGrid dg = new DataGrid();
		List<User> ul = new ArrayList<User>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = "from SmsUser t left join fetch t.school school ";
		List<SmsUser> l = userDao.find(hql + whereHql(user,params) + orderHql(user),params,user.getPage(),user.getRows());
		if(l != null && l.size() > 0){
			for(SmsUser t : l){
				User u = new User();
				BeanUtils.copyProperties(t, u);
				u.setSchoolId(t.getSchool().getId());
				u.setSchoolName(t.getSchool().getSchoolname());
				Set<SmsRole> roles = t.getTroles();
				if(roles != null && !roles.isEmpty()){
					String roleIds = "";
					String roleNames = "";
					boolean b = false;
					for(SmsRole tr : roles){
						if(b){
							roleIds += ",";
							roleNames += ",";
						}else{
							b = true;
						}
						roleIds += tr.getId();
						roleNames += tr.getName();
					}
					u.setRoleIds(roleIds);
					u.setRoleNames(roleNames);
					
					ul.add(u);
				}
			}
		}
		dg.setRows(ul);
		dg.setTotal(userDao.count("select count(*) from SmsUser t left join t.school school" + whereHql(user, params), params));
		return dg;
	}
	
	@Override
	public void add(User user) throws Exception{
		//验证（登录名是否存在）
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("username", user.getUsername());
		String hql = "select count(*) from SmsUser t where t.username = :username";
		Long userCount = userDao.count(hql, params);
		if(userCount > 0){
			throw new Exception("登录名已存在");
		}else{
			SmsUser u = new SmsUser();
			BeanUtils.copyProperties(user, u);
			u.setSchool(schoolDao.get(SmsSchool.class, user.getSchoolId()));
			u.setPassword(MD5Util.md5(user.getPassword()));  //加密后存入数据库
			u.setCreatedatetime(new Date());
			userDao.save(u);
		}
	}
	
	@Override
	public void edit(User user){
		SmsUser u = userDao.get(SmsUser.class, user.getId());
		BeanUtils.copyProperties(user, u);
		u.setSchool(schoolDao.get(SmsSchool.class, user.getSchoolId()));
		String newPwd = user.getPassword();
		String oldPwd = u.getPassword();
		if(newPwd.equals(oldPwd)){
			u.setPassword(oldPwd);
		}else{
			u.setPassword(MD5Util.md5(newPwd));  //加密后存入数据库
		}
		u.setModifydatetime(new Date());
	}
	
	@Override
	public User get(int id){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		SmsUser t = userDao.get("select distinct t from SmsUser t left join fetch t.troles role left join fetch t.school school where t.id = :id", params);
		User user = new User();
		BeanUtils.copyProperties(t, user);
		user.setSchoolId(t.getSchool().getId());
		user.setSchoolName(t.getSchool().getSchoolname());
		Set<SmsRole> roles = t.getTroles();
		if(roles != null && !roles.isEmpty()){
			String roleIds = "";
			String roleNames = "";
			boolean b = false;
			for(SmsRole tr : roles){
				if(b){
					roleIds += ",";
					roleNames += ",";
				}else{
					b = true;
				}
				roleIds += tr.getId();
				roleNames += tr.getName();
			}
			user.setRoleIds(roleIds);
			user.setRoleNames(roleNames);
		}
		return user;
	}
	
	// 查询条件
	private String whereHql(User user,Map<String, Object> params) {
		String hql = "";
		if (user != null) {
			hql += " where 1=1 ";
			// 根据登录名查询
			if (user.getUsername() != null && !"".equals(user.getUsername())) {
				hql += " and t.username like :username ";
				params.put("username", "%%" + user.getUsername() + "%%");
			}
			// 根据用户所属的校区查询
			if (user.getSchoolId() != 0) {
				hql += " and t.school.id = :schoolId ";
				params.put("schoolId", user.getSchoolId());
			}
			// 根据创建时间查询
			if (user.getCreatedateStart() != null) {
				hql += " and t.createdatetime >= :createdateStart ";
				params.put("createdateStart", user.getCreatedateStart());
			}
			if (user.getCreatedateEnd() != null) {
				hql += " and t.createdatetime <= :createdateEnd ";
				params.put("createdateEnd", user.getCreatedateEnd());
			}
			// 根据创建时间查询
			if (user.getModifydateStart() != null) {
				hql += " and t.modifydatetime >= :modifydateStart ";
				params.put("modifydateStart", user.getModifydateStart());
			}
			if (user.getModifydateEnd() != null) {
				hql += " and t.modifydatetime <= :modifydateEnd ";
				params.put("modifydateEnd", user.getModifydateEnd());
			}
		}
		return hql;
	}

	// 排序
	private String orderHql(User user) {
		String orderString = "";
		if (user.getOrder() != null && user.getSort() != null) {
			orderString = " order by t." + user.getSort() + " " + user.getOrder();
		}
		return orderString;
	}	
}
