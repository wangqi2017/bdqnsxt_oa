package com.bdqnsxt.oa.exception;

public class SchoolSubClazzExistException extends ServiceException{

    protected String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SchoolSubClazzExistException(){};

    public SchoolSubClazzExistException(String message){
        this.message = message;
    }

}
