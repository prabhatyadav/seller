package com.eAuction.seller.controller;

import com.eAuction.seller.dto.ProductDto;
import com.eAuction.seller.model.Product;
import com.eAuction.seller.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public ResponseEntity<Object> addProduct(@RequestBody ProductDto productDto) throws Exception {
        Product newProduct = productService.addProduct(productDto);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/show-bids/{productId} ", method = RequestMethod.GET)
    public Product showProductBid(@PathVariable("productId") Long productId) {
       return  productService.getProductDetail(productId);
    }


    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.POST)
    public void deleteProduct(@PathVariable("productId") String productId) {

    }

}
