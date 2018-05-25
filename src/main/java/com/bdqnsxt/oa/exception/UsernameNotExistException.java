package com.bdqnsxt.oa.exception;

public class UsernameNotExistException extends ServiceException{

    protected String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UsernameNotExistException(){};

    public UsernameNotExistException(String message){
        this.message = message;
    }

}
