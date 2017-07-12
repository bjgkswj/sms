package org.sms.modules.basemanage.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="sms_school")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SmsSchool implements Serializable {
	private int id;
	private String schoolname;
	
	@Id
	@GeneratedValue
	@Column(name="id",nullable=false,length=30)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="schoolname",nullable=false,length=30)
	public String getSchoolname() {
		return schoolname;
	}
	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}
}
