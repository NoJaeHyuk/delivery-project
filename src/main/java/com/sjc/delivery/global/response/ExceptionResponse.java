package com.sjc.delivery.global.response;


import java.sql.Timestamp;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ExceptionResponse {
    private Timestamp timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public ExceptionResponse(HttpStatus httpStatus, String message, String path) {
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.status = httpStatus.value();
        this.error = httpStatus.name();
        this.message = message;
        this.path = path;
    }
}
