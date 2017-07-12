package org.sms.modules.usermanage.service;

import java.util.List;

import org.sms.core.Tree;
import org.sms.modules.usermanage.modelPage.Role;

public interface RoleServiceI {
	public List<Role> treeGrid();
	public List<Tree> tree();
	
	public void add(Role role);
	public void edit(Role role);
	public Role get(String id);
	public void delete(String id);
	
	public void grant(Role role);
}
