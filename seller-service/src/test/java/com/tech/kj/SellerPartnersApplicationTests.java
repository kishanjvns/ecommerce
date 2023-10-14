package com.tech.kj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@SpringBootTest
class SellerPartnersApplicationTests {
	@Autowired
	RestTemplate restTemplate;
	@Test
	void contextLoads() {
	}

	@Test
	void testOption(){
		Set<HttpMethod> methods = restTemplate.optionsForAllow("http://AUTH-STORE/auth/store");
		System.out.println(methods);
		Assertions.assertTrue(true);
	}

}
