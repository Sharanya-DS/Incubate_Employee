package com.employee.request;

/**
 * 
 * This is the Request POJO for the Address entity which aids with any add
 * request i.e., add any address for an employee.
 * 
 * @author Sharanya
 *
 */
public class AddAddressReq {

	private int addressId;
	private String addressString;
	private String country;
	private String pincode;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressString() {
		return addressString;
	}

	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
