package org.sms.modules.consultative.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.sms.modules.basemanage.model.SmsSchool;
import org.sms.modules.usermanage.model.SmsUser;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name="sms_record")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SmsRecord implements Serializable{
	private String id;
	private Date createDate;
	private int status;
	private int isdelete;
	private SmsUser user;
	private SmsSchool school;
	
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	public SmsUser getUser() {
		return user;
	}
	public void setUser(SmsUser user) {
		this.user = user;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="school_id")
	public SmsSchool getSchool() {
		return school;
	}
	public void setSchool(SmsSchool school) {
		this.school = school;
	}
}
