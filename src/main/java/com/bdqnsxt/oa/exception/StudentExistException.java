package com.bdqnsxt.oa.exception;

public class StudentExistException extends ServiceException{

    protected String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public StudentExistException(){};

    public StudentExistException(String message){
        this.message = message;
    }

}
