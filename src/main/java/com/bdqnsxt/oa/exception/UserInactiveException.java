package com.bdqnsxt.oa.exception;

public class UserInactiveException extends ServiceException{

    protected String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserInactiveException(){};

    public UserInactiveException(String message){
        this.message = message;
    }

}
