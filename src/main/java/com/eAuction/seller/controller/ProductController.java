package com.eAuction.seller.controller;

import com.eAuction.seller.dto.ProductDto;
import com.eAuction.seller.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value="/add-product", method= RequestMethod.POST)
    public void addProduct(@RequestBody ProductDto productDto){
        productService.addProduct(productDto);
    }

    @RequestMapping(value="/show-bids/{productId} ", method= RequestMethod.GET)
    public void showProductBid(@PathVariable("productId") String productId){

    }


    @RequestMapping(value="/delete/{productId}", method= RequestMethod.POST)
    public void deleteProduct(@PathVariable("productId") String productId){

    }

}
