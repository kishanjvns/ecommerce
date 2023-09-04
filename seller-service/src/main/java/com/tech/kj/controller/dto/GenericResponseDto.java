package com.tech.kj.controller.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class GenericResponseDto<T>{
    private T data;
    private String message;
}
