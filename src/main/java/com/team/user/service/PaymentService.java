package com.team.user.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.user.entity.Card;
import com.team.user.entity.Customer;
import com.team.user.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository paymentRepo;
	
	@Autowired
	CustomerService customerService;
	
	public List<Card> findByUserNo(int userNo) {
		Customer c = customerService.findByUserNo(userNo);
		List<Card> list = paymentRepo.findByUser(c);
		return list;
	}
	
	public void addCard(Card card) {
		paymentRepo.save(card);
	}
	
	public void modifyCard(Card card) {
		paymentRepo.save(card);
	}
	
	public void deleteCard(Card card) {
		paymentRepo.deleteById(card.getCardNo());
	}

}
