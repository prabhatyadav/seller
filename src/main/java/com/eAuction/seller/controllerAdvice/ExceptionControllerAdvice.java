package com.eAuction.seller.controllerAdvice;

import com.eAuction.seller.dto.ExceptionMessage;
import com.eAuction.seller.dto.InvalidPersonDetailException;
import com.eAuction.seller.exception.InvalidProductDetailException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = InvalidProductDetailException.class)
    public ResponseEntity<Object> invalidProductDetailHandler(InvalidProductDetailException exception) {
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = InvalidPersonDetailException.class)
    public ResponseEntity<Object> invalidPersonDetailHandler(InvalidProductDetailException exception) {
        return new ResponseEntity<>("Person Details incorrect found" + exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }
}
