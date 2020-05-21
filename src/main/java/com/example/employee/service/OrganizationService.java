package com.example.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.request.AddOrganizationReq;
import com.example.employee.model.Organization;
import com.example.employee.repository.EmployeeRepository;

/**
 * The interface is used to loose couple any Organization related business logic
 * of the Service classes. The @Servcie annotation marks this interface to cater
 * to any business related functions for the Organization. This interface
 * contains project specific methods that need to be implemented by the
 * implementing classes.
 * 
 * @author Sharanya
 *
 */
@Service
public interface OrganizationService {

	/**
	 * Method to add a new organization. This invokes {@link OrganizationRepository
	 * organizationRepository} to save all the organization details.
	 * 
	 * @param organization the organization data that needs to be added to the
	 *                     organization.
	 * 
	 * @return the value of the newly added organization's Id.
	 */
	public void addOrganization(AddOrganizationReq org);

	/**
	 * Method to check if a particular organization exists for the given
	 * organization id. This invokes {@link OrganizationRepository
	 * organizationRepository} to get the organization details from the database
	 * using the organization id on the auto created Jpa query.
	 * 
	 * @param organizationId the unique identifier for a particular organization.
	 * 
	 * @return organization details for the given id.
	 * 
	 */
	public Organization getOrganizationById(int orgId);

	/**
	 * Method to check if a particular organization exists for the given
	 * organization id. This invokes {@link OrganizationRepository
	 * organizationRepository} to get the organization details from the database using
	 * the organization id on the existsById().
	 * 
	 * @param organizationID the unique identifier for a particular employee.
	 * 
	 * @return true if organization is present and false if no matching record is
	 *         available.
	 * 
	 */
	public boolean checkIfOrgExists(int orgId);

	/**
	 * Method to fetch all the organizations. This invokes
	 * {@link OrganizationRepository organizationRepository} to fetch all the
	 * organizations.
	 * 
	 * @return all the organizations present and their corresponding details.
	 */
	public List<Organization> getAllOrganizations();

}
