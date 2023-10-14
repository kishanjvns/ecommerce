package com.tech.kj.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GenericCustomErrorResponse {
    private String errorCode;
    private String errorMessage;
    private Timestamp timestamp;
}
