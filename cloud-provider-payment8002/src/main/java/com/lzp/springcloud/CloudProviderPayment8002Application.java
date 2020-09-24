package com.lzp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudProviderPayment8002Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8002Application.class, args);
    }

}
