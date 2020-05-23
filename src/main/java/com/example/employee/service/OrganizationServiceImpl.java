package com.example.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.request.AddOrganizationReq;
import com.example.employee.model.Employee;
import com.example.employee.model.Incubatesoft;
import com.example.employee.model.Organization;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.IncubateRepository;
import com.example.employee.repository.OrganizationRepository;

/**
 * The class contains the code logic for all the Organization related business
 * flow of the Service classes by implementing the OrganizationService
 * interface. The class can be annotated with @Component or @Service, but
 * generally
 * 
 * @Component is preferred.
 * 
 * @author Sharanya
 *
 */
@Component
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationRepository organizationRepository;

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	IncubateRepository incubateRepository;

	/**
	 * Overridden method to add a new organization. This invokes
	 * {@link OrganizationRepository organizationRepository} to save all the
	 * organization details.
	 * 
	 * @param organization the organization data that needs to be added to the
	 *                     organization.
	 * 
	 * @return the value of the newly added organization's Id.
	 */
	@Override
	public void addOrganization(AddOrganizationReq org) {
		Incubatesoft incubatesoft = incubateRepository.findByIncubateId(org.getIncubateId());

		Organization organization = new Organization();
		organization.setOrgId(org.getOrgId());
		organization.setOrgName(org.getOrgName());
		organization.setIncubatesoft(incubatesoft);

		organizationRepository.save(organization);
	}

	/**
	 * Overridden method to check if a particular organization exists for the given
	 * organization id. This invokes {@link OrganizationRepository
	 * organizationRepository} to get the organization details from the database
	 * using the organization id on the existsById().
	 * 
	 * @param organizationId the unique identifier for a particular organization.
	 * 
	 * @return true if organization is present and false if no matching record is
	 *         available.
	 * 
	 */
	@Override
	public boolean checkIfOrgExists(int orgId) {
		return organizationRepository.existsById(orgId);
	}

	/**
	 * Overridden method to check if a particular organization exists for the given
	 * organization id. This invokes {@link OrganizationRepository
	 * organizationRepository} to get the organization details from the database
	 * using the organization id on the auto created Jpa query.
	 * 
	 * @param organizationId the unique identifier for a particular organization.
	 * 
	 * @return organization details for the given id.
	 * 
	 */
	@Override
	public Organization getOrganizationById(int orgId) {
		organizationRepository.findById(orgId);
		return null;
	}

	/**
	 * Overridden method to fetch all the organizations. This invokes
	 * {@link OrganizationRepository organizationRepository} to fetch all the
	 * organizations.
	 * 
	 * @return all the organizations present and their corresponding details.
	 */
	@Override
	public List<Organization> getAllOrganizations() {
		List<Organization> organizations = new ArrayList<Organization>();
		List<Employee> employees = new ArrayList<Employee>();
		organizationRepository.findAll().forEach(organizations1 -> organizations.add(organizations1));
		return organizations;
	}
}
