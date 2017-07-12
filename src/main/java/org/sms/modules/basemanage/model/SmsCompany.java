package org.sms.modules.basemanage.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.sms.modules.usermanage.model.SmsRole;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
/**
 * 培训厂商
 * @author ZMZY
 *
 */
@Entity
@Table(name="sms_company")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SmsCompany implements Serializable  {
	private int id;
	private String name;
	private SmsCompany comp;
	private Integer seq;
	private String remark;
	private SmsRole role = new SmsRole();
	
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
	@Column(name = "seq")
	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pid")
	public SmsCompany getComp() {
		return this.comp;
	}

	public void setComp(SmsCompany comp) {
		this.comp = comp;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	public SmsRole getRole() {
		return role;
	}
	public void setRole(SmsRole role) {
		this.role = role;
	}
}
