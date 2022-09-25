package com.eAuction.seller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.bytebuddy.asm.Advice;

@Data
@AllArgsConstructor
public class ExceptionMessage {
    String errorCode;
    String errorMessage;
}
