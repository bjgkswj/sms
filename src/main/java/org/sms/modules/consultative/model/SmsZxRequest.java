package org.sms.modules.consultative.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.sms.modules.basemanage.model.SmsCompany;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="sms_zxrequest")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SmsZxRequest implements Serializable {
	private int id;
	private Date contacttime;   //下次联系时间
	private SmsCompany company;
	private SmsRecord record;
	private String cusreq;
	private int isopen;   //是否已关闭（用于首页显示）
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getContacttime() {
		return contacttime;
	}
	public void setContacttime(Date contacttime) {
		this.contacttime = contacttime;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="company_id")
	public SmsCompany getCompany() {
		return company;
	}

	public void setCompany(SmsCompany company) {
		this.company = company;
	}

	public String getCusreq() {
		return cusreq;
	}

	public void setCusreq(String cusreq) {
		this.cusreq = cusreq;
	}
	
	public int getIsopen() {
		return isopen;
	}
	public void setIsopen(int isopen) {
		this.isopen = isopen;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="record_id",nullable=false)
	public SmsRecord getRecord() {
		return record;
	}
	public void setRecord(SmsRecord record) {
		this.record = record;
	}
}
