package com.sjc.delivery.global.exception;

import com.sjc.delivery.global.enums.ErrorCode;
import lombok.Getter;

/**
 * 공통 Exception 처리를 위한 추상 클래스
 */
@Getter
public abstract class BaseException extends RuntimeException{
    private final ErrorCode errorCode;

    protected BaseException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
