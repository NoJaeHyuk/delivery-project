package com.sjc.delivery.domain.food.exception;

import com.sjc.delivery.global.enums.ErrorCode;
import com.sjc.delivery.global.exception.BaseException;

public class NoSuchFood extends BaseException {
    public NoSuchFood(ErrorCode errorCode) {
        super(errorCode.getMessage(), errorCode);
    }
}
