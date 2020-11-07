package com.lzp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CloudConfigCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigCenterApplication.class, args);
    }

}
