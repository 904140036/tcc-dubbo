package com.th.service;

import org.mengyun.tcctransaction.api.Compensable;

import com.th.entity.Order;

public interface OrderService {

	@Compensable
	Integer insert(Order order);
}
