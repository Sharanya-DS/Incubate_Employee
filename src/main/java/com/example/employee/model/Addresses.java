package com.example.employee.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * POJO class representing the Addresses table in the DB.
 * This implements the Serializable interface.
 * 
 * @author Sharanya
 *
 */
@Table(name = "address")
@Entity
public class Addresses implements Serializable {

	@Id
	@Column(name = "address_id", nullable = false, unique = true)
	private int id;

	@Column(name = "address_string", nullable = false)
	private String address;

	@Column(name = "country", nullable = false)
	private String country;

	@Column(name = "pincode", nullable = false)
	private String pincode;

	
	@JoinColumn( name = "employee_id", referencedColumnName = "employee_id")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
	@JsonBackReference
	private Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
