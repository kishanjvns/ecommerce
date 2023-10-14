package com.tech.kj.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Schema
public class UserRegDto {
    private UUID id;
    private String userName;
    private String password;
}
