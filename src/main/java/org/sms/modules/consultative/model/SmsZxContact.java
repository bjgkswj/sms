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

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.sms.modules.basemanage.model.SmsCSource;

@Entity
@Table(name = "sms_zxcontact")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SmsZxContact implements Serializable {
	private int id;
	private String name;
	private String sex;
	private String company;
	private String telephone;
	private String phone;
	private String email;
	private String email2;
	private String qq;
	private String fknow;
	private String gzinfo;
	private SmsCSource source;
	private SmsRecord record;
	private Date createDate;
	private int status;   //是否存在重复被咨询，标红
	private int isdelete;  //假删除之用
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getFknow() {
		return fknow;
	}
	public void setFknow(String fknow) {
		this.fknow = fknow;
	}
	public String getGzinfo() {
		return gzinfo;
	}
	public void setGzinfo(String gzinfo) {
		this.gzinfo = gzinfo;
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
	@JoinColumn(name="source_id",nullable=false)
	public SmsCSource getSource() {
		return source;
	}
	public void setSource(SmsCSource source) {
		this.source = source;
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
