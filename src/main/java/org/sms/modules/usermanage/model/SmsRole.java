package org.sms.modules.usermanage.model;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="sms_role")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SmsRole implements Serializable{
	private String id;
	private String name;
	private String remark;
	private int seq;
	private SmsRole trole;
	private Set<SmsRole> troles = new HashSet<SmsRole>(0);
	private Set<SmsUser> tusers = new HashSet<SmsUser>(0);
	private Set<SmsResource> tresources = new HashSet<SmsResource>(0);
	
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	@ManyToOne
	@JoinColumn(name="pid")
	public SmsRole getTrole() {
		return trole;
	}
	public void setTrole(SmsRole trole) {
		this.trole = trole;
	}
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="trole")
	public Set<SmsRole> getTroles() {
		return troles;
	}
	public void setTroles(Set<SmsRole> troles) {
		this.troles = troles;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="sms_user_role",joinColumns={@JoinColumn(name="role_id",nullable=false,updatable=false)},inverseJoinColumns={@JoinColumn(name="user_id",nullable=false,updatable=false)})
	public Set<SmsUser> getTusers() {
		return tusers;
	}
	public void setTusers(Set<SmsUser> tusers) {
		this.tusers = tusers;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="sms_role_resource",joinColumns={@JoinColumn(name="role_id",nullable=false,updatable=false)},inverseJoinColumns={@JoinColumn(name="resource_id",nullable=false,updatable=false)})
	public Set<SmsResource> getTresources() {
		return tresources;
	}
	public void setTresources(Set<SmsResource> tresources) {
		this.tresources = tresources;
	}
}
