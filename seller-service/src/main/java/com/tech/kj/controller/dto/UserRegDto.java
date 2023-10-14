package com.tech.kj.controller.dto;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class UserRegDto {
    private UUID id;
    private String userName;
    private String password;
}