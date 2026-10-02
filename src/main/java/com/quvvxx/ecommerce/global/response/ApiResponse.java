package com.quvvxx.ecommerce.global.response;

import com.quvvxx.ecommerce.global.exception.ErrorCode;
import com.quvvxx.ecommerce.global.exception.response.ErrorResponse;
import com.quvvxx.ecommerce.global.exception.response.FieldErrorDetail;

import java.util.List;

public record ApiResponse<T>(
        boolean success,
        T data,
        ErrorResponse error
        )
{
    public static <T> ApiResponse<T> success(T data){
        return new ApiResponse<>(true, data, null);
    }

    public static ApiResponse<Void> failure(ErrorCode errorCode, List<FieldErrorDetail> details){
        return new ApiResponse<>(false, null, ErrorResponse.of(errorCode, details));
    }
}
