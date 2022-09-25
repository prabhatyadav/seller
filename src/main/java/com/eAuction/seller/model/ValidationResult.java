package com.eAuction.seller.model;

import lombok.Builder;

@Builder
public class ValidationResult {
    private boolean isValidate;
    private String fieldName;
    private String errorMessage;

}
