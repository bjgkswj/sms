package org.sms.modules.usermanage.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.sms.core.SessionInfo;
import org.sms.core.Tree;
import org.sms.modules.usermanage.dao.ResourceDaoI;
import org.sms.modules.usermanage.dao.ResourceTypeDaoI;
import org.sms.modules.usermanage.dao.UserDaoI;
import org.sms.modules.usermanage.model.SmsResource;
import org.sms.modules.usermanage.model.SmsResourceType;
import org.sms.modules.usermanage.model.SmsRole;
import org.sms.modules.usermanage.model.SmsUser;
import org.sms.modules.usermanage.modelPage.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceServiceI{
	@Autowired
	private ResourceDaoI resourceDao;
	@Autowired
	private ResourceTypeDaoI resourceTypeDao;
	@Autowired
	private UserDaoI userDao;

	@Override
	public List<Tree> tree(SessionInfo sessionInfo) {
		List<Tree> treeList = new ArrayList<Tree>();
		List<SmsResource> resourceList = null;
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = "";
		params.put("typeId", "0");
		if(sessionInfo != null){
			hql = "select distinct r from SmsResource r join fetch r.tresourcetype type join fetch r.troles role join fetch role.tusers user where type.id = :typeId and user.id = :userId order by r.seq";
			params.put("userId", sessionInfo.getId());
		}else{
			hql = "select distinct r from SmsResource r join fetch r.tresourcetype type where type.id = :typeId order by r.seq";
		}
		resourceList = resourceDao.find(hql, params);
		if(resourceList != null && resourceList.size() > 0){
			for(SmsResource resource : resourceList){
				Tree tree = new Tree();
				BeanUtils.copyProperties(resource, tree);
				if(resource.getTresource() != null){
					tree.setPid(resource.getTresource().getId());
				}
				tree.setText(resource.getName());
				tree.setIconCls(resource.getIcon());
				Map<String, Object> attrs = new HashMap<String, Object>();
				attrs.put("url", resource.getUrl());
				tree.setAttributes(attrs);
				treeList.add(tree);
			}
		}
		return treeList;
	}
	
	@Override
	public List<Tree> allTree(SessionInfo sessionInfo) {
		List<Tree> treeList = new ArrayList<Tree>();
		List<SmsResource> resourceList = null;
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = "";
		if(sessionInfo != null){
			params.put("userId", sessionInfo.getId());
			hql = "select distinct r from SmsResource r join fetch r.tresourcetype type join fetch r.troles role join fetch role.tusers user where user.id = :userId order by r.seq";
		}else{
			hql = "select distinct r from SmsResource r join fetch r.tresourcetype type where order by r.seq";
		}
		resourceList = resourceDao.find(hql, params);
		if(resourceList != null && resourceList.size() > 0){
			for(SmsResource resource : resourceList){
				Tree tree = new Tree();
				BeanUtils.copyProperties(resource, tree);
				if(resource.getTresource() != null){
					tree.setPid(resource.getTresource().getId());
				}
				tree.setText(resource.getName());
				tree.setIconCls(resource.getIcon());
				Map<String, Object> attrs = new HashMap<String, Object>();
				attrs.put("url", resource.getUrl());
				tree.setAttributes(attrs);
				treeList.add(tree);
			}
		}
		return treeList;
	}

	@Override
	public List<Resource> treegrid(SessionInfo sessionInfo) {
		List<Resource> rList = new ArrayList<Resource>();
		List<SmsResource> resourceList = null;
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = "";
		if(sessionInfo != null){
			hql = "select distinct r from SmsResource r join fetch r.tresourcetype type join fetch r.troles role join fetch role.tusers user where user.id = :userId order by r.seq";
			params.put("userId", sessionInfo.getId());
		}else{
			hql = "select distinct r from SmsResource r join fetch r.tresourcetype type order by r.seq";
		}
		resourceList = resourceDao.find(hql, params);
		if(resourceList != null && resourceList.size() > 0){
			for(SmsResource resource : resourceList){
				Resource r = new Resource();
				BeanUtils.copyProperties(resource, r);
				if(resource.getTresource() != null){
					r.setPid(resource.getTresource().getId());
					r.setPname(resource.getTresource().getName());
				}
				r.setTypeId(resource.getTresourcetype().getId());
				r.setTypeName(resource.getTresourcetype().getName());
				if(resource.getIcon() != null && !"".equals(resource.getIcon())){
					r.setIconCls(resource.getIcon());
				}
				rList.add(r);
			}
		}
		return rList;
	}

	@Override
	public void add(Resource res, SessionInfo sessionInfo) {
		SmsResource sres = new SmsResource();
		BeanUtils.copyProperties(res, sres);
		if(res.getPid() != null && !"".equalsIgnoreCase(res.getPid())){
			sres.setTresource(resourceDao.get(SmsResource.class, res.getPid()));
		}
		if(res.getTypeId() != null && !"".equalsIgnoreCase(res.getTypeId())){
			sres.setTresourcetype(resourceTypeDao.get(SmsResourceType.class, res.getTypeId()));
		}
		if(res.getIconCls() != null && !"".equalsIgnoreCase(res.getIconCls())){
			sres.setIcon(res.getIconCls());
		}
		resourceDao.save(sres);
		//新增资源时默认当前用户无法访问，所以讲新增的资源添加到当前用户的所有角色中，sms_role_resource
		SmsUser suser = userDao.get(SmsUser.class, sessionInfo.getId());
		Set<SmsRole> sroles = suser.getTroles();
		for(SmsRole r : sroles){
			r.getTresources().add(sres);
		}
	}
	
	@Override
	public Resource get(String id){
		Map<String, Object> params = new HashMap<String,Object>();
		Resource res = new Resource();
		params.put("id", id);
		String hql = "from SmsResource where id = :id";
		SmsResource sres = resourceDao.get(hql, params);
		BeanUtils.copyProperties(sres, res);
		if(sres.getTresource() != null){
			res.setPid(sres.getTresource().getId());
			res.setPname(sres.getTresource().getName());
		}
		res.setTypeId(sres.getTresourcetype().getId());
		res.setTypeName(sres.getTresourcetype().getName());
		if(sres.getIcon() != null && !"".equals(sres.getIcon())){
			res.setIconCls(sres.getIcon());
		}
		return res;
	}

	@Override
	public void edit(Resource res) {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("id", res.getId());
		String hql = "from SmsResource where id = :id";
		SmsResource sres = resourceDao.get(hql, params);
		if(sres != null){
			BeanUtils.copyProperties(res, sres);
			if(res.getPid() != null && !"".equalsIgnoreCase(res.getPid())){
				sres.setTresource(resourceDao.get(SmsResource.class, res.getPid()));
			}else{
				sres.setTresource(null);
			}
			if(res.getTypeId() != null && !"".equalsIgnoreCase(res.getTypeId())){
				sres.setTresourcetype(resourceTypeDao.get(SmsResourceType.class, res.getTypeId()));
			}
			if(res.getIconCls() != null && !"".equalsIgnoreCase(res.getIconCls())){
				sres.setIcon(res.getIconCls());
			}
		}
	}
	
	@Override
	public void delete(String id){
		SmsResource sres = resourceDao.get(SmsResource.class, id);
		del(sres);
	}
	
	private void del(SmsResource sres){
		if(sres.getTresources() != null && sres.getTresources().size() > 0){
			del(sres);
		}
		resourceDao.delete(sres);
	}
}
