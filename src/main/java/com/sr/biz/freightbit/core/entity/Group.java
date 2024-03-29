package com.sr.biz.freightbit.core.entity;

// Generated May 2, 2014 5:40:15 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Group generated by hbm2java
 */
@Entity
@Table(name = "group", catalog = "freightbit", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Group implements java.io.Serializable {

	private long groupId;
	private Client client;
	private String name;
	private String description;
	private Date creationDate;
	private Date modifiedDate;

	public Group() {
	}

	public Group(long groupId, Client client, String name, Date creationDate,
			Date modifiedDate) {
		this.groupId = groupId;
		this.client = client;
		this.name = name;
		this.creationDate = creationDate;
		this.modifiedDate = modifiedDate;
	}

	public Group(long groupId, Client client, String name, String description,
			Date creationDate, Date modifiedDate) {
		this.groupId = groupId;
		this.client = client;
		this.name = name;
		this.description = description;
		this.creationDate = creationDate;
		this.modifiedDate = modifiedDate;
	}

	@Id
	@GeneratedValue
	@Column(name = "groupId", unique = true, nullable = false)
	public long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CLIENTID", nullable = false)
	//@Column(name = "clientId", nullable = false)
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "name", unique = true, nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "creationDate", nullable = false)
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "modifiedDate", nullable = false)
	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
