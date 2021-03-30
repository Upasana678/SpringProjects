package com.mycompany.springapp.productapp.exception;

public class BusinessException extends Exception{

    private String errorMessage;
    private String errorCode;
    public BusinessException()
    {
        super();
    }

    public BusinessException(String errorMessage,String errorCode)
    {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
