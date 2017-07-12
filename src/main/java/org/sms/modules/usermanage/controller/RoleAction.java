package org.sms.modules.usermanage.controller;

import java.util.List;

import org.sms.core.BaseAction;
import org.sms.core.Json;
import org.sms.core.Tree;
import org.sms.modules.usermanage.modelPage.Role;
import org.sms.modules.usermanage.service.RoleServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class RoleAction extends BaseAction implements ModelDriven<Role>{
	@Autowired
	private RoleServiceI roleService;
	
	private Role role;
	
	/**
	 * 跳转至role.jsp
	 * @return
	 */
	public String goRole(){
		ActionContext.getContext().put("url", "admin/system/usermange/role.jsp");
		return "redirect";
	}
	
	/**
	 * 角色列表管理
	 */
	public void treeGrid(){
		List<Role> roles = roleService.treeGrid();
		writeJson(roles);
	}
	
	
	/**
	 * 上级角色
	 */
	public void tree(){
		List<Tree> treeRoles = roleService.tree();
		writeJson(treeRoles);
	}
	
	/**
	 * 跳转至roleAdd.jsp
	 * @return
	 */
	public String goRoleAdd(){
		ActionContext.getContext().put("url", "admin/system/usermange/roleAdd.jsp");
		return "redirect";
	}
	
	/**
	 * 保存新增角色
	 */
	public void add(){
		Json j = new Json();
		roleService.add(role);
		j.setMsg("保存成功");
		j.setSuccess(true);
		writeJson(j);
	}
	
	/**
	 * 跳转至roleEdit.jsp
	 * @return
	 */
	public String goRoleEdit(){
		Role t = roleService.get(role.getId());
		ActionContext.getContext().put("role", t);
		ActionContext.getContext().put("url", "admin/system/usermange/roleEdit.jsp");
		return "redirect";
	}
	
	/**
	 * 保存新增角色
	 */
	public void edit(){
		Json j = new Json();
		roleService.edit(role);
		j.setMsg("修改成功");
		j.setSuccess(true);
		writeJson(j);
	}
	
	/**
	 * 跳转至roleGrant.jsp
	 * @return
	 */
	public String goRoleGrant(){
		Role t = roleService.get(role.getId());
		ActionContext.getContext().put("role", t);
		ActionContext.getContext().put("url", "admin/system/usermange/roleGrant.jsp");
		return "redirect";
	}
	
	/**
	 * 角色授权
	 */
	public void grant(){
		Json j = new Json();
		roleService.grant(role);
		j.setMsg("授权成功");
		j.setSuccess(true);
		writeJson(j);
	}
	
	/**
	 * 角色授权
	 */
	public void delete(){
		Json j = new Json();
		roleService.delete(role.getId());
		j.setMsg("撤销成功");
		j.setSuccess(true);
		writeJson(j);
	}

	@Override
	public Role getModel() {
		if(role == null)
			role = new Role();
		return role;
	}
}
