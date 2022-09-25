package com.eAuction.seller.dto;


public class InvalidPersonDetailException extends Exception {
    public InvalidPersonDetailException(){
        super();
    }
    public InvalidPersonDetailException(String message){
         super(message);
    }
}
