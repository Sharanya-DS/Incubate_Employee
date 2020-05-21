package com.employee.request;

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

	private int employeeId;
	private String employeeName;
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
