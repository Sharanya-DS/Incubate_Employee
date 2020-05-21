package com.example.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.request.AddAddressReq;
import com.example.employee.model.Addresses;

/**
 * The interface is used to loose couple any Address related business logic of
 * the Service classes. The @Servcie annotation marks this interface to cater to
 * any business related functions for the Address. This interface contains
 * project specific methods that need to be implemented by the implementing
 * classes.
 * 
 * @author Sharanya
 *
 */
@Service
public interface AddressService {

	/**
	 * Method to add Employee address details for a particular employee working
	 * under an organization.This invokes {@link AddressRepository
	 * addressRepository} to save the address for the given employee.
	 */
	public void addAddresses(AddAddressReq addAddressReq, int employeeId);

	/**
	 * Method to fetch all the addresses for a given pincode. This invokes
	 * {@link AddressRepository addressRepository} to get the addresses using the
	 * pincode as the search criteria.
	 * 
	 * @param pincode the search criteria for which all the matching addresses need
	 *                to retrieved.
	 * @return all the available addresses for the given pincode.
	 * 
	 */
	public List<Addresses> getAddressesByPincode(String pincode);

}
