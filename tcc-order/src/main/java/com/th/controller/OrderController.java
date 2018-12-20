package com.th.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.th.entity.Order;
import com.th.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	// @Autowired
	// private RedPacketService redPacketService;

	@RequestMapping(value = "/createOrder", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	//@Transactional
	public String createOrder() {
		Order order = new Order();
		Integer id = orderService.insert(order);

		return "订单创建成功,订单ID: " + id;
	}

}
