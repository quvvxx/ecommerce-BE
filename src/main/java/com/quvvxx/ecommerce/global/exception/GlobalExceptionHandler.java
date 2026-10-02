package com.quvvxx.ecommerce.global.exception;

import com.quvvxx.ecommerce.global.exception.response.FieldErrorDetail;
import com.quvvxx.ecommerce.global.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<Void>> handleBusinessException(BusinessException e){

        ErrorCode errorCode = e.getErrorCode();
        ApiResponse<Void> response = ApiResponse.failure(errorCode, null);

        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidException(MethodArgumentNotValidException e){

        List<FieldErrorDetail> details = e.getBindingResult()
                .getFieldErrors().stream()
                .map(error -> FieldErrorDetail.of(error.getField(), error.getDefaultMessage()))
                .toList();

        ErrorCode errorCode = ErrorCode.INVALID_REQUEST;
        ApiResponse<Void> response = ApiResponse.failure(errorCode,details);

        return ResponseEntity.status(errorCode.getHttpStatus()).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception e){

        log.error("예상하지 못한 예외가 발생했습니다.", e);
        ErrorCode errorCode = ErrorCode.INVALID_REQUEST;
        ApiResponse<Void> response = ApiResponse.failure(errorCode, null);

        return ResponseEntity.status(errorCode.getHttpStatus()).body(response);
    }
}
