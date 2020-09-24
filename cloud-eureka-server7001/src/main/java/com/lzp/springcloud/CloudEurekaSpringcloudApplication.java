package com.lzp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaSpringcloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaSpringcloudApplication.class, args);
    }

}
