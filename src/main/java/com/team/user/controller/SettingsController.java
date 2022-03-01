package com.team.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.user.dto.AccountSetDTO;
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
	public Object updateAccount(@RequestBody AccountSetDTO acc) {
		Customer customer = customerService.findByUserNo(acc.getUserNo());
		Map<String, Object> returnMap = new HashMap<>();
		//빈문자열 또는 타입에러 프론트에서 처리
		if(acc.getUserImage() != null) {
			customer.setUserImage(acc.getUserImage());
		}
		if(acc.getUserName() != null) {
			customer.setUserName(acc.getUserName());
		}
		if(acc.getUserIntroduction() != null) {
			customer.setUserIntroduction(acc.getUserIntroduction());
		}
		if(acc.getUserId() != null) {
			//id중복확인 - 중복시 {status: 0}으로 응답
			if(customerService.findByUserId(acc.getUserId()) != null) {
				returnMap.put("status", 0);
				return returnMap;
			} else {
				customer.setUserId(acc.getUserId());
			}	
		}
		if(acc.getUserPhone() != null) {
			customer.setUserPhone(acc.getUserPhone());
		}
		if(acc.getUserPwd() != null) {
			System.out.println(acc.getUserPwd());
			System.out.println(customer.getUserPwd());
			System.out.println(acc.getUpdatePwd());
			if(acc.getUserPwd().equals(customer.getUserPwd())) {
				customer.setUserPwd(acc.getUpdatePwd());
			} else {
				//기존 비밀번호 확인 - 불일치 {status: 0}으로 응답
				returnMap.put("status", 0);
				return returnMap;
			}
		}
		customerService.profileSet(customer);
		returnMap.put("status", 1);
		return returnMap;
	}
	
	@PutMapping("/withdrawal")
	public void Withdrawal(@RequestBody Customer c) {
		Customer customer = customerService.findByUserNo(c.getUserNo());
		customer.setUserStatus("0");
		customerService.profileSet(customer);
	}
	
	@PostMapping("/payment")
	public Object showPayment(@RequestBody Customer customer) {
		List<Card> list = paymentService.findByUserNo(customer.getUserNo());
		List<Object> cardList = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			Map<String, Object> cardMap = new HashMap<>();
			cardMap.put("cardNo", list.get(i).getCardNo());
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
	
	@PutMapping("/payment")
	public void modifyPayment(@RequestBody Card card) {
		paymentService.modifyCard(card);
	}
	
	@DeleteMapping("/payment")
	public void deletePayment(@RequestBody Card card) {
		paymentService.deleteCard(card);
	}

}
