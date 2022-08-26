package com.csi.execption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.*;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class OverAllExecption {

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String , String>> handelMethodArgumentNotValidException(MethodArgumentNotValidException e){

        Map<String , String > excpetionMap = new HashMap<String , String>();
        e.getBindingResult().getAllErrors().forEach((error )-> {
            String filed = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            excpetionMap.put(filed, message);
        });
        return new ResponseEntity<Map<String , String>>(excpetionMap, HttpStatus.BAD_REQUEST);
    }

}
