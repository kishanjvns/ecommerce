package com.tech.kj;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Auth Store Information",
description = "Open API specification of Auth store API",
version = "1.0",
contact = @Contact(name="Kishan", email = "kishanjvns@gmail.com",url = "http://www.github.com/kishanjvns")
),
tags = @Tag(name = "Version 1.0",description = "Release version Info"))
public class AuthStoreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthStoreServiceApplication.class, args);
	}

}
