package com.bdqnsxt.oa.component.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bdqnsxt.oa.component.page.PageInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;



/*
 * 查询条件类
 */
public class BaseQuery {
	/**
	 * 查询表达式的集合
	 */
	@JsonIgnore 
	private List<Expression> conditions = new ArrayList<Expression>();
	
	/**
	 * 排序字段的集合
	 */
	@JsonIgnore 
	private List<Order> orders =  new ArrayList<Order>();


	private PageInfo page = new PageInfo();

	public PageInfo getPage() {
		return page;
	}

	public void setPage(PageInfo page) {
		this.page = page;
	}



/*

	private Map<String,Object> queryParams = new HashMap<String,Object>();

	public Map<String, Object> getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(Map<String, Object> queryParams) {
		this.queryParams = queryParams;
	}
	*/

	/**
	 * 添加一条查询表达式
	 * @param name
	 * @param value
	 * @return
	 */
	public BaseQuery putCondition(String name,Object value){
		
		return putCondition(name,"=",value);
	}
	
	/**
	 * 添加一条查询表达式
	 * @param name
	 * @param op
	 * @param value
	 * @return
	 */
	public BaseQuery putCondition(String name,String op,Object value){
		Expression exp = new Expression(name,op,value);
		
		return putCondition(exp);
	}
	
    /**
     * 添加一条查询表达式
     * @param exp
     * @return
     */
	public BaseQuery putCondition(Expression exp){
		this.conditions.add(exp);
		return this;
	}
	
	/**
	 * 清除所有的查询表达式
	 * @return
	 */
	public BaseQuery clearConditions(){
		this.conditions.clear();
		return this;
	}
	
	/**
	 * 添加一个排序字段
	 * @param name
	 * @return
	 */
	public BaseQuery addOrders(String name){
		this.orders.add(new Order(name));
		return this;
	}
	
	/**
	 * 添加一个排序字段
	 * @param name
	 * @param order
	 * @return
	 */
	public BaseQuery addOrders(String name,String order){
		this.orders.add(new Order(name,order));
		return this;
	}
	
	/**
	 * 清除所有的排序条件
	 * @return
	 */
	public BaseQuery clearOrders(){
		this.orders.clear();
		return this;
	}
	
	
	/**
	 * 下面是getters 和 setters  
	 */
	public List<Expression> getConditions() {
		return conditions;
	}

	public void setConditions(List<Expression> conditions) {
		this.conditions = conditions;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	
	
}
