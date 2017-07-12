package org.sms.modules.basemanage.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.sms.modules.usermanage.model.SmsUser;

@Entity
@Table(name = "sms_remind")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SmsRemind implements Serializable  {
	private int id;
	private Date rdate;
	private String content;
	private int isopen;
	private SmsUser user;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "rdate", length = 19)
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	@Column(name="content",nullable=false,length=30)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIsopen() {
		return isopen;
	}
	public void setIsopen(int isopen) {
		this.isopen = isopen;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	public SmsUser getUser() {
		return user;
	}
	public void setUser(SmsUser user) {
		this.user = user;
	}
}
