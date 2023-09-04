package com.tech.kj.controller;

import com.tech.kj.controller.dto.GenericResponseDto;
import com.tech.kj.controller.dto.SellerRegistrationDto;
import com.tech.kj.entity.SellerEntity;
import com.tech.kj.service.SellerService;
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
public class SellerController {
    @Autowired
    private SellerService sellerService;
    @PostMapping
    public ResponseEntity<GenericResponseDto<UUID>> registerUser(@Valid @RequestBody SellerRegistrationDto requestDto){
        SellerEntity entity = sellerService.register(requestDto);
        GenericResponseDto<UUID> responseDto= new GenericResponseDto<>();
        responseDto.setMessage("Sucess");
        responseDto.setData(entity.getId());
        ResponseEntity<GenericResponseDto<UUID>> response = ResponseEntity.ok(responseDto);
        return response;
    }
}
