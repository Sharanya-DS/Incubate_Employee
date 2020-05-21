package com.example.employee.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.model.Employee;

/**
 * The interface that extends the JPA Repository. This interface contains
 * project specific methods that construct JPA queries for any Employee related
 * flow. The queries are self constructed according to their method name
 * definition. This interface may or may not have any implementation classes.
 * The @Repository helps make the connection with the DB.
 * 
 * @author Sharanya
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findByEmployeeSalaryGreaterThanAndEmployeeNameStartingWith(BigDecimal salary,
			String employeeName);
	
	public Employee findByEmployeeId(int employeeId);

}
