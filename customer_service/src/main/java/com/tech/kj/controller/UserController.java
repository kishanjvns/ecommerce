package com.tech.kj.controller;

import com.tech.kj.controller.dto.GenericResponseDto;
import com.tech.kj.dto.UserRegistrationDto;
import com.tech.kj.entity.UserEntity;
import com.tech.kj.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private CustomerService sellerService;
    @PostMapping
    public ResponseEntity<GenericResponseDto<UUID>> registerUser(@Valid @RequestBody UserRegistrationDto requestDto){
        UserEntity entity = sellerService.register(requestDto);
        GenericResponseDto<UUID> responseDto= new GenericResponseDto<>();
        responseDto.setMessage("Sucess");
        responseDto.setData(entity.getId());
        ResponseEntity<GenericResponseDto<UUID>> response = ResponseEntity.ok(responseDto);
        return response;
    }
}
