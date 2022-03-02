package com.team.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.team.user.entity.Address;
import com.team.user.entity.Customer;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
	
	public List<Address> findByUser(Customer c);
	public Address findByAddressNo(int addressNo);
}
