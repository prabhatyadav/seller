package com.eAuction.seller.dto;


public class InvalidPersonDetailException extends RuntimeException {
    public InvalidPersonDetailException() {
        super();
    }

    public InvalidPersonDetailException(String message) {
        super(message);
    }
}
