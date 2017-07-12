package org.sms.modules.usermanage.service;

import java.util.List;

import org.sms.core.SessionInfo;
import org.sms.core.Tree;
import org.sms.modules.usermanage.modelPage.Resource;

public interface ResourceServiceI {
	public List<Tree> tree(SessionInfo sessionInfo);
	public List<Tree> allTree(SessionInfo sessionInfo);
	
	public List<Resource> treegrid(SessionInfo sessionInfo);
	
	public void add(Resource res,SessionInfo sessionInfo);
	
	public Resource get(String id);
	
	public void edit(Resource res);
	
	public void delete(String id);
}
