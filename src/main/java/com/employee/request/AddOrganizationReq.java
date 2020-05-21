package com.employee.request;

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

	private int orgId;
	private String orgName;
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
