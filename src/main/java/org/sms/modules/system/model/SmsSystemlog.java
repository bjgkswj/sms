package org.sms.modules.system.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="sms_systemlog")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SmsSystemlog implements Serializable{
	private int id;
	private String username;
	private String optime;
	private String message; 
	private String ipaddress;
	
	public SmsSystemlog() {}
	
	public SmsSystemlog(String username, String optime, String message,
			String ipaddress) {
		this.username = username;
		this.optime = optime;
		this.message = message;
		this.ipaddress = ipaddress;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOptime() {
		return optime;
	}
	public void setOptime(String optime) {
		this.optime = optime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
}
