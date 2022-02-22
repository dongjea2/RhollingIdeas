package com.team.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.team.user.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	/**
	 * 회원번호에 해당하는 고객을 반환
	 * @param userNo
	 * @return
	 */
	public Customer findByUserNo(int userNo);

	/**
	 * 아이디에 해당하는 고객을 반환
	 * @param userId
	 * @return
	 */
	public Customer findByUserId(String userId);
}