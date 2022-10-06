package com.eAuction.seller.exception;

public class PersonNotFoundException extends  RuntimeException{
    private String message;

     public PersonNotFoundException(){
         super();
     }

     public PersonNotFoundException(String message){
         super(message);
     }

}
