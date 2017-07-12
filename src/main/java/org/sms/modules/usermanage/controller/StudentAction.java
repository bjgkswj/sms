package org.sms.modules.usermanage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.sms.core.BaseAction;
import org.sms.core.DataGrid;
import org.sms.core.Json;
import org.sms.core.SessionInfo;
import org.sms.modules.usermanage.model.SmsStudent;
import org.sms.modules.usermanage.modelPage.Student;
import org.sms.modules.usermanage.modelPage.User;
import org.sms.modules.usermanage.service.StudentServiceI;
import org.sms.modules.usermanage.service.UserServiceI;
import org.sms.util.ConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class StudentAction extends BaseAction implements ModelDriven<Student>{
	@Autowired
	private StudentServiceI stuService;
	@Autowired
	private UserServiceI userService;
	private Student stu;
	
	/**
	 * 跳转至stu.jsp
	 * @return
	 */
	public String goStu(){
		SessionInfo sessionInfo = (SessionInfo)ActionContext.getContext().getSession().get(ConfigUtil.getSessionInfoName());
		List<User> users = userService.getXygwList(sessionInfo);   //学员顾问
		ActionContext.getContext().put("users", users);
		ActionContext.getContext().put("url", "admin/system/usermange/stu.jsp");
		return "redirect";
	}
	
	/**
	 * 学员列表
	 */
	public void datagrid(){
		SessionInfo sessionInfo = (SessionInfo)ActionContext.getContext().getSession().get(ConfigUtil.getSessionInfoName());
		DataGrid dg = stuService.dataGrid(stu, sessionInfo);
		writeJson(dg);
	}
	
	/**
	 * 跳转至stuAdd.jsp
	 * @return
	 */
	public String goStuAdd(){
		ActionContext.getContext().put("url", "admin/system/usermange/stuAdd.jsp");
		SessionInfo sessionInfo = (SessionInfo)ActionContext.getContext().getSession().get(ConfigUtil.getSessionInfoName());
		ActionContext.getContext().put("slId", sessionInfo.getSchoolId());
		List<User> users = userService.getXygwList(sessionInfo);   //学员顾问
		ActionContext.getContext().put("users", users);
		return "redirect";
	}
	
	/**
	 * 注册学籍
	 */
	public void add(){
		Json j = new Json();
		//获取当前日期格式(1507)
		SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
		//得到当前时间
		String now = sdf.format(new Date());
		//得到最后编号
		String shortStuNo = stuService.getStuNo();
		String stuNo = "ZM" + now + shortStuNo;
		stu.setId(stuNo);
		stu.setCreateDate(new Date());
		stuService.add(stu);
		
		j.setMsg("成功注册！");
		j.setSuccess(true);
		writeJson(j);
	}
	
	/**
	 * 跳转至stuEdit.jsp
	 * @return
	 */
	public String goStuEdit(){
		ActionContext.getContext().put("url", "admin/system/usermange/stuEdit.jsp");
		SessionInfo sessionInfo = (SessionInfo)ActionContext.getContext().getSession().get(ConfigUtil.getSessionInfoName());
		SmsStudent sstu = stuService.get(stu.getId());
		List<User> users = userService.getXygwList(sessionInfo);   //学员顾问
		ActionContext.getContext().put("users", users);
		ActionContext.getContext().put("sstu", sstu);
		return "redirect";
	}
	
	/**
	 * 资料变更
	 */
	public void edit(){
		Json j = new Json();
		stu.setCreateDate(new Date());
		stuService.edit(stu);
		j.setMsg("修改成功！");
		j.setSuccess(true);
		writeJson(j);
	}
	
	/**
	 * 注销学员
	 */
	public void delete(){
		Json j = new Json();
		String id = stu.getId();
		if(id != null && !"".equals(id)){
			String[] ids = id.split(",");
			for(String d : ids){
				stuService.delete(d);
			}
		}		
		j.setMsg("注销成功！");
		j.setSuccess(true);
		writeJson(j);
	}

	@Override
	public Student getModel() {
		if(stu == null)
			stu = new Student();
		return stu;
	}
}
