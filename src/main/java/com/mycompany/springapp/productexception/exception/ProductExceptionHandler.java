package com.mycompany.springapp.productexception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<String> handleProductException(ProductException pe, WebRequest weq)
    {
        ResponseEntity<String> res = new ResponseEntity<>(pe.getErrorCode()+"--"+pe.getErrorMessage(), HttpStatus.CONFLICT);
        return res;
    }
}
