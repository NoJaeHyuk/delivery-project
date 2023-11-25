package com.sjc.delivery.global.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ApiResponse<T> {
    private final boolean success;
    private final T data;
    private final ExceptionResponse error;

    @Builder
    private ApiResponse(final boolean success, final T data, final ExceptionResponse error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public static <T> ApiResponse<T> res(final boolean success, final T data, ExceptionResponse error) {
        return ApiResponse.<T>builder()
            .success(success)
            .data(data)
            .error(error)
            .build();
    }
}