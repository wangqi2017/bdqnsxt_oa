package com.bdqnsxt.oa.exception;

public class ClazzExistException extends ServiceException{

    protected String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ClazzExistException(){};

    public ClazzExistException(String message){
        this.message = message;
    }

}
