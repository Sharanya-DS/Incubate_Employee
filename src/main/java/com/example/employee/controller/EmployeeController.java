/**
 * 
 */
package com.example.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.request.AddAddressReq;
import com.employee.request.AddEmployeeReq;
import com.employee.request.AddOrganizationReq;
import com.employee.request.GetEmployeeReq;
import com.example.employee.model.Addresses;
import com.example.employee.model.Employee;
import com.example.employee.model.Organization;
import com.example.employee.service.AddressService;
import com.example.employee.service.AddressServiceImpl;
import com.example.employee.service.EmployeeService;
import com.example.employee.service.EmployeeServiceImpl;
import com.example.employee.service.OrganizationService;
import com.example.employee.service.OrganizationServiceImpl;

/**
 * 
 * This is the REST Controller that contains API methods for various Employee,
 * Organization and Address functions. Methods will be called depending on the
 * HTTP request and the url path.
 * 
 * @author Sharanya
 *
 */

@RestController
//one swagger annotation for desc
// one for each request service
//@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@Autowired
	private OrganizationService orgService;

	@Autowired
	private AddressService addressService;

	/**
	 * Method that gets called when the application starts with no specific url.
	 * This invokes {@link EmployeeServiceImpl empService} which returns a
	 * predefined welcome message.
	 * 
	 * @return the welcome message from the service.
	 */
	@RequestMapping
	public String welcome() {
		return empService.retrieveWelcomeMessage();
	}

	/**
	 * Method to add a new organization. This invokes {@link OrganizationServiceImpl
	 * orgService} which calls the OrganizationRepository to add the organization
	 * details.
	 * 
	 * @param organization the organization data that needs to be added to the
	 *                     organization.
	 * 
	 * @return the value of the newly added organization's Id.
	 */
	@PostMapping("/organization")
	private void addOrganization(@RequestBody AddOrganizationReq addOrganizationReq) {
		orgService.addOrganization(addOrganizationReq);

	}

	/**
	 * Method to fetch all the organizations. This invokes
	 * {@link OrganizationServiceImpl orgService} which calls the
	 * OrganizationRepository to fetch all the organizations.
	 * 
	 * @return all the organizations present and their corresponding details.
	 */
	@GetMapping("/organization/get")
	public List<Organization> getAllOrganizations() {
		return orgService.getAllOrganizations();
	}

	/**
	 * Method to add Employee details for an organization.First, the method confirms
	 * if the organization exists and if it does,then adds the employee to it. This
	 * invokes {@link EmployeeServiceImpl empService} which calls the
	 * EmployeeRepository to get the employee details from the database using the
	 * pinCode as the search criteria.
	 * 
	 * @param orgId    the identification of a particular organization under which
	 *                 the employee needs to be added.
	 * @param employee the employee data that needs to be added to the organization.
	 * 
	 * @return the value of the newly added employee's Id.
	 */
	@PostMapping("/add")
	private String addEmployee(@RequestHeader(name = "ORGID", required = true) int orgId,
			@RequestBody @Valid AddEmployeeReq addEmployeeReq) {

		boolean orgExists = orgService.checkIfOrgExists(orgId);

		if (orgExists) {
			empService.addEmployee(addEmployeeReq, orgId);
			return ("Employee " + addEmployeeReq.getEmployeeId() + " added successfully under the Organization. ");
		} else {
			return ("Employee " + addEmployeeReq.getEmployeeId() + " cannot be added as Organization does not exist. ");
		}

	}

	/**
	 * Method to add Employee address details for a particular employee working
	 * under an organization.First, the method confirms if the employee exists and
	 * if it does,the address to it. This invokes {@link EmployeeServiceImpl
	 * empService} which calls the EmployeeRepository to check if the employee
	 * exists. Then it invokes {@link AddressServiceImpl addressService} which calls
	 * the AddressRepository to save the address for the given employee.
	 * 
	 * @param employeeId the identification of a particular employee to which the
	 *                   address needs to be added.
	 * @param addresses  the address that needs to be added to the employee
	 * 
	 * @return a confirmation string of whether the address was added to the
	 *         employee or not.
	 * 
	 */
	@PostMapping("/addresses/{employeeId}")
	private String addEmployeeAddresses(@PathVariable("employeeId") int employeeId,
			@RequestBody AddAddressReq addAddressReq) {

		boolean empExists = empService.checkIfEmpExists(employeeId);

		if (empExists) {
			addressService.addAddresses(addAddressReq, employeeId);
			return ("Address(es) were added for the employee under the Organization ");
		} else {
			return ("Employee " + employeeId + " does not exist. Therefore address(es) cannot be added. ");
		}

	}

	/**
	 * Method to fetch Employee details for a specified pin code in the address. The
	 * method also fetches the corresponding organization details of the employee.
	 * This invokes {@link EmployeeServiceImpl empService} which creates a native
	 * sql query to get the employee details from the database using the pinCode as
	 * the search criteria.
	 * 
	 * @param pinCode a 6 digit pin code value for which the employee and their
	 *                corresponding organization details need to be fetched.
	 * @return the employee and organization details for the given pin code.
	 * 
	 */

	@GetMapping("/employee/{pinCode}")
	public List<Employee> getEmployeeByPin(@PathVariable("pinCode") String pinCode) {
		System.out.println("pinCode is :::::::::: " + pinCode);
		return empService.getEmployeeByPin(pinCode);
	}

	/**
	 * Method to fetch all the addresses for a given pincode. This invokes
	 * {@link AddressServiceImpl addressService} which calls the AddressRepository
	 * to get the addresses using the pincode as the search criteria.
	 * 
	 * @param pincode the search criteria for which all the matching addresses need
	 *                to retreived.
	 * @return all the available addresses for the given pincode.
	 * 
	 */
	@GetMapping("/employee/pincode")
	public List<Addresses> getAddressesByPincode(@RequestParam("pincode") String pincode) {
		System.out.println("pincode :::::::::: " + pincode);
		return addressService.getAddressesByPincode(pincode);
	}

	/**
	 * Method to fetch all the employees whose name starts with a certain alphabet
	 * and whose salary is above a certain number. This invokes
	 * {@link EmployeeServiceImpl empService} which calls the EmployeeRepository to
	 * get the employee details from the database using the name and salary as the
	 * search criteria. Here @PostMapping is used to fetch details because the
	 * search criteria comes in the form of request body.
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

	@PostMapping("/employee")
	public List<Employee> getEmployeeBySalaryAndName(@RequestBody GetEmployeeReq getEmployeeReq) {

		double salary = getEmployeeReq.getEmployeeSalary();
		String name = getEmployeeReq.getEmployeeName();

		return empService.getEmployeeBySalaryAndName(salary, name);
	}

}
