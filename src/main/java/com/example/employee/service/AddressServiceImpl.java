package com.example.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.request.AddAddressReq;
import com.example.employee.model.Addresses;
import com.example.employee.model.Employee;
import com.example.employee.repository.AddressRepository;
import com.example.employee.repository.EmployeeRepository;

/**
 * The class contains all the Address related business logic implementations.
 * The @Component annotation marks this class to contain project specific
 * Address related methods.
 * 
 * @author Sharanya
 *
 */
@Component
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;

	/**
	 * Overridden method to add Employee address details for a particular employee
	 * working under an organization.This invokes {@link AddressRepository
	 * addressRepository} which calls the Jpa Repository to save the address for the
	 * given employee.
	 * 
	 */
	@Override
	public void addAddresses(AddAddressReq addAddressReq, int employeeId) {

		Employee employee = employeeRepository.findByEmployeeId(employeeId);

		Addresses address = new Addresses();
		address.setAddress(addAddressReq.getAddressString());
		address.setCountry(addAddressReq.getCountry());
		address.setId(addAddressReq.getAddressId());
		address.setPincode(addAddressReq.getPincode());
		address.setEmployee(employee);

		addressRepository.save(address);

	}

	/**
	 * Override method to fetch all the addresses for a given pincode. This invokes
	 * {@link AddressRepository addressRepository} which calls the Jpa Repository to
	 * generate jpa query to get the addresses using the pincode as the search
	 * criteria.
	 * 
	 * @param pincode the search criteria for which all the matching addresses need
	 *                to retrieved.
	 * @return all the available addresses for the given pincode.
	 * 
	 */
	@Override
	public List<Addresses> getAddressesByPincode(String pincode) {

		return addressRepository.findByPincode(pincode);
	}

}
