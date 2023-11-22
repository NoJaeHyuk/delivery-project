package com.sjc.delivery.global.utils;

import com.sjc.delivery.global.response.ExceptionResponse;
import com.sjc.delivery.global.response.ApiResponse;

/**
 * 공통 ApiResponse 호출 유틸
 */
public class ApiResponseUtils {

    public static <T> ApiResponse<T> success (String message, T data) {
        return ApiResponse.res(true, data, null);
    }

    public static ApiResponse<?> error(ExceptionResponse exceptionResponse) {
        return ApiResponse.res(false, null, exceptionResponse);
    }

}
