package com.example.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.request.AddEmployeeReq;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

/**
 * The interface is used to loose couple any Employee related business logic of
 * the Service classes. The @Servcie annotation marks this interface to cater to
 * any business related functions for the Employee. This interface contains
 * project specific methods that need to be implemented by the implementing
 * classes.
 * 
 * @author Sharanya
 *
 */
@Service
public interface EmployeeService {

	// getting all employees record by using the method findaAll() of CrudRepository
	public List<Employee> getAllEmployees();

	/**
	 * Method to check if a particular employee exists for the given employee id.
	 * This invokes {@link EmployeeRepository empRepository} to get the employee
	 * details from the database using the employee id on the auto created Jpa
	 * query.
	 * 
	 * @param employeeId the unique identifier for a particular employee.
	 * 
	 * @return employee details for the given id.
	 * 
	 */
	public Employee getEmployeeById(int employeeId);

	/**
	 * Method to add Employee details for an organization.First, the method confirms
	 * if the organization exists and if it does,then adds the employee to it. This
	 * invokes {@link EmployeeRepository employeeRepository} to get the employee
	 * details from the database using the pinCode as the search criteria.
	 * 
	 * @param addEmployeeReq contains the employee details to be added along with
	 *                       its corresponding organization id.
	 * @param orgId 
	 */
	public void addEmployee(AddEmployeeReq addEmployeeReq, int orgId);

	/**
	 * Method to fetch Employee details for a specified pin code in the address. The
	 * method also fetches the corresponding organization details of the employee.
	 * This invokes {@link EmployeeRepository employeeRepository} to get the
	 * employee details from the database using the pinCode as the search criteria.
	 * 
	 * @param pinCode a 6 digit pin code value for which the employee and their
	 *                corresponding organization details need to be fetched.
	 * @return the employee and organization details for the given pin code.
	 * 
	 */
	public List<Employee> getEmployeeByPin(String pincode);

	/**
	 * Method that gets called when the application starts to return a predefined
	 * welcome message.
	 * 
	 * @return the welcome message to the controller.
	 */
	public String retrieveWelcomeMessage();

	/**
	 * Method to check if a particular employee exists for the given
	 * employee id. This invokes {@link EmployeeRepository empRepository} to get
	 * the employee details from the database using the employee id on the
	 * existsById().
	 * 
	 * @param employeeId the unique identifier for a particular employee.
	 * 
	 * @return true if employee is present and false if no matching record is
	 *         available.
	 * 
	 */
	public boolean checkIfEmpExists(int employeeId);

	/**
	 * Method to fetch all the employees whose name starts with a certain alphabet
	 * and whose salary is above a certain number. This invokes
	 * {@link EmployeeRepository empRepository} to get the employee details from the
	 * database using the name and salary as the search criteria.
	 * 
	 * @param name   name of the employee whose corresponding details need to be
	 *               fetched.
	 * @param salary the value of an employee's salary. All employees whose salary
	 *               is greater than this value will be returned corresponding
	 *               employee's details need to be fetched.
	 * @return list of Employees whose names starts with and whose salary is greater
	 *         than the input along with their details.
	 * 
	 */
	public List<Employee> getEmployeeBySalaryAndName(double salary, String employeeName);

}
