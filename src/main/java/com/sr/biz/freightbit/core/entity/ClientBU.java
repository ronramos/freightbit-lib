package com.sr.biz.freightbit.core.entity;

// Generated May 2, 2014 5:40:15 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Client generated by hbm2java
 */
@Entity
@Table(name = "client", catalog = "freightbit")
public class ClientBU implements java.io.Serializable {

	private long clientId;
	private String name;
	private String code;
	private String descripton;
	private String status;
	public Set<User> users = new HashSet<User>(0);
	public Set<Group> groups = new HashSet<Group>(0);

	public ClientBU() { 
	}

	public ClientBU(long clientId, String name, String code, String status) {
		this.clientId = clientId;
		this.name = name;
		this.code = code;
		this.status = status;
	}

	public ClientBU(long clientId, String name, String code, String descripton,
			String status) {
		this.clientId = clientId;
		this.name = name;
		this.code = code;
		this.descripton = descripton;
		this.status = status;
	}

	@Id
	@Column(name = "clientId", unique = true, nullable = false)
	public long getClientId() {
		return this.clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "code", nullable = false, length = 10)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "descripton")
	public String getDescripton() {
		return this.descripton;
	}

	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}

	@Column(name = "status", nullable = false)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<User> getUsers() {
		return this.users;
	}
 
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Group> getGroups(){
		return this.groups;
	}
	
	public void setGroups(Set<Group> groups){
		this.groups = groups;
	}
}
