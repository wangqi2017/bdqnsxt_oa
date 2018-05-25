package com.bdqnsxt.oa.exception;

public class SchoolSubUserExistException extends ServiceException{

    protected String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SchoolSubUserExistException(){};

    public SchoolSubUserExistException(String message){
        this.message = message;
    }

}
