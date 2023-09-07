package com.tech.kj;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info =
@Info(title = "Seller Service Documentation",
		description = "Seller Management Service",
		version = "1.0", contact = @Contact(
        name = "Kishan", email = "kishangvns@hotmail.com",
		url = "http://www.github.com/kishanjvns")))
public class SellerPartnersApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellerPartnersApplication.class, args);
    }

}