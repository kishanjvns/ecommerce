package com.tech.kj.controller.test;

/*import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.vavr.CheckedFunction0;*/
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.function.Supplier;

@SpringBootTest
public class Resilience4jTest {
    @Autowired
    private RestTemplate restTemplate;
    //**
    // to pass below test our eureka registry has to be running
    // and it should have the AUTH-Service registered as well
    // */
   /* @Test
    public void testRetryPassCase(){
        Retry retry = Retry.ofDefaults("defaultRetry");
        Supplier<Set<HttpMethod>> authStoreService =()-> authStoreCall();
        Supplier<Set<HttpMethod>> authStoreService2 = Retry.decorateSupplier(retry,authStoreService);
        System.out.println(authStoreService2.get());
    }

   *//**
    * below is a retry test to handle the exception *//*
    @Test
    public void testRetry2(){
        Retry retry = Retry.of("authRetry",
                RetryConfig.custom()
                        .maxAttempts(3)
                        .waitDuration(Duration.of(2, ChronoUnit.SECONDS))
                        .build()
        );
        CheckedFunction0<Set<HttpMethod>> authStoreService2 = Retry.decorateCheckedSupplier(retry,()-> authStoreCall2());
        try {
            System.out.println(authStoreService2.apply());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }


    public Set<HttpMethod> authStoreCall(){
        Set<HttpMethod> methods = restTemplate.optionsForAllow("http://AUTH-STORE/auth/store");
        return methods;
    }


    public Set<HttpMethod> authStoreCall2() throws Exception{
        Set<HttpMethod> methods = restTemplate.optionsForAllow("http://AUTH-STORE/auth/store");
        return methods;
    }
    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;


    @Test
    public void testCB_positive(){
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        String url = "http://localhost:1234/not-real";

        String result= circuitBreaker.run(() -> restTemplate.getForObject(url, String.class),
                throwable -> getDefaultAlbumList());
        Assertions.assertNotNull(result);
    }

    @Test
    public String getAlbumList() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        String url = "https://jsonplaceholder.typicode.com/albums";

        return circuitBreaker.run(() -> restTemplate.getForObject(url, String.class));
    }


    @Test
    public String testCB_positive2() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        String url = "http://localhost:1234/not-real";

        return circuitBreaker.run(() -> restTemplate.getForObject(url, String.class),
                throwable -> getDefaultAlbumList());
    }

    private String getDefaultAlbumList() {
        return "sample";
    }*/
}

