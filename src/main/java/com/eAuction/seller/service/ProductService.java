package com.eAuction.seller.service;

import com.eAuction.seller.constant.ProductConstant;
import com.eAuction.seller.dto.ProductDto;
import com.eAuction.seller.exception.InvalidProductDetailException;
import com.eAuction.seller.model.Person;
import com.eAuction.seller.model.ValidationResult;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
     public void addProduct(ProductDto productDto){
         if( validate(productDto)){

         }else{
              new InvalidProductDetailException();
         }
     }

     private boolean validate(ProductDto productDto) {
        // Validations:
        //  1. Product Name is not null, min 5 and max 30 characters.
         if(productDto.getName().length() < ProductConstant.MIN_ALLOWED || productDto.getName().length() >ProductConstant.MAX_ALLOWED){

         }//  2. firstName is not null, min 5 and max 30 characters.
         else if(productDto.().length() < ProductConstant.MIN_ALLOWED || productDto.getName().length() >ProductConstant.MAX_ALLOWED){

         }
        //  2. firstName is not null, min 5 and max 30 characters.
        //  3. lastName is not null, min 3 and max 25 characters.
        //  4. email is not null, and it should be valid email pattern, containing a single @.
        //  5. mobile is not null, min 10 and max 10 character and all must be numeric
          return true;
     }

    private ValidationResult validate(Person person) {
        // Validations:
        // //  2. firstName is not null, min 5 and max 30 characters.
        if(person.getFirstName().length() < ProductConstant.MIN_ALLOWED
                || person.getFirstName().length() >ProductConstant.MAX_ALLOWED){
            ValidationResult.builder().isValidate(false).fieldName("first name")
                    .errorMessage("min 5 and max 30 characters").build();
        }//  3. lastName is not null, min 3 and max 25 characters.
        else if(person.getLastName().length() < ProductConstant.L_NAME_MAX_ALLOWED
                || person.getLastName().length() >ProductConstant.L_NAME_MAX_ALLOWED){
            ValidationResult.builder().isValidate(false).fieldName("last name")
                    .errorMessage("min 5 and max 30 characters").build();

        }
        //  4. email is not null, and it should be valid email pattern, containing a single @.
        else if(person.getEmail()==null || !person.getEmail().contains("@")){

        }
        //  5. mobile is not null, min 10 and max 10 character and all must be numeric
        else if(person.getPhone()==null ||person.getPhone().length()!=10){


        }
        return ValidationResult.builder().isValidate(true).build();
    }

     public void deleteProduct(String productId){}
     public void showBidsForProduct(String productId){}
}
