package com.team.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.user.entity.Address;
import com.team.user.entity.Card;
import com.team.user.entity.Customer;
import com.team.user.service.AddressService;
import com.team.user.service.CustomerService;
import com.team.user.service.PaymentService;

@RestController
@RequestMapping("/profile")
public class SettingsController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private AddressService addrService;
	
	@PostMapping("/account")
	public Object showAccount(@RequestBody Customer customer) {
		Customer c = customerService.findByUserNo(customer.getUserNo());
		Map<String, Object> returnMap = new HashMap<>();
		//pwd등 민감한 정보 제외. 필요한 정보만 응답
		returnMap.put("image", c.getUserImage());
		returnMap.put("name", c.getUserName());
		returnMap.put("intro", c.getUserIntroduction());
		returnMap.put("email", c.getUserId());
		returnMap.put("phone", c.getUserPhone());
		return returnMap;
	}
	
	@PutMapping("/account")
	public void updateAccount(@RequestBody Customer c) {
		Customer customer = customerService.findByUserNo(c.getUserNo());
		if(c.getUserImage() != null) {
			customer.setUserImage(c.getUserImage());
		}
		if(c.getUserName() != null) {
			customer.setUserName(c.getUserName());
		}
		if(c.getUserIntroduction() != null) {
			customer.setUserIntroduction(c.getUserIntroduction());
		}
		if(c.getUserId() != null) {
			customer.setUserId(c.getUserId());
		}
		if(c.getUserPhone() != null) {
			customer.setUserPhone(c.getUserPhone());
		}
		if(c.getUserPwd() != null) {
			customer.setUserPwd(c.getUserPwd());
		}
		customerService.profileSet(customer);
	}
	
	@PostMapping("/payment")
	public Object showPayment(@RequestBody Customer customer) {
		List<Card> list = paymentService.findByUserNo(customer.getUserNo());
		List<Object> cardList = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			Map<String, Object> cardMap = new HashMap<>();
			cardMap.put("cardNum", list.get(i).getCardNum());
			cardMap.put("validDate", list.get(i).getCardValidDate());
			cardMap.put("ownerBirth", list.get(i).getCardOwnerBirth());
			cardMap.put("isDefault", list.get(i).getDefaultCard());
			cardList.add(i, cardMap);
		}
		return cardList;
	}
	
	@PostMapping("/address")
	public Object showAddress(@RequestBody Customer customer) {
		List<Address> list = addrService.findByUserNo(customer.getUserNo());
		List<Object> addrList = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			Map<String, Object> addrMap = new HashMap<>();
			addrMap.put("addressNo", list.get(i).getAddressNo());
			addrMap.put("name", list.get(i).getReceiverName());
			addrMap.put("zipcode", list.get(i).getReceiverZipcode());
			addrMap.put("address", list.get(i).getReceiverAddress());
			addrMap.put("addressDetail", list.get(i).getReceiverAddressDetailed());
			addrMap.put("phone", list.get(i).getReceiverPhone());
			addrMap.put("isDefault", list.get(i).getDefaultAddress());
			addrList.add(i, addrMap);
		}
		return addrList;
	}
	
	@PostMapping("/addaddress")
	public void addAddress(@RequestBody Address address) {
		
	}
	
	@PostMapping("/addpayment")
	public void addPayment(@RequestBody Card card) {
		paymentService.addCard(card);
	}

}
