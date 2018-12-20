package com.th.dao;

import org.apache.ibatis.annotations.Mapper;

import com.th.entity.RedPacket;

@Mapper
public interface RedPacketDao {
	Integer insert(RedPacket packet);

	int update(RedPacket packet);

	int delete(RedPacket packet);
}