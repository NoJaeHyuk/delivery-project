package com.sjc.delivery.domain.store.exception;

import com.sjc.delivery.global.enums.ErrorCode;
import com.sjc.delivery.global.exception.BaseException;

public class NoSuchStore extends BaseException {
    public NoSuchStore(ErrorCode errorCode) {
        super(errorCode.getMessage(), errorCode);
    }
}
