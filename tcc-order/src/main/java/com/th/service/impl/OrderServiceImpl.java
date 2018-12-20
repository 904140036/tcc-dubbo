package com.th.service.impl;

import org.mengyun.tcctransaction.api.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.th.dao.OrderDao;
import com.th.entity.Order;
import com.th.service.OrderService;
import com.th.service.RedPacketService;

@Service
@Component
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private RedPacketService redPacketService;

	@Override
	@Compensable(confirmMethod = "confirmInsert", cancelMethod = "cancelInsert", asyncConfirm = true)
	@Transactional
	public Integer insert(Order order) {
		Order orde = new Order();
		orde.setName("电脑");
		orde.setOrderId(1);
		orde.setStatus(-1);

		orderDao.insert(orde);

		redPacketService.insertRedPacket(orde);

		//int i = 1 / 0;

		return order.getOrderId();
	}

	public void confirmInsert(Order order) {
		System.out.println("confirmOrderInsert");

		Order orde = new Order();
		orde.setName("电脑");
		orde.setOrderId(1);
		orde.setStatus(0);

		orderDao.update(orde);

	}

	public void cancelInsert(Order order) {
		System.out.println("cancelOrderInsert");

		Order orde = new Order();
		orde.setName("电脑");
		orde.setOrderId(1);
		orde.setStatus(1);

		orderDao.delete(orde);

	}

}
