/**
 * 
 */
package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.model.Organization;

/**
 * The interface that extends the JPA Repository. The @Repository helps make the
 * connection with the DB. This interface contains project specific methods that
 * construct JPA queries for any Organization related flow. The queries are self
 * constructed according to their method name definition. This interface may or
 * may not have any implementation classes.
 * 
 * @author Sharanya
 *
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
	
	public Organization findByOrgId(int orgId);

}
