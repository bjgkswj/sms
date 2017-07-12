package org.sms.modules.usermanage.modelPage;

import java.util.Date;

import org.sms.core.PagerHelper;

public class User extends PagerHelper{
	private int id;
	private String username;
	private String password;
	private String name;
	private String sex;
	private String phone;
	private String email;
	private Date createdatetime;
	private Date modifydatetime;
	private String qq;
	private String sphone;
	private String tel;
	
	private int schoolId;
	private String schoolName;
	private String roleIds;
	private String roleNames;
	
	private Date createdateStart;
	private Date createdateEnd;
	private Date modifydateStart;
	private Date modifydateEnd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Date getCreatedatetime() {
		return createdatetime;
	}
	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}
	public Date getModifydatetime() {
		return modifydatetime;
	}
	public void setModifydatetime(Date modifydatetime) {
		this.modifydatetime = modifydatetime;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	public String getRoleNames() {
		return roleNames;
	}
	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}
	public Date getCreatedateStart() {
		return createdateStart;
	}
	public void setCreatedateStart(Date createdateStart) {
		this.createdateStart = createdateStart;
	}
	public Date getCreatedateEnd() {
		return createdateEnd;
	}
	public void setCreatedateEnd(Date createdateEnd) {
		this.createdateEnd = createdateEnd;
	}
	public Date getModifydateStart() {
		return modifydateStart;
	}
	public void setModifydateStart(Date modifydateStart) {
		this.modifydateStart = modifydateStart;
	}
	public Date getModifydateEnd() {
		return modifydateEnd;
	}
	public void setModifydateEnd(Date modifydateEnd) {
		this.modifydateEnd = modifydateEnd;
	}
	
}
