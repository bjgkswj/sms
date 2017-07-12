package org.sms.modules.project.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.sms.modules.basemanage.model.SmsClassType;
import org.sms.modules.basemanage.model.SmsSchool;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="sms_project")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SmsProject {
	private String id;
	private String name;
	private SmsProjectType proType ;
	private SmsClassType classType;
	private SmsSchool school;
	private Date beginDate;
	private Date endDate;
	private int isattend;
	private int isdelete;
	private Date createDate;   //创建时间
	
	private int zsCount;
	private int cdCount;
	private int stCount;
	private String zsStus;
	private String cdStus;
	private String stStus;
	
	private String js;
	private String bzr;
	
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ptype_id")
	public SmsProjectType getProType() {
		return proType;
	}
	public void setProType(SmsProjectType proType) {
		this.proType = proType;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ctype_id")
	public SmsClassType getClassType() {
		return classType;
	}
	public void setClassType(SmsClassType classType) {
		this.classType = classType;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="school_id")
	public SmsSchool getSchool() {
		return school;
	}
	public void setSchool(SmsSchool school) {
		this.school = school;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getIsattend() {
		return isattend;
	}
	public void setIsattend(int isattend) {
		this.isattend = isattend;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getZsCount() {
		return zsCount;
	}
	public void setZsCount(int zsCount) {
		this.zsCount = zsCount;
	}
	public int getCdCount() {
		return cdCount;
	}
	public void setCdCount(int cdCount) {
		this.cdCount = cdCount;
	}
	public int getStCount() {
		return stCount;
	}
	public void setStCount(int stCount) {
		this.stCount = stCount;
	}
	public String getZsStus() {
		return zsStus;
	}
	public void setZsStus(String zsStus) {
		this.zsStus = zsStus;
	}
	public String getCdStus() {
		return cdStus;
	}
	public void setCdStus(String cdStus) {
		this.cdStus = cdStus;
	}
	public String getStStus() {
		return stStus;
	}
	public void setStStus(String stStus) {
		this.stStus = stStus;
	}
	public String getJs() {
		return js;
	}
	public void setJs(String js) {
		this.js = js;
	}
	public String getBzr() {
		return bzr;
	}
	public void setBzr(String bzr) {
		this.bzr = bzr;
	}
}
