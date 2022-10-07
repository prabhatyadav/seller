package com.eAuction.seller.repository;

import com.eAuction.seller.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    List<Product> findByProductCategoryId(Long productCategoryId);
}
