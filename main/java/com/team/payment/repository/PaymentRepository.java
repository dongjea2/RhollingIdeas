package com.team.payment.repository;

import org.springframework.data.repository.CrudRepository;

import com.team.payment.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
