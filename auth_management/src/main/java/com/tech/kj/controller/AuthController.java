package com.tech.kj.controller;

import com.tech.kj.controller.dto.UserRegDto;
import com.tech.kj.dto.GenericResponseDto;
import com.tech.kj.entity.BaseUserEntity;
import com.tech.kj.entity.UserEntity;
import com.tech.kj.service.AuthStoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
@RequestMapping("/store")
@Tag(name = "Authentication Controller APIs",description = "Authentication APIs details")
public class AuthController {

    @Autowired
    private AuthStoreService authStoreService;
    @GetMapping
    public ResponseEntity hello(){
        return ResponseEntity.ok("hello");
    }

    @Operation(summary = "Post API to create a record Auth record",
    description = "This Post will create a common record of all types of users in one single database")
    @ApiResponses({
            @ApiResponse(responseCode = "201",description = "Resource successfully created",useReturnTypeSchema = true,content = @Content(schema = @Schema(implementation =GenericResponseDto.class ))),
            @ApiResponse(responseCode = "400", description = "Invalid data sent"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<UUID>> saveUser(@RequestBody UserRegDto requestedRegDto){
        UserEntity saveduser = authStoreService.saveAuthDetail(requestedRegDto);
        GenericResponseDto<UUID> responseDto= new GenericResponseDto<>();
        responseDto.setMessage("Success");
        responseDto.setData(saveduser.getId());
        ResponseEntity<GenericResponseDto<UUID>> response = new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        return response;
    }
}
