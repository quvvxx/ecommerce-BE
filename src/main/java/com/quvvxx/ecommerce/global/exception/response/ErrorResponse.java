package com.quvvxx.ecommerce.global.exception.response;

import com.quvvxx.ecommerce.global.exception.ErrorCode;

import java.util.List;

public record ErrorResponse(
        String code,
        String message,
        List<FieldErrorDetail> details
) {
    public static ErrorResponse of(ErrorCode errorCode, List<FieldErrorDetail> details){
        return new ErrorResponse(errorCode.name(), errorCode.getMessage(), details);
    }
}
