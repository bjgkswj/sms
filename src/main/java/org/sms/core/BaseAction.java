package org.sms.core;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;

public class BaseAction {
	
	public void writeJson(Object obj){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.write(JSON.toJSONStringWithDateFormat(obj, "yyyy-MM-dd"));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
