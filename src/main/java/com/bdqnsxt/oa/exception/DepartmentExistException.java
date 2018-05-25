package com.bdqnsxt.oa.exception;

public class DepartmentExistException extends ServiceException{

    protected String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DepartmentExistException(){};

    public DepartmentExistException(String message){
        this.message = message;
    }

}
