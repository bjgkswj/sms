package org.sms.modules.usermanage.controller;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.sms.core.BaseAction;
import org.sms.core.DataGrid;
import org.sms.core.Json;
import org.sms.core.SessionInfo;
import org.sms.modules.basemanage.model.SmsSchool;
import org.sms.modules.basemanage.service.SchoolServiceI;
import org.sms.modules.usermanage.modelPage.User;
import org.sms.modules.usermanage.service.UserServiceI;
import org.sms.util.ConfigUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
public class UserAction extends BaseAction implements ModelDriven<User>{
	@Autowired
	private SchoolServiceI schoolService;
	@Autowired
	private UserServiceI userService;
	private User user;
	
	/**
	 * 跳转至login.jsp
	 * @return
	 */
	public String goLogin(){
		List<SmsSchool> schoolList = schoolService.getShoolList();
		ActionContext.getContext().put("schoolList", schoolList);
		ActionContext.getContext().put("url", "login.jsp");
		return "redirect";
	}
	
	/**
	 * 登录
	 */
	public void login(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		Json j = new Json();
		User currentUser = userService.login(user);
		if(currentUser != null){
			SessionInfo sessionInfo = new SessionInfo();
			BeanUtils.copyProperties(currentUser, sessionInfo);
			ActionContext.getContext().getSession().put(ConfigUtil.getSessionInfoName(), sessionInfo);
			j.setSuccess(true);
			j.setMsg("登录成功！");
			j.setObj(sessionInfo);
			writeJson(j);
		}
	}
	
	/**
	 * 跳转至login.jsp
	 * @return
	 */
	public String goUser(){
		ActionContext.getContext().put("url", "admin/system/usermange/user.jsp");
		return "redirect";
	}
	
	/**
	 * 用户管理
	 */
	public void dataGrid(){
		DataGrid dg = userService.dataGrid(user);
		writeJson(dg);
	}
	
	/**
	 * 跳转至userAdd.jsp
	 * @return
	 */
	public String goAdd(){
		List<SmsSchool> schoolList = schoolService.getShoolList();
		ActionContext.getContext().put("schoolList", schoolList);
		ActionContext.getContext().put("url", "admin/system/usermange/userAdd.jsp");
		return "redirect";
	}
	
	/**
	 * 添加员工
	 */
	public void add(){
		Json j = new Json();
		try {			
			userService.add(user);
			j.setSuccess(true);
			j.setMsg("添加成功！");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("添加失败");
		}
		writeJson(j);
	}
	
	/**
	 * 跳转至userEdit.jsp
	 * @return
	 */
	public String goEdit(){
		List<SmsSchool> schoolList = schoolService.getShoolList();
		ActionContext.getContext().put("schoolList", schoolList);
		User u = userService.get(user.getId());
		ActionContext.getContext().put("user", u);
		ActionContext.getContext().put("url", "admin/system/usermange/userEdit.jsp");
		return "redirect";
	}
	
	/**
	 * 编辑员工
	 */
	public void edit(){
		Json j = new Json();
		try {
			userService.edit(user);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("编辑失败");
		}
		writeJson(j);
	}

	@Override
	public User getModel() {
		if(user == null)
			user = new User();
		return user;
	}
}
