package com.mycompany.springapp.productapp.exception;
//This exception is thrown when a product is there in the database and the product is being created again.
public class ProductCreationException extends Exception{

    String errorMessage;
    String errorCode;
    public ProductCreationException()
    {
        super();
    }

    public ProductCreationException(String errorMessage,String errorCode)
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
