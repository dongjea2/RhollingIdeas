package com.team.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.exception.FindException;
import com.team.order.entity.Order;
import com.team.order.entity.OrderDTO;
import com.team.order.repository.OrderRepository;
import com.team.user.entity.Card;
import com.team.user.entity.Customer;
import com.team.user.repository.AddressRepository;
import com.team.user.repository.PaymentRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	@Autowired
	private PaymentRepository paymentRepository; 
	@Autowired
	private AddressRepository addressRepository;
	/**
	 * 주문정보를 추가한다
	 * @param order 주문객체
	 * @throws FindException
	 */
	public void add(Order order) throws FindException {
		//1.카드 번호 검증(주문자 자신의 카드가 맞는지)
		Card c = paymentRepository.findByCardNum(order.getCard().getCardNum());
		if(c.getUser().getUserNo() != order.getOrderUser().getUserNo()) {
			throw new FindException();
		}
		order.setCard(c);
		
		repository.save(order);
	}
	
	/**
	 * 주문번호를 통해 주문정보를 불러온다
	 * @param order_no 주문번호
	 * @return 주문정보
	 */
	public Order findByOrderNo(int order_no) {
		Optional<Order> optP = repository.findById(order_no);
		Order p = new Order();
		p = optP.get();
		return p;
	}
	
	/**
	 * 사용자가 주문한 목록을 반환한다
	 * @param userNo 유저번호
	 * @return 주문한 목록들
	 */
	public List<OrderDTO> myOrderProjects(Customer c){
		List<OrderDTO> list = new ArrayList<>();
		List<Order> orders = repository.findByOrderUser(c);
		for(Order o : orders) {
			OrderDTO dto = new OrderDTO();
			dto.entityToDTO(o);
			list.add(dto);
		}
		return list;
	}
}
