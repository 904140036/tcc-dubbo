package com.th.dao;

import org.apache.ibatis.annotations.Mapper;

import com.th.entity.Order;

@Mapper
public interface OrderDao {

	Integer insert(Order order);

	int update(Order order);

	int delete(Order order);
}
