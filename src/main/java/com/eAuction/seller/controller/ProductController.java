package com.eAuction.seller.controller;

import com.eAuction.seller.dto.ProductDto;
import com.eAuction.seller.exception.InvalidProductDetailException;
import com.eAuction.seller.model.Product;
import com.eAuction.seller.model.ProductCategory;
import com.eAuction.seller.repository.ProductCategoryRepository;
import com.eAuction.seller.service.ProductCategoryService;
import com.eAuction.seller.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/e-auction/api/v1/seller")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public ResponseEntity<Object> addProduct(@RequestBody ProductDto productDto) throws Exception {
        Product newProduct = productService.addProduct(productDto);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProduct(@PathVariable long productId) throws Exception {
        Product foundProduct = productService.getProductDetail(productId);
        return new ResponseEntity<>(foundProduct, HttpStatus.OK);
    }

    @RequestMapping(value = "/show-bids/{productId} ", method = RequestMethod.GET)
    public Product showProductBid(@PathVariable("productId") Long productId) {
        return productService.getProductDetail(productId);
    }

    /*Not a requirement*/
    @RequestMapping(value = "/show-product/{productCategoryId} ", method = RequestMethod.GET)
    public List<Product> showProductByProductCategory(@PathVariable("productCategoryId") Long productCategoryId) {
        return productService.getAllProductDetail(productCategoryId);
    }


    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.POST)
    public ResponseEntity<String> deleteProduct(@PathVariable("productId") Long productId) {
        Product deletedProduct = productService.deleteProduct(productId);
        if (deletedProduct.getIsDeleted()) {
            return new ResponseEntity<String>("Deleted ProductId : " + productId, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Not Deleted ProductId : " + productId, HttpStatus.NOT_MODIFIED);
        }

    }

    @RequestMapping(value = "/add-product-category", method = RequestMethod.POST)
    public ProductCategory addProductCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryService.addProductCategory(productCategory);
    }

}
