package com.bdqnsxt.oa.exception;

public class PasswordErrorException extends ServiceException{

    protected String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PasswordErrorException(){};

    public PasswordErrorException(String message){
        this.message = message;
    }

}
