package com.employee.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 
 * This is the Request POJO for the Employee entity which aids with any add
 * request i.e., add any employee to an organization. Currently the address for
 * a given employee is added via a different request class.
 * 
 * @author Sharanya
 *
 */
public class AddEmployeeReq {

	@NotNull
	private int employeeId;

	@NotNull(message = "Employee name cannot be null.")
	private String employeeName;

	@Min(value = 500, message = "Minimum salary of an Employee should be 500. ")
	@Max(value = 990000, message = "Salary cannot be more than 990000 ! ")
	private double employeeSalary;

	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

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
