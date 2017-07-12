package org.sms.modules.exam.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.sms.modules.basemanage.model.SmsCompany;
import org.sms.modules.basemanage.model.SmsNoteType;
import org.sms.modules.basemanage.model.SmsPayInfo;
import org.sms.modules.basemanage.model.SmsPayType;
import org.sms.modules.basemanage.model.SmsSchool;
import org.sms.modules.usermanage.model.SmsStudent;
import org.sms.modules.usermanage.model.SmsUser;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="sms_exam")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SmsExam implements java.io.Serializable {
	private int id;
	private String comID;   //厂商ID（老考生填写）
	private String uname;   //用户名（老考生填写）
	private String upwd;   //密码（老考生填写）
	private String sysname;   //考试系统用户名
	private String syspwd;   //考试系统密码
	private String subject;   //考试科目
	private int price;   //考试价格
	private String isPlan;   //考试安排（0：否，1：是）
	private String examDate;   //考试时间
	private String examroom;   //考场
	private int score;   //考试成绩
	private String ca;   //证书
	private String ispass;   //是否包过
	
	private int zfPrice;   //已支付金额2
	private Date accountDate;   //到账时间
	private int ysPrice;   //应收账款2
	private String ysDate;   //应收时间2
	private String remark;   //备注
	private int isedit;   //是否修改（若修改则更改为1，当前的记录为红色显示）
	private int isdelete;
	private int verify;   //审核
	private int isurgent;   //是否加急安排
	private Date createDate;   //创建时间
	
	private SmsCompany com;   //厂商2
	private SmsPayInfo payInfo;   //支付信息2
	private SmsPayType payType;  //付款方式2
	private SmsNoteType noteType;   //票据2
	private SmsUser user;   //学员顾问
	private SmsStudent student;   //培训学员
	private SmsSchool school;   //校区
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComID() {
		return comID;
	}
	public void setComID(String comID) {
		this.comID = comID;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getSysname() {
		return sysname;
	}
	public void setSysname(String sysname) {
		this.sysname = sysname;
	}
	public String getSyspwd() {
		return syspwd;
	}
	public void setSyspwd(String syspwd) {
		this.syspwd = syspwd;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getIsPlan() {
		return isPlan;
	}
	public void setIsPlan(String isPlan) {
		this.isPlan = isPlan;
	}
	public String getExamroom() {
		return examroom;
	}
	public void setExamroom(String examroom) {
		this.examroom = examroom;
	}
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getCa() {
		return ca;
	}
	public void setCa(String ca) {
		this.ca = ca;
	}
	public String getIspass() {
		return ispass;
	}
	public void setIspass(String ispass) {
		this.ispass = ispass;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public int getIsedit() {
		return isedit;
	}
	public void setIsedit(int isedit) {
		this.isedit = isedit;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public int getVerify() {
		return verify;
	}
	public void setVerify(int verify) {
		this.verify = verify;
	}
	public int getIsurgent() {
		return isurgent;
	}
	public void setIsurgent(int isurgent) {
		this.isurgent = isurgent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="company_id")
	public SmsCompany getCom() {
		return com;
	}
	public void setCom(SmsCompany com) {
		this.com = com;
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
	@JoinColumn(name="paytype_id")
	public SmsPayType getPayType() {
		return payType;
	}
	public void setPayType(SmsPayType payType) {
		this.payType = payType;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="noteType_id")
	public SmsNoteType getNoteType() {
		return noteType;
	}
	public void setNoteType(SmsNoteType noteType) {
		this.noteType = noteType;
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
