package com.example.employee.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * POJO class representing the Organization table in the DB.
 * 
 * @author Sharanya
 *
 */

@Entity
@Table(name = "organization")
public class Organization implements Serializable {

	@Id
	@Column(name = "org_id", nullable = false, unique = true)
	private int orgId;

	@Column(name = "org_name", nullable = false)
	private String orgName;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "incubate_id", nullable = false)
	@JsonBackReference
	private Incubatesoft incubatesoft;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "organization")
	@JsonManagedReference
	private Set<Employee> employees;

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Incubatesoft getIncubatesoft() {
		return incubatesoft;
	}

	public void setIncubatesoft(Incubatesoft incubatesoft) {
		this.incubatesoft = incubatesoft;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
