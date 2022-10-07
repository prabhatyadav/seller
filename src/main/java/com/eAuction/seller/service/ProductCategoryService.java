package com.eAuction.seller.service;

import com.eAuction.seller.exception.AllReadyExistDataException;
import com.eAuction.seller.model.ProductCategory;
import com.eAuction.seller.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategory addProductCategory(ProductCategory productCategory) {
        ProductCategory savedProductCategory;
        ProductCategory foundProductCategoryResult = productCategoryRepository.findByNameIgnoreCase(productCategory.getName());
        if (foundProductCategoryResult != null) {
            throw new AllReadyExistDataException("Product Category :" + productCategory.getName() + "Already Exist");
        } else {
            savedProductCategory = productCategoryRepository.save(productCategory);
        }
        return savedProductCategory;
    }

}
