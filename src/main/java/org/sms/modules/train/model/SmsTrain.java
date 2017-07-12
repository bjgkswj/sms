package org.sms.modules.train.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.sms.modules.basemanage.model.SmsClassType;
import org.sms.modules.basemanage.model.SmsCompany;
import org.sms.modules.basemanage.model.SmsNoteType;
import org.sms.modules.basemanage.model.SmsPayInfo;
import org.sms.modules.basemanage.model.SmsPayType;
import org.sms.modules.basemanage.model.SmsSchool;
import org.sms.modules.basemanage.model.SmsTechSubject;
import org.sms.modules.usermanage.model.SmsStudent;
import org.sms.modules.usermanage.model.SmsUser;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="sms_train")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SmsTrain implements java.io.Serializable{
	private int id;
	private int price;   //培训价格
	private Date trainDate;   //培训时间
	private String fqInfo;   //费用分期
	private int zfPrice;   //已支付金额
	private Date accountDate;   //到账时间
	private int ysPrice;   //应收账款
	private String ysDate;   //应收时间
	private String spereq;   //餐宿等特殊要求
	private String remark;   //备注
	private String status;   //培训状态
	private int verify;   //审核
	private int isdelete;
	private Date createDate;   //创建时间
	
	private SmsCompany company;   //厂商
	private SmsTechSubject techSub;   //培训课程
	private SmsClassType classType;   //培训班型
	private SmsPayInfo payInfo;   //支付信息
	private SmsNoteType noteType;   //票据
	private SmsPayType payType;   //付款方式
	private SmsUser user;   //学员顾问
	private SmsStudent student;   //培训学员
	private SmsSchool school;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getTrainDate() {
		return trainDate;
	}
	public void setTrainDate(Date trainDate) {
		this.trainDate = trainDate;
	}
	public String getFqInfo() {
		return fqInfo;
	}
	public void setFqInfo(String fqInfo) {
		this.fqInfo = fqInfo;
	}
	public int getZfPrice() {
		return zfPrice;
	}
	public void setZfPrice(int zfPrice) {
		this.zfPrice = zfPrice;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	public int getYsPrice() {
		return ysPrice;
	}
	public void setYsPrice(int ysPrice) {
		this.ysPrice = ysPrice;
	}
	public String getYsDate() {
		return ysDate;
	}
	public void setYsDate(String ysDate) {
		this.ysDate = ysDate;
	}
	public String getSpereq() {
		return spereq;
	}
	public void setSpereq(String spereq) {
		this.spereq = spereq;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getVerify() {
		return verify;
	}
	public void setVerify(int verify) {
		this.verify = verify;
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
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="company_id")
	public SmsCompany getCompany() {
		return company;
	}
	public void setCompany(SmsCompany company) {
		this.company = company;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="techsub_id")
	public SmsTechSubject getTechSub() {
		return techSub;
	}
	public void setTechSub(SmsTechSubject techSub) {
		this.techSub = techSub;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="classtype_id")
	public SmsClassType getClassType() {
		return classType;
	}
	public void setClassType(SmsClassType classType) {
		this.classType = classType;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="payinfo_id")
	public SmsPayInfo getPayInfo() {
		return payInfo;
	}
	public void setPayInfo(SmsPayInfo payInfo) {
		this.payInfo = payInfo;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="notetype_id")
	public SmsNoteType getNoteType() {
		return noteType;
	}
	public void setNoteType(SmsNoteType noteType) {
		this.noteType = noteType;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="paytype_id")
	public SmsPayType getPayType() {
		return payType;
	}
	public void setPayType(SmsPayType payType) {
		this.payType = payType;
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
	@JoinColumn(name="stu_id")
	public SmsStudent getStudent() {
		return student;
	}
	public void setStudent(SmsStudent student) {
		this.student = student;
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
