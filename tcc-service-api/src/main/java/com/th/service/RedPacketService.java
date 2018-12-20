package com.th.service;

import org.mengyun.tcctransaction.api.Compensable;

import com.th.entity.Order;

public interface RedPacketService {

	/**
	 * 新增红包接口
	 */
	@Compensable
	Integer insertRedPacket(Order order);

}
