package com.team.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.user.entity.Address;
import com.team.user.entity.Customer;
import com.team.user.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addrRepo;
	
	@Autowired
	CustomerService customerService;
	
	public List<Address> findByUserNo(int userNo) {
		Customer c = customerService.findByUserNo(userNo);
		List<Address> list = addrRepo.findByUser(c);
		return list;
	}
	
	public void addAddress(Address address) {
		addrRepo.save(address);
	}
	
	public void modifyAddress(Address address) {
		addrRepo.save(address);
	}
	
	public void deleteAddress(Address address) {
		addrRepo.deleteById(address.getAddressNo());
	}
}
