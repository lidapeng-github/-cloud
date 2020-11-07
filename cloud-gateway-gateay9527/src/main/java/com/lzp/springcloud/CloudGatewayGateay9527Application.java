package com.lzp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudGatewayGateay9527Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayGateay9527Application.class, args);
    }

}
