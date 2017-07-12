package org.sms.modules.usermanage.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.sms.core.Tree;
import org.sms.modules.usermanage.dao.ResourceDaoI;
import org.sms.modules.usermanage.dao.RoleDaoI;
import org.sms.modules.usermanage.model.SmsResource;
import org.sms.modules.usermanage.model.SmsRole;
import org.sms.modules.usermanage.modelPage.Role;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleServiceI{
	@Autowired
	private RoleDaoI roleDao;
	
	@Autowired
	private ResourceDaoI resourceDao;

	@Override
	public List<Role> treeGrid() {
		List<Role> rl = new ArrayList<Role>();
		String hql = "select distinct t from SmsRole t left join fetch t.tresources resource order by t.seq";
		List<SmsRole> tl = roleDao.find(hql);
		if(tl != null && tl.size() > 0){
			for(SmsRole t : tl){
				Role r = new Role();
				BeanUtils.copyProperties(t, r);
				r.setIconCls("status_online");
				if(t.getTrole() != null){
					r.setPid(t.getTrole().getId());
					r.setPname(t.getTrole().getName());
				}
				//处理拥有资源
				Set<SmsResource> s = t.getTresources();
				if(s != null && !s.isEmpty()){
					boolean b = false;
					String ids = "";
					String names = "";
					for(SmsResource tr : s){
						if(b){
							ids += ",";
							names += ",";
						}else{
							b = true;
						}
						ids += tr.getId();
						names += tr.getName();
					}
					r.setResourceIds(ids);
					r.setResourceNames(names);
				}
				rl.add(r);  //添加到集合中
			}
		}
		return rl;
	}

	@Override
	public List<Tree> tree() {
		String hql = "from SmsRole t order by t.seq";
		List<SmsRole> l = roleDao.find(hql);
		List<Tree> lt = new ArrayList<Tree>();
		if(l != null && l.size() > 0){
			for(SmsRole t : l){
				Tree tree = new Tree();
				BeanUtils.copyProperties(t, tree);
				tree.setText(t.getName());
				tree.setIconCls("status_online");
				if(t.getTrole() != null){
					tree.setPid(t.getTrole().getId());
				}
				lt.add(tree);
			}
		}
		return lt;
	}

	@Override
	public void add(Role role) {
		SmsRole t = new SmsRole();
		BeanUtils.copyProperties(role, t);
		if(role.getPid() != null && !"".equals(role.getPid())){
			t.setTrole(roleDao.get(SmsRole.class,role.getPid()));
		}
		roleDao.save(t);
	}

	@Override
	public void edit(Role role) {
		SmsRole t = roleDao.get(SmsRole.class,role.getId());
		if(t != null){
			BeanUtils.copyProperties(role, t);
			if(role.getPid() != null && !"".equals(role.getPid())){
				t.setTrole(roleDao.get(SmsRole.class,role.getPid()));
			}
		}
	}

	@Override
	public Role get(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = "select distinct t from SmsRole t left join fetch t.tresources resource where t.id = :id order by t.seq";
		params.put("id", id);
		SmsRole t = roleDao.get(hql,params);
		Role r = new Role();
		if(t != null){
			BeanUtils.copyProperties(t, r);
			if(t.getTrole() != null){
				r.setPid(t.getTrole().getId());
				r.setPname(t.getTrole().getName());
			}
			//处理拥有资源
			Set<SmsResource> s = t.getTresources();
			if(s != null && !s.isEmpty()){
				boolean b = false;
				String ids = "";
				String names = "";
				for(SmsResource tr : s){
					if(b){
						ids += ",";
						names += ",";
					}else{
						b = true;
					}
					ids += tr.getId();
					names += tr.getName();
				}
				r.setResourceIds(ids);
				r.setResourceNames(names);
			}
		}
		return r;
	}

	@Override
	public void grant(Role role) {
		SmsRole t = roleDao.get(SmsRole.class, role.getId());
		if(role.getResourceIds() != null && !"".equals(role.getResourceIds())){
			boolean b = false;
			String ids = "";
			for(String id : role.getResourceIds().split(",")){
				if(b){
					ids += ",";
				}else{
					b = true;
				}
				ids += "'" + id + "'" ;
			}
			t.setTresources(new HashSet<SmsResource>(resourceDao.find("select distinct t from SmsResource t where t.id in ("+ids+")")));
		}else{
			t.setTresources(null);
		}
	}

	@Override
	public void delete(String id) {
		roleDao.delete(roleDao.get(SmsRole.class, id));
	}

}
