package com.example.employee.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * POJO class representing Incubatesoft.
 * 
 * @author Sharanya
 *
 */
@Table(name = "incubatesoft")
@Entity
public class Incubatesoft implements Serializable {

	@Id
	@Column(name = "incubate_id", nullable = false, unique = true)
	private int incubateId;

	@Column(name = "incubate_desc", nullable = false)
	private String incubateDesc;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "incubatesoft", cascade = CascadeType.ALL)
	private Set<Organization> organizations;

	public int getIncubateId() {
		return incubateId;
	}

	public void setIncubateId(int incubateId) {
		this.incubateId = incubateId;
	}

	public Set<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(Set<Organization> organizations) {
		this.organizations = organizations;
	}

	public String getIncubateDesc() {
		return incubateDesc;
	}

	public void setIncubateDesc(String incubateDesc) {
		this.incubateDesc = incubateDesc;
	}

}
