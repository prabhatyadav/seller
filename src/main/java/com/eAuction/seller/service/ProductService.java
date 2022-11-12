package com.eAuction.seller.service;

import com.eAuction.seller.constant.ProductConstant;
import com.eAuction.seller.dto.InvalidPersonDetailException;
import com.eAuction.seller.dto.ProductBidDto;
import com.eAuction.seller.dto.ProductDto;
import com.eAuction.seller.exception.InvalidProductDetailException;
import com.eAuction.seller.feign.ProductBidFeignClient;
import com.eAuction.seller.model.Person;
import com.eAuction.seller.model.PersonTypeEnum;
import com.eAuction.seller.model.Product;
import com.eAuction.seller.model.ValidationResult;
import com.eAuction.seller.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    PersonService personService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductBidFeignClient productBidFeignClient;

    ModelMapper modelMapper = new ModelMapper();

    public Product addProduct(ProductDto productDto) throws Exception {
        Product savedProduct = new Product();
        if (validate(productDto)) {
            //Product is already there or not ? A Seller can not put same product for multiple time.

            //Person who is trying to add the Product is present seller or not.
            if (productDto.getPersonEmailId() != null &&
                    productDto.getPhoneNumber() != null &&
                    productDto.getPersonType() == PersonTypeEnum.SELLER) {
                Person searchedPerson = personService
                        .findPerson(productDto.getPersonEmailId(), productDto.getPhoneNumber(), productDto.getPersonType());
                if (searchedPerson != null) {
                    // Product Category is present or not
                    if (productDto.getCategory() == null) {
                        throw new InvalidProductDetailException("Product should  Be follow in One of provided category");
                        //Stage 2: Create the Category
                    }
                    // convert  the Dto to Model
                    Product newProduct = modelMapper.map(productDto, Product.class);
                    newProduct.setIsDeleted(false);
                    newProduct.setSeller(searchedPerson);

                    savedProduct = productRepository.save(newProduct);
                } else {
                    //Stage 2: create the seller account for the person. personService.Save()
                    throw new InvalidPersonDetailException("Seller Not Found with Provided email and phone number");
                }

            } else {
                throw new InvalidProductDetailException("Only Valid Seller Allowed");
            }

        } else {
            throw new InvalidProductDetailException("Invalid data");
        }
        return savedProduct;
    }

    private boolean validate(ProductDto productDto) {
        // Validations:
        //  1. Product Name is not null, min 5 and max 30 characters.
        if (productDto == null) {
            throw new InvalidProductDetailException("Product DTO can not be Null");
        } else if (productDto.getName() == null ||
                productDto.getName().length() < ProductConstant.MIN_ALLOWED ||
                productDto.getName().length() > ProductConstant.MAX_ALLOWED) {
            throw new InvalidProductDetailException("Name should be not null, min 5 and max 30 characters");
        }
        return true;
    }

    private ValidationResult validate(Person person) {
        // Validations:
        if (person == null) {
            return ValidationResult.builder().isValidate(false).fieldName("Person")
                    .errorMessage("can not be null").build();
        }
        // //  2. firstName is not null, min 5 and max 30 characters.
        if (person.getFirstName().length() < ProductConstant.MIN_ALLOWED
                || person.getFirstName().length() > ProductConstant.MAX_ALLOWED) {
            return ValidationResult.builder().isValidate(false).fieldName("first name")
                    .errorMessage("min 5 and max 30 characters").build();
        }//  3. lastName is not null, min 3 and max 25 characters.
        else if (person.getLastName().length() < ProductConstant.L_NAME_MAX_ALLOWED
                || person.getLastName().length() > ProductConstant.L_NAME_MAX_ALLOWED) {
            return ValidationResult.builder().isValidate(false).fieldName("last name")
                    .errorMessage("min 5 and max 30 characters").build();

        }
        //  4. email is not null, and it should be valid email pattern, containing a single @.
        else if (person.getEmail() == null || !person.getEmail().contains("@")) {
            return ValidationResult.builder().isValidate(false).fieldName("Email")
                    .errorMessage(" is not valid").build();
        }
        //  5. mobile is not null, min 10 and max 10 character and all must be numeric
        else if (person.getPhone() == null || person.getPhone().length() != 10) {
            return ValidationResult.builder().isValidate(false).fieldName("phone Number")
                    .errorMessage(" is not valid").build();

        }
        return ValidationResult.builder().isValidate(true).build();
    }

    public Product deleteProduct(long productId) {
        Product deletedProduct = null;
        Product foundProduct = this.getProductDetail(productId);
        if (foundProduct != null) {
            foundProduct.setIsDeleted(true);
            deletedProduct = productRepository.save(foundProduct);
        } else {
            throw new InvalidProductDetailException("Product with ProductId :" + productId + "Not Found");
        }
        return deletedProduct;
    }

    public List<ProductBidDto> showBidsForProduct(Long productId) {
        List<ProductBidDto> result = null;
        if (productId == null || productId < 0) {
            throw new InvalidProductDetailException("Product id is not correct !!");
        } else {
            result = productBidFeignClient.getAllBidsForProductId(productId);
        }

        return result;
    }

    public Product getProductDetail(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            return productOptional.get();
        } else {
            return null;
        }

    }

    public List<Product> getAllProductDetail(int offset, int limit) {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    public List<Product> getAllProductDetail(Long productCategoryId) {
        List<Product> productList = productRepository.findByCategoryId(productCategoryId);
        return productList;
    }
}
