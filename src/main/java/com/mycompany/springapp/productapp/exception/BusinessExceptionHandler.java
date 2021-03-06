package com.mycompany.springapp.productapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleBusinessException(BusinessException be, WebRequest req){
        ResponseEntity<String>  res = new ResponseEntity<>(be.getErrorCode()+" - "+be.getErrorMessage(), HttpStatus.CONFLICT);
        return res;
    }

    @ExceptionHandler(ProductCreationException.class)
    public ResponseEntity<String> handleProductCreationException(ProductCreationException pce,WebRequest req)
    {
        ResponseEntity<String> res = new ResponseEntity<>(pce.getErrorMessage()+"-"+pce.getErrorCode(),HttpStatus.CONFLICT);
        return res;
    }


}
