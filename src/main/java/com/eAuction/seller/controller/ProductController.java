package com.eAuction.seller.controller;

import com.eAuction.seller.dto.ProductBidDto;
import com.eAuction.seller.dto.ProductDto;
import com.eAuction.seller.model.Product;
import com.eAuction.seller.model.ProductCategory;
import com.eAuction.seller.service.ProductCategoryService;
import com.eAuction.seller.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
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
        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.add("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(newProduct, respHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProduct(@PathVariable long productId) throws Exception {
        Product foundProduct = productService.getProductDetail(productId);
        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.add("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(foundProduct, respHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/show-bids/{productId}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductBidDto>> showProductBid(@PathVariable("productId") Long productId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");

        List<ProductBidDto> bidList = productService.showBidsForProduct(productId);
        if(bidList==null ||bidList.size()==0){
            return ResponseEntity.notFound().headers(headers).build();
        }
        return ResponseEntity.ok().headers(headers).body(bidList);
    }

    @RequestMapping(value = "/show-product", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> showProduct(@Nullable @RequestParam("offset") int offset,
                                                     @Nullable @RequestParam("limit") int limit) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");

        return ResponseEntity.ok().headers(headers).body(productService.getAllProductDetail(offset, limit));
    }

    /*Not a requirement*/
   /* @RequestMapping(value = "/show-product/{productCategoryId} ", method = RequestMethod.GET)
    public List<Product> showProductByProductCategory(@PathVariable("productCategoryId") Long productCategoryId) {
        return productService.getAllProductDetail(productCategoryId);
    }
*/

    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.POST)
    public ResponseEntity<String> deleteProduct(@PathVariable("productId") Long productId) {
        Product deletedProduct = productService.deleteProduct(productId);

        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.add("Access-Control-Allow-Origin", "*");
        if (deletedProduct.getIsDeleted()) {
            return new ResponseEntity<String>("Deleted ProductId : " + productId, respHeaders, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Not Deleted ProductId : " + productId, respHeaders, HttpStatus.NOT_MODIFIED);
        }

    }

    @RequestMapping(value = "/add-product-category", method = RequestMethod.POST)
    public ProductCategory addProductCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryService.addProductCategory(productCategory);
    }

}
