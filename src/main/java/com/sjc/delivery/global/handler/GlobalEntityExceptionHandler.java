package com.sjc.delivery.global.handler;

import static org.springframework.http.HttpStatus.*;

import com.sjc.delivery.global.exception.BaseException;
import com.sjc.delivery.global.response.ApiResponse;
import com.sjc.delivery.global.response.ExceptionResponse;
import com.sjc.delivery.global.utils.ApiResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleAllException(Exception ex, WebRequest request) {

        log.error("handling {}, message : {}", ex.getClass().toString(), ex.getMessage());

        //request.getDescription
        //Get a short description of this request, typically containing request URI and session id.
        return new ResponseEntity<>(
            ApiResponseUtils.error(
                new ExceptionResponse(INTERNAL_SERVER_ERROR, ex.getMessage(),
                    request.getDescription(false))), INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiResponse<?>> handleApplicationException(BaseException ex, WebRequest request) {
        log.error("handling {}, message : {}", ex.getClass().toString(), ex.getMessage());

        return new ResponseEntity<>(
            ApiResponseUtils.error(
                new ExceptionResponse(ex.getErrorCode().getHttpStatus(), ex.getMessage(),
                    request.getDescription(false))), BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        log.error("handling {}, message : {}", ex.getClass().toString(), ex.getMessage());

        return new ResponseEntity<>(
            ApiResponseUtils.error(
            new ExceptionResponse(BAD_REQUEST, ex.getMessage(),
                request.getDescription(false))), BAD_REQUEST);
    }
}
