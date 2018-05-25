package com.bdqnsxt.oa.component.page;

public class PageInfo {
	
	protected int total_count; // 总记录数
	protected int start;   //起始行
	protected int limit;   //显示数量


	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
