package com.employee.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 
 * This is the Request POJO for the Organization entity which aids with any add
 * request i.e., add any organization to Incubatesoft master entity. Currently
 * the employee details for a given organization is added via a different
 * request class.
 * 
 * @author Sharanya
 *
 */
public class AddOrganizationReq {

	@NotNull
	private int orgId;
	
	@NotNull
	@NotEmpty
	private String orgName;
	
	@NotNull (message = "Organization needs to have an Incuabte Id to associate. ")
	private int incubateId;

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public int getIncubateId() {
		return incubateId;
	}

	public void setIncubateId(int incubateId) {
		this.incubateId = incubateId;
	}

}
