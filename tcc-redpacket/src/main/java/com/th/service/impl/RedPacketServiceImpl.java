package com.th.service.impl;

import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.dubbo.context.DubboTransactionContextEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.th.dao.RedPacketDao;
import com.th.entity.Order;
import com.th.entity.RedPacket;
import com.th.service.RedPacketService;

@Service("redPacketServiceImpl")
public class RedPacketServiceImpl implements RedPacketService {

	@Autowired
	private RedPacketDao redPacketDao;

	@Override
	@Compensable(confirmMethod = "confirmInsertRedPacket", cancelMethod = "cancelInsertRedPacket", transactionContextEditor = DubboTransactionContextEditor.class)
	public Integer insertRedPacket(Order order) {
		RedPacket redPacket = new RedPacket();
		redPacket.setOrderId(1);
		redPacket.setNum(1);
		redPacket.setId(1);
		redPacket.setStatus(-1);

		System.out.println("redPacketInsert");

		redPacketDao.insert(redPacket);

		return redPacket.getOrderId();
	}

	@Transactional
	public void confirmInsertRedPacket(Order order) {
		System.out.println("confirmRedPacketInsert");

		RedPacket redPacket = new RedPacket();
		redPacket.setOrderId(1);
		redPacket.setNum(1);
		redPacket.setId(1);
		redPacket.setStatus(0);

		redPacketDao.update(redPacket);

	}

	@Transactional
	public void cancelInsertRedPacket(Order order) {
		System.out.println("cancelRedPacketInsert");

		RedPacket redPacket = new RedPacket();
		redPacket.setOrderId(1);
		redPacket.setNum(1);
		redPacket.setId(1);
		redPacket.setStatus(1);

		redPacketDao.delete(redPacket);
	}

}
