package com.tech.kj.controller;

import com.tech.kj.controller.dto.GenericResponseDto;
import com.tech.kj.controller.dto.SellerRegistrationDto;
import com.tech.kj.entity.SellerEntity;
import com.tech.kj.service.SellerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@Tag(name = "Seller Onboarding API", description = "Seller Onboarding API")
public class SellerController {
    @Autowired
    private SellerService sellerService;
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes =MediaType.APPLICATION_JSON_VALUE )
    @Operation(
            summary = "Register Seller API",
            description = "Create User REST API is used to save user in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    public ResponseEntity<GenericResponseDto<UUID>> registerUser(@Valid @RequestBody SellerRegistrationDto requestDto){
        SellerEntity entity = sellerService.register(requestDto);
        GenericResponseDto<UUID> responseDto= new GenericResponseDto<>();
        responseDto.setMessage("Sucess");
        responseDto.setData(entity.getId());
        ResponseEntity<GenericResponseDto<UUID>> response = ResponseEntity.ok(responseDto);
        return response;
    }
}
