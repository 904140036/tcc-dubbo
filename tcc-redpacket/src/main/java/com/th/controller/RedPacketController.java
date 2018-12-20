package com.th.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.th.entity.Order;
import com.th.service.RedPacketService;

@Controller
public class RedPacketController {

	@Autowired
	private RedPacketService redPacketService;

	@RequestMapping(value = "/createRedPacket", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	@Transactional
	public String createRedPacket() {
		Integer id = redPacketService.insertRedPacket(new Order());

		return "红包插入成功,红包ID " + id;
	}

}
