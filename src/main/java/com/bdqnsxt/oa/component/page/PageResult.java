package com.bdqnsxt.oa.component.page;

public class PageResult {
    private Object result;
    private long total;

    public PageResult() {
    }

    public PageResult(Object result, long total) {
        this.result = result;
        this.total = total;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
