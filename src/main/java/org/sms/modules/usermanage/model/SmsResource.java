package org.sms.modules.usermanage.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="sms_resource")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SmsResource implements Serializable{
	private String id;
	private String icon;
	private String name;
	private String remark;
	private int seq;
	private String url;
	private SmsResource tresource;
	private SmsResourceType tresourcetype;
	private Set<SmsResource> tresources = new HashSet<SmsResource>(0);
	private Set<SmsRole> troles = new HashSet<SmsRole>(0);
	
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pid")
	public SmsResource getTresource() {
		return tresource;
	}
	public void setTresource(SmsResource tresource) {
		this.tresource = tresource;
	}
	
	@ManyToOne
	@JoinColumn(name="resourcetype_id")
	public SmsResourceType getTresourcetype() {
		return tresourcetype;
	}
	public void setTresourcetype(SmsResourceType tresourcetype) {
		this.tresourcetype = tresourcetype;
	}
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="tresource")
	public Set<SmsResource> getTresources() {
		return tresources;
	}
	public void setTresources(Set<SmsResource> tresources) {
		this.tresources = tresources;
	}
	
	@ManyToMany
	@JoinTable(name="sms_role_resource",joinColumns={@JoinColumn(name="resource_id",nullable=false,updatable=false)},inverseJoinColumns={@JoinColumn(name="role_id",nullable=false,updatable=false)})
	public Set<SmsRole> getTroles() {
		return troles;
	}
	public void setTroles(Set<SmsRole> troles) {
		this.troles = troles;
	}
}
