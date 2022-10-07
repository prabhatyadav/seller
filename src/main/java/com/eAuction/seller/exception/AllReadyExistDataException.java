package com.eAuction.seller.exception;

public class AllReadyExistDataException extends  RuntimeException{
    private String message;

     public AllReadyExistDataException(){
         super();
     }

     public AllReadyExistDataException(String message){
         super(message);
     }

}
