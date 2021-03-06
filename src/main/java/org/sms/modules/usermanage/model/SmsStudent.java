package org.sms.modules.usermanage.model;

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
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 培训学员信息
 * @author ZMZY
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="sms_student")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SmsStudent implements Serializable{
	private int sid;
	private String id;   //学号
	private String uname;
	private String pwd;
	private String name;   //姓名
	
	private String firstName;
	private String lastName;
	
	private String sex;   //性别
	private String company;   //单位名称
	private String tel;   //固定电话
	private String phone1;   //手机1
	private String phone2;   //手机2
	private String email1;   //邮件1
	private String email2;   //邮件2
	private String QQ;
	private String MSN;
	private String comAddr;   //公司地址
	private String card;   //身份证号码
	private String edu;   //教育程度
	private Date signDate;   //报名日期
	private Date createDate;   //创建时间
	private String remark;
	private String files;   //学生文件
	
	private int stuType;   //学员类型  1.正式学员 2.重读学员 3.试听学员
	private int isdelete;   //是否删除（用于假删除）
	
	private int lrr_id;
	
	private SmsUser user;   //学员顾问
	private SmsSchool school;
	
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getMSN() {
		return MSN;
	}
	public void setMSN(String mSN) {
		MSN = mSN;
	}
	public String getComAddr() {
		return comAddr;
	}
	public void setComAddr(String comAddr) {
		this.comAddr = comAddr;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getSignDate() {
		return signDate;
	}
	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	public int getStuType() {
		return stuType;
	}
	public void setStuType(int stuType) {
		this.stuType = stuType;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
	public int getLrr_id() {
		return lrr_id;
	}
	public void setLrr_id(int lrr_id) {
		this.lrr_id = lrr_id;
	}
	@ManyToOne
	@JoinColumn(name="user_id")
	public SmsUser getUser() {
		return user;
	}
	public void setUser(SmsUser user) {
		this.user = user;
	}
	@ManyToOne
	@JoinColumn(name="school_id")
	public SmsSchool getSchool() {
		return school;
	}
	public void setSchool(SmsSchool school) {
		this.school = school;
	}
}
