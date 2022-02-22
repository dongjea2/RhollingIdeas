package com.team.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.exception.FindException;
import com.team.order.entity.Order;
import com.team.order.repository.OrderRepository;
import com.team.user.entity.Customer;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	
	/**
	 * 주문정보를 추가한다
	 * @param order 주문객체
	 * @throws FindException
	 */
	public void add(Order order) throws FindException {
		repository.save(order);
	}
	
	/**
	 * 주문번호를 통해 주문정보를 불러온다
	 * @param order_no 주문번호
	 * @return 주문정보
	 * @throws FindException
	 */
	public Order findByOrderNo(int order_no) throws FindException {
		try {
			Optional<Order> optP = repository.findById(order_no);
			Order p = new Order();
			if(optP.isPresent()) {
				p = optP.get();
				return p;
			}
			throw new FindException();
		} catch(Exception e) {
			throw new FindException("주문번호에 해당하는 주문정보를 불러오는데 실패했습니다.");
		}
	}
	
	/**
	 * 사용자가 주문한 목록을 반환한다
	 * @param userNo 유저번호
	 * @return 주문한 목록들
	 * @throws FindException
	 */
	public List<Order> myOrderProjects(int userNo) throws FindException{
		Customer c = new Customer();
		c.setUserNo(userNo);
		
		List<Order> orders = new ArrayList<>();
		orders = repository.findByOrderUser(c);
		return orders;
	}
//	
//	/**
//	 * 사용자가 주문한 개수를 반환한다
//	 * @param userNo 유저번호
//	 * @return 주문한 개수
//	 * @throws FindException
//	 */
//	public int countPaymentProjects(int userNo) throws FindException {
//		List<Payment> Payment = new ArrayList<>();
//		Payment = repository.findByUserNo(userNo);
//		int cnt = Payment.size();
//		return cnt;
//	}
//	
//	/**
//	 * 유저의 결제상태가 펀딩실패인 프로젝트를 반환한다 
//	 * @param userNo 유저번호
//	 * @return 펀딩실패 목록들
//	 * @throws FindException
//	 */
//	public List<Payment> failProjects(int userNo) throws FindException{
//		List<Payment> Payments = new ArrayList<>();
//		Payments = repository.findByUserNo(userNo);
//		
//		List<Payment> fail = new ArrayList<>();
//		for(Payment o: Payments) {
//			if(o.getPaymentResult().equals("펀딩실패")) {
//				fail.add(o);
//			}
//		}
//		return fail;
//	}
//	
//	/**
//	 * 유저가 결제한 아직 진행중인 프로젝트를 반환한다 
//	 * @param userNo 유저번호
//	 * @return 진행중 목록들
//	 * @throws FindException
//	 */
//	public List<Payment> ongoingProjects(int userNo) throws FindException{
//		List<Payment> Payments = new ArrayList<>();
//		Payments = repository.findByUserNo(userNo);
//		
//		List<Payment> ongoing = new ArrayList<>();
//		for(Payment o: Payments) {
//			if(o.getPaymentResult().equals("진행중")) {
//				ongoing.add(o);
//			}
//		}
//		return ongoing;
//	}
//	
//	/**
//	 * 유저가 결제한 펀딩성공한(펀딩은 성공, 결제는 x) 프로젝트를 반환한다 
//	 * @param userNo 유저번호
//	 * @return 펀딩성공한 목록들
//	 * @throws FindException
//	 */
//	public List<Payment> successProjects(int userNo) throws FindException{
//		List<Payment> Payments = new ArrayList<>();
//		Payments = repository.findByUserNo(userNo);
//		
//		List<Payment> success = new ArrayList<>();
//		for(Payment o: Payments) {
//			if(o.getPaymentResult().equals("펀딩성공")) {
//				success.add(o);
//			}
//		}
//		return success;
//	}
//	
//	/**
//	 * 유저의 결제상태가 결제완료인 프로젝트를 반환한다 
//	 * @param userNo 유저번호
//	 * @return 결제완료한 목록들
//	 * @throws FindException
//	 */
//	public List<Payment> payedProjects(int userNo) throws FindException{
//		List<Payment> Payments = new ArrayList<>();
//		Payments = repository.findByUserNo(userNo);
//		
//		List<Payment> payed = new ArrayList<>();
//		for(Payment o: Payments) {
//			if(o.getPaymentResult().equals("결제완료")) {
//				payed.add(o);
//			}
//		}
//		return payed;
//	}
}
