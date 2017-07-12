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

import org.sms.modules.basemanage.model.SmsSchool;
import org.sms.modules.usermanage.model.SmsUser;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="sms_record_history")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SmsRecordHistory implements Serializable {
	private int id;
	private Date recordDate;   //咨询日期
	private String name;   //姓名
	private String company;   //单位名称
	private String telephone;   //固定电话
	private String phone;   //手机
	private String email;   //邮箱
	private String qq;   //QQ
	private String comp;   //厂商
	private String cusreq;   //咨询需求	
	private String gzinfo;   //跟踪信息
	private String zxtype;  //咨询方式
	private int status;   //咨询状态
	private String fknow;   //来源	
	private String remark;   //备注
	private SmsUser user;
	private SmsSchool school;
	
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
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		this.comp = comp;
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
	public String getZxtype() {
		return zxtype;
	}
	public void setZxtype(String zxtype) {
		this.zxtype = zxtype;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCusreq() {
		return cusreq;
	}
	public void setCusreq(String cusreq) {
		this.cusreq = cusreq;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
