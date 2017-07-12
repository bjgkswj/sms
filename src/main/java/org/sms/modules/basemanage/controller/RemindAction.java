package org.sms.modules.basemanage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.sms.core.DataGrid;
import org.sms.core.Json;
import org.sms.core.PagerHelper;
import org.sms.modules.basemanage.modelPage.Remind;
import org.sms.modules.basemanage.service.RemindServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class RemindAction implements ModelDriven<Remind>{
	@Autowired
	private RemindServiceI remindService;
	
	private PagerHelper ph;
	private int id;
	private Remind remind;
	public PagerHelper getPh() {
		return ph;
	}
	public void setPh(PagerHelper ph) {
		this.ph = ph;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void dataGrid(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		DataGrid dg = remindService.dataGrid(ph, session);
		try {
			PrintWriter out = response.getWriter();
			//out.write(JSON.toJSONString(dg));
			out.write(JSON.toJSONStringWithDateFormat(dg, "yyyy-MM-dd"));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		Json json = new Json();
		try {
			remindService.closeRemind(remind.getId());
			json.setMsg("已成功关闭该提醒消息!");
			json.setSuccess(true);
			PrintWriter out = response.getWriter();
			out.write(JSON.toJSONString(json));
			out.flush();
		} catch (Exception e) {
			json.setSuccess(false);
			e.printStackTrace();
		}
	}
	
	public void open(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		Json json = new Json();
		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			remindService.openRemind(remind, session);
			json.setMsg("已成功关闭该提醒消息!");
			json.setSuccess(true);
			PrintWriter out = response.getWriter();
			out.write(JSON.toJSONString(json));
			out.flush();
		} catch (Exception e) {
			json.setSuccess(false);
			e.printStackTrace();
		}
	}
	@Override
	public Remind getModel() {
		if(remind == null)
			remind = new Remind();
		return remind;
	}
}
