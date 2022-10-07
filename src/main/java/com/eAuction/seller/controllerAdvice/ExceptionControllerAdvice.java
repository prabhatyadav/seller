package com.eAuction.seller.controllerAdvice;

import com.eAuction.seller.dto.ExceptionMessage;
import com.eAuction.seller.dto.InvalidPersonDetailException;
import com.eAuction.seller.exception.AllReadyExistDataException;
import com.eAuction.seller.exception.InvalidProductDetailException;
import com.eAuction.seller.exception.PersonNotFoundException;
import com.eAuction.seller.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = InvalidProductDetailException.class)
    public ResponseEntity<ErrorResponse> invalidProductDetailHandler(InvalidProductDetailException exception) {
        return new ResponseEntity<>(new ErrorResponse("Product Details Invalid "+exception.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = InvalidPersonDetailException.class)
    public ResponseEntity<ErrorResponse> invalidPersonDetailHandler(InvalidPersonDetailException exception) {
        return new ResponseEntity(new ErrorResponse("Person Details Invalid "+ exception.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = PersonNotFoundException.class)
    public ResponseEntity<ErrorResponse> personNotFoundExceptionHandler(PersonNotFoundException exception) {
        return new ResponseEntity<>(new ErrorResponse("Person Details Not found ") , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = AllReadyExistDataException.class)
    public ResponseEntity<ErrorResponse> allReadyExistDataExceptionHandler(AllReadyExistDataException exception) {
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()) , HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
