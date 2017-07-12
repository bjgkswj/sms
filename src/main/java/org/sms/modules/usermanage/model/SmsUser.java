package org.sms.modules.usermanage.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.sms.modules.basemanage.model.SmsSchool;

@Entity
@Table(name="sms_user")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SmsUser implements Serializable{
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
	private SmsSchool school;
	private Set<SmsRole> troles = new HashSet<SmsRole>(0);
	
	@Id
	@GeneratedValue
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
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedatetime() {
		return createdatetime;
	}
	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}
	@Temporal(TemporalType.TIMESTAMP)
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
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="school_id")
	public SmsSchool getSchool() {
		return school;
	}
	public void setSchool(SmsSchool school) {
		this.school = school;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="sms_user_role",joinColumns={@JoinColumn(name="user_id",nullable=false,updatable=false)},inverseJoinColumns={@JoinColumn(name="role_id",nullable=false,updatable=false)})
	public Set<SmsRole> getTroles() {
		return troles;
	}
	public void setTroles(Set<SmsRole> troles) {
		this.troles = troles;
	}
	
}
