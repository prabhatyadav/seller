package com.eAuction.seller.service;

import com.eAuction.seller.dto.ProductDto;
import com.eAuction.seller.exception.InvalidProductDetailException;
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
          return true;
     }

     public void deleteProduct(String productId){}
     public void showBidsForProduct(String productId){}
}
