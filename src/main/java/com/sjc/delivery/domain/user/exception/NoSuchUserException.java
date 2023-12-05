package com.sjc.delivery.domain.user.exception;

import com.sjc.delivery.global.enums.ErrorCode;
import com.sjc.delivery.global.exception.BaseException;

public class NoSuchUserException extends BaseException {
    public NoSuchUserException(ErrorCode errorCode) {
        super(errorCode.getMessage(), errorCode);
    }
}
