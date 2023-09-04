package com.tech.kj.controller;

import com.tech.kj.controller.dto.GenericResponseDto;
import com.tech.kj.dto.UserRegistrationDto;
import com.tech.kj.entity.AdminEntity;
import com.tech.kj.service.AdminService;
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
public class AdminController {
    @Autowired
    private AdminService sellerService;
    @PostMapping
    public ResponseEntity<GenericResponseDto<UUID>> registerUser(@Valid @RequestBody UserRegistrationDto requestDto){
        AdminEntity entity = sellerService.register(requestDto);
        GenericResponseDto<UUID> responseDto= new GenericResponseDto<>();
        responseDto.setMessage("Sucess");
        responseDto.setData(entity.getId());
        ResponseEntity<GenericResponseDto<UUID>> response = ResponseEntity.ok(responseDto);
        return response;
    }
}
