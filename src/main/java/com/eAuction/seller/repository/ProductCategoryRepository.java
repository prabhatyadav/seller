package com.eAuction.seller.repository;

import com.eAuction.seller.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    ProductCategory findByNameIgnoreCase(String name);
}
