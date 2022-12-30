package com.eAuction.seller.dto;

import com.eAuction.seller.model.PersonTypeEnum;
import com.eAuction.seller.model.ProductCategory;
import lombok.*;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class ProductDto {
    private long id;
    private String name;
    private String shortDescription;
    private String detailedDescription;
    private ProductCategory category;
    private double startingPrice;
    private LocalDateTime bidEndDate;
    private LocalDateTime bidStartDate;
    private LocalDateTime createdDate;
    private String personFirstName;
    private String personLastName;
    private String personEmail;
    private String personPhone;
    private PersonTypeEnum personType;
}
