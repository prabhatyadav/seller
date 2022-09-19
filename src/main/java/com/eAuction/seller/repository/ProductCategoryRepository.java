package com.eAuction.seller.repository;

import com.eAuction.seller.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    ProductCategory findByNameIgnoreCase(String name);
}
