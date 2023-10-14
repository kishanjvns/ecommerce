package com.tech.kj.exception;

import lombok.*;

import java.sql.Timestamp;


@NoArgsConstructor
public class BaseException extends RuntimeException{
    private Timestamp timestamp;
    private String errorCode;
    private String errorMessage;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
