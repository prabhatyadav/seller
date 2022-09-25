package com.eAuction.seller.service;

import com.eAuction.seller.constant.ProductConstant;
import com.eAuction.seller.dto.ProductDto;
import com.eAuction.seller.exception.InvalidProductDetailException;
import com.eAuction.seller.model.Person;
import com.eAuction.seller.model.PersonTypeEnum;
import com.eAuction.seller.model.Product;
import com.eAuction.seller.model.ValidationResult;
import com.eAuction.seller.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    PersonService personService;

    @Autowired
    ProductRepository productRepository;

    ModelMapper modelMapper = new ModelMapper();

    public Product addProduct(ProductDto productDto) throws InvalidProductDetailException {
        Product newProduct = new Product();
        if (productDto != null && validate(productDto)) {
            //Product is already there or not ?

            //Person who is trying to add the Product is present seller or not.
            if (productDto.getPersonEmailId() != null &&
                    productDto.getPhoneNumber() != null &&
                    productDto.getPersonType() == PersonTypeEnum.SELLER) {
                Person searchedPerson = personService
                        .findPerson(productDto.getPersonEmailId(), productDto.getPhoneNumber(), productDto.getPersonType());
                if (searchedPerson != null) {

                    // Product Category is present or not
                    if (productDto.getCategory() != null) {
                        throw new InvalidProductDetailException();
                    }

                } else {
                    //create the seller account for the person.
                    // personService.Save()
                }

            }

        } else {
            new InvalidProductDetailException();
        }
        return newProduct;
    }

    private boolean validate(ProductDto productDto) {
        // Validations:
        //  1. Product Name is not null, min 5 and max 30 characters.
        if (productDto == null ||
                productDto.getName() == null ||
                productDto.getName().length() < ProductConstant.MIN_ALLOWED ||
                productDto.getName().length() > ProductConstant.MAX_ALLOWED) {
            return false;
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

    public void deleteProduct(String productId) {
    }

    public void showBidsForProduct(String productId) {
    }
}
