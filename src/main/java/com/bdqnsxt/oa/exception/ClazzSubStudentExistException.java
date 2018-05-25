package com.bdqnsxt.oa.exception;

public class ClazzSubStudentExistException extends ServiceException{

    protected String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ClazzSubStudentExistException(){};

    public ClazzSubStudentExistException(String message){
        this.message = message;
    }

}
