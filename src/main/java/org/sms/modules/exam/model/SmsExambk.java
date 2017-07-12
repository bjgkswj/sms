package org.sms.modules.exam.model;

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

@Entity
@Table(name="sms_exambk")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SmsExambk {
	private int id;
	private String subject;   //考试科目
	private int price;   //考试价格
	private int zfPrice;   //已付金额
	private int ysPrice;   //应收账款
	private String ysDate;   //应收时间
	private String examDate;   //考试时间
	private String examRoom;   //考场
	private int isPass;   //是否通过
	private String remark;   //备注
	private int isdelete;
	private Date createDate;
	private SmsExam exam;   //考试信息
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getZfPrice() {
		return zfPrice;
	}
	public void setZfPrice(int zfPrice) {
		this.zfPrice = zfPrice;
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
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	public String getExamRoom() {
		return examRoom;
	}
	public void setExamRoom(String examRoom) {
		this.examRoom = examRoom;
	}
	public int getIsPass() {
		return isPass;
	}
	public void setIsPass(int isPass) {
		this.isPass = isPass;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	@JoinColumn(name="exam_id")
	public SmsExam getExam() {
		return exam;
	}
	public void setExam(SmsExam exam) {
		this.exam = exam;
	}
}
