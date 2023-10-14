package com.tech.kj;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication(scanBasePackages = "com.tech.*")
@EnableDiscoveryClient
@OpenAPIDefinition(info =
@Info(title = "Seller Service Documentation",
		description = "Seller Management Service",
		version = "1.0", contact = @Contact(
        name = "Kishan", email = "kishangvns@hotmail.com",
		url = "http://www.github.com/kishanjvns")))
public class SellerPartnersApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SellerPartnersApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {

    }

}
