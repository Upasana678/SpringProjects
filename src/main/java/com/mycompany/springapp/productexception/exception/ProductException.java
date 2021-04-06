package com.mycompany.springapp.productexception.exception;

public class ProductException extends Exception{

    String errorMessage;
    String errorCode;
    public ProductException()
    {
        super();
    }

    public ProductException(String errorMessage,String errorCode)
    {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
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
