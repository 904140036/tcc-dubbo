package com.th.entity;

import java.io.Serializable;

public class Order implements Serializable{

	private static final long serialVersionUID = 4474290190954017721L;

	private Integer orderId;
	private String name;
	private Integer status;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
