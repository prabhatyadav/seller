package com.eAuction.seller.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ValidationResult {
    private boolean isValidate;
    private String fieldName;
    private String errorMessage;

}
