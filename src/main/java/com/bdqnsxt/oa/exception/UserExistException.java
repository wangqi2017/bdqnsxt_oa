package com.bdqnsxt.oa.exception;

public class UserExistException extends ServiceException{

    protected String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserExistException(){};

    public UserExistException(String message){
        this.message = message;
    }

}
