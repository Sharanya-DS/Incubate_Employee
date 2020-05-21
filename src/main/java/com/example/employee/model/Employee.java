package com.example.employee.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * POJO class representing the Employee table in the DB.
 * 
 * @author Sharanya
 *
 */

@Entity
@Table(name = "employee")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employeeAddresses"})
public class Employee implements Serializable{

	@Id
	@Column(name = "employee_id", nullable = false, unique = true)
	private int employeeId;

	@Column(name = "employee_name", nullable = false)
	private String employeeName;

	@Column(name = "employee_salary", nullable = false)
	private BigDecimal employeeSalary;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Addresses> employeeAddresses;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "org_id", nullable = false)
	@JsonBackReference
	private Organization organization;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public BigDecimal getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(BigDecimal employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public Set<Addresses> getEmployeeAddresses() {
		return employeeAddresses;
	}

	public void setEmployeeAddresses(Set<Addresses> employeeAddresses) {
		this.employeeAddresses = employeeAddresses;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
}
