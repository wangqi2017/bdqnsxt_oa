package com.bdqnsxt.oa.exception;

public class SchoolSubDepartmentExistException extends ServiceException{

    protected String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SchoolSubDepartmentExistException(){};

    public SchoolSubDepartmentExistException(String message){
        this.message = message;
    }

}
