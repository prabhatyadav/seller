package com.eAuction.seller.feign;

import com.eAuction.seller.dto.ProductBidDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name= "productBidClient" , url = "${buyer-microservice.url}")
public interface ProductBidFeignClient {

    @GetMapping(value= "/bids/{productId}")
    public List<ProductBidDto> getAllBidsForProductId(@PathVariable(name= "productId") Long productId);


}
