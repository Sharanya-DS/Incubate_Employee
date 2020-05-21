package com.example.employee.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.employee.request.AddEmployeeReq;
import com.example.employee.model.Employee;
import com.example.employee.model.Organization;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.OrganizationRepository;

/**
 * The class contains the code logic for all the Employee related business flow
 * of the Service classes by implementing the EmployeeService interface. The
 * class can be annotated with @Component or @Service, but generally @Component
 * is preferred.
 * 
 * @author Sharanya
 *
 */
@Component
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	OrganizationRepository organizationRepository;

	@PersistenceContext
	EntityManager entityManager;

	private static final String QUERY_EMP_FROM_PINCODE = "select em.* from public.employee as em, public.address as addr where addr.pincode = ? and em.employee_id = addr.employee_id";

	@Override
	// getting all employees record by using the method findaAll() of CrudRepository
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(employees1 -> employees.add(employees1));
		return employees;
	}

	/**
	 * Overidden method to check if a particular employee exists for the given
	 * employee id. This invokes {@link EmployeeRepository empRepository} to get the
	 * employee details from the database using the employee id on the auto created
	 * Jpa query.
	 * 
	 * @param employeeId the unique identifier for a particular employee.
	 * 
	 * @return employee details for the given id.
	 * 
	 */
	@Override
	public Employee getEmployeeById(int employeeId) {
		return employeeRepository.findById(employeeId).get();
	}

	/**
	 * Overridden method to add Employee details for an organization.First, the
	 * method confirms if the organization exists and if it does,then adds the
	 * employee to it. This invokes {@link EmployeeRepository employeeRepository} to
	 * get the employee details from the database using the pinCode as the search
	 * criteria.
	 * 
	 * @param addEmployeeReq contains the employee details to be added along with
	 *                       its corresponding organization id.
	 */
	@Override
	public void addEmployee(AddEmployeeReq employee, int orgId) {
		
		Organization organization = organizationRepository.findByOrgId(orgId);
		
		Employee emp = new Employee();
		emp.setEmployeeId(employee.getEmployeeId());
		emp.setEmployeeName(employee.getEmployeeName());
		emp.setEmployeeSalary(BigDecimal.valueOf(employee.getEmployeeSalary()));
		emp.setOrganization(organization);

		employeeRepository.save(emp);

	}

	/**
	 * Overridden method to fetch Employee details for a specified pin code in the
	 * address. The method also fetches the corresponding organization details of
	 * the employee. This creates a native sql query to retrieve the employee
	 * details for the corresponding pincode from the address table directly
	 * connecting to the database using the entityManager which
	 * is @PersistanceContext.
	 * 
	 * @param pinCode a 6 digit pin code value for which the employee and their
	 *                corresponding organization details need to be fetched.
	 * @return the employee and organization details for the given pin code.
	 * 
	 */

	@Override
	public List<Employee> getEmployeeByPin(String pincode) {
		Query query = entityManager.createNativeQuery(QUERY_EMP_FROM_PINCODE, Employee.class);
		query.setParameter(1, pincode);
		// like use %
		// if adddress is req as well - from result list get employee and for each emp
		// get their addresses.
		return query.getResultList();
	}

	/**
	 * Method that gets called when the application starts to return a predefined
	 * welcome message.
	 * 
	 * @return the welcome message to the controller.
	 */
	@Override
	public String retrieveWelcomeMessage() {
		return "Welcome !";
	}

	/**
	 * Overridden method to check if a particular employee exists for the given
	 * employee id. This invokes {@link EmployeeRepository empRepository} to get the
	 * employee details from the database using the employee id on the existsById().
	 * 
	 * @param employeeId the unique identifier for a particular employee.
	 * 
	 * @return true if employee is present and false if no matching record is
	 *         available.
	 * 
	 */
	@Override
	public boolean checkIfEmpExists(int employeeId) {
		return employeeRepository.existsById(employeeId);
	}

	/**
	 * Overridden method to fetch all the employees whose name starts with a certain
	 * alphabet and whose salary is above a certain number. This invokes
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
	@Override
	public List<Employee> getEmployeeBySalaryAndName(double salary, String employeeName) {
		BigDecimal salaryInBigDecimal = BigDecimal.valueOf(salary);
		return employeeRepository.findByEmployeeSalaryGreaterThanAndEmployeeNameStartingWith(salaryInBigDecimal, employeeName);
	}

}
