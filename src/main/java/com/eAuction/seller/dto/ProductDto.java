package com.eAuction.seller.dto;

import com.eAuction.seller.model.ProductCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Builder
@Getter
@Setter
public class ProductDto {
    private long id;
    private String name;
    private String shortDescription;
    private String detailedDescription;
    private ProductCategory category;
    private double startingPrice;
    private LocalDateTime bidEndDate;
}
