package com.bdqnsxt.oa.component.db;

/*
 * 排序条件
 */
public class Order {
	private String name;

	private String order;

	public Order() {
	}

	public Order(String name) {
		this.name = name;
		this.order = "asc";
	}

	public Order(String name, String order) {
		this.name = name;
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
}
