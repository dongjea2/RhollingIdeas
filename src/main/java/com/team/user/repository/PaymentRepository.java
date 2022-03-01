package com.team.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.team.user.entity.Card;
import com.team.user.entity.Customer;

@Repository
public interface PaymentRepository extends CrudRepository<Card, Integer> {

	public List<Card> findByUser(Customer c);
	public Card findByCardNum(String cardNum);
}
