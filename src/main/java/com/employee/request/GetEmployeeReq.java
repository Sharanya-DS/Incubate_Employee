package com.employee.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 
 * This is the Request POJO for that contains employee salary and employee name which aids with any add
 * request i.e., add any address for an employee.
 * 
 * @author Sharanya
 *
 */
public class GetEmployeeReq {
	
	@NotNull(message = "Employee name starts with cannot be null.")
	@NotEmpty(message = "Employee name cannot be empty. Please provide a valid starts with criteria. ")
	private String employeeName;
	
	@NotNull(message = "Employee salary cannot be null.")
	private double employeeSalary;
	
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
		

}
