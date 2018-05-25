package com.bdqnsxt.oa.exception;

public class ServiceException extends Exception{

    protected String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ServiceException(){}

    public ServiceException(String message){
        this.message = message;
    }
}
