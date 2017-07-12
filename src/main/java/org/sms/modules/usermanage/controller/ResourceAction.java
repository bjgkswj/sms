package org.sms.modules.usermanage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.sms.core.BaseAction;
import org.sms.core.Json;
import org.sms.core.SessionInfo;
import org.sms.core.Tree;
import org.sms.modules.usermanage.modelPage.Resource;
import org.sms.modules.usermanage.modelPage.ResourceType;
import org.sms.modules.usermanage.service.ResourceServiceI;
import org.sms.modules.usermanage.service.ResourceTypeServiceI;
import org.sms.util.ConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller("resourceAction")
public class ResourceAction extends BaseAction implements ModelDriven<Resource> {
	@Autowired
	private ResourceServiceI resourceService;
	@Autowired
	private ResourceTypeServiceI resourceTypeService;
	
	private Resource resource;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 首页左侧菜单
	 */
	public void tree(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		SessionInfo sessionInfo = (SessionInfo)ActionContext.getContext().getSession().get(ConfigUtil.getSessionInfoName());
		List<Tree> treeList = resourceService.tree(sessionInfo);
		try {
			PrintWriter out = response.getWriter();
			out.write(JSON.toJSONString(treeList));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 首页左侧菜单
	 */
	public void allTree(){
		SessionInfo sessionInfo = (SessionInfo)ActionContext.getContext().getSession().get(ConfigUtil.getSessionInfoName());
		List<Tree> treeList = resourceService.allTree(sessionInfo);
		writeJson(treeList);
	}
	
	/**
	 * 跳转至resource.jsp
	 * @return
	 */
	public String goRes(){
		ActionContext.getContext().put("url", "admin/system/usermange/resource.jsp");
		return "redirect";
	}
	
	/**
	 * 资源管理列表
	 */
	public void treegrid(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		SessionInfo sessionInfo = (SessionInfo)ActionContext.getContext().getSession().get(ConfigUtil.getSessionInfoName());
		List<Resource> treeList = resourceService.treegrid(sessionInfo);
		writeJson(treeList);
	}
	
	/**
	 * 跳转至resourceAdd.jsp
	 * @return
	 */
	public String goResAdd(){
		List<ResourceType> resourceTypeList = resourceTypeService.getResourceTypeList();
		ActionContext.getContext().put("resourceTypeList", resourceTypeList);
		ActionContext.getContext().put("url", "admin/system/usermange/resourceAdd.jsp");
		return "redirect";
	}
	
	/**
	 * 新增资源
	 */
	public void add(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		SessionInfo sessionInfo = (SessionInfo)ActionContext.getContext().getSession().get(ConfigUtil.getSessionInfoName());
		resourceService.add(resource, sessionInfo);
		Json json = new Json();
		try {
			PrintWriter out = response.getWriter();
			json.setMsg("新增成功");
			json.setSuccess(true);
			out.write(JSON.toJSONString(json));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转至resourceEdit.jsp
	 * @return
	 */
	public String goResEdit(){
		List<ResourceType> resourceTypeList = resourceTypeService.getResourceTypeList();
		ActionContext.getContext().put("resourceTypeList", resourceTypeList);
		Resource res = resourceService.get(resource.getId());
		ActionContext.getContext().put("res", res);
		ActionContext.getContext().put("url", "admin/system/usermange/resourceEdit.jsp");
		return "redirect";
	}
	
	/**
	 * 编辑资源
	 */
	public void edit(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		resourceService.edit(resource);
		Json json = new Json();
		try {
			PrintWriter out = response.getWriter();
			json.setMsg("修改成功");
			json.setSuccess(true);
			out.write(JSON.toJSONString(json));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除资源
	 */
	public void del(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		resourceService.delete(resource.getId());
		Json json = new Json();
		try {
			PrintWriter out = response.getWriter();
			json.setMsg("删除成功");
			json.setSuccess(true);
			out.write(JSON.toJSONString(json));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Resource getModel() {
		if(resource == null)
			resource = new Resource();
		return resource;
	}
}
