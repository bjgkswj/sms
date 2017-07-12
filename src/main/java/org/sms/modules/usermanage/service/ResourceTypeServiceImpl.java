package org.sms.modules.usermanage.service;

import java.util.ArrayList;
import java.util.List;

import org.sms.modules.usermanage.dao.ResourceTypeDaoI;
import org.sms.modules.usermanage.model.SmsResourceType;
import org.sms.modules.usermanage.modelPage.ResourceType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceTypeServiceImpl implements ResourceTypeServiceI{
	@Autowired
	private ResourceTypeDaoI resourceTypeDao;

	@Override
	public List<ResourceType> getResourceTypeList() {
		List<ResourceType> rl = new ArrayList<ResourceType>();
		String hql = "from SmsResourceType";
		List<SmsResourceType> srl = resourceTypeDao.find(hql);
		if(srl != null && srl.size() > 0){
			for(SmsResourceType r : srl){
				ResourceType rt = new ResourceType();
				BeanUtils.copyProperties(r, rt);
				rl.add(rt);
			}
		}
		return rl;
	}

}
