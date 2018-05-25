package com.bdqnsxt.oa.exception;

public class SchoolExistException extends ServiceException{

    protected String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SchoolExistException(){};

    public SchoolExistException(String message){
        this.message = message;
    }

}
