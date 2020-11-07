package com.lzp.springcloud.cpm.lzp.springcloud.controller;


import com.lzp.springcloud.cpm.lzp.springcloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class userController {

    @Autowired
    UserService userService;


    @GetMapping("/payment/ok/{id}")
    public String OK(@PathVariable("id") Integer id) {

        String result = userService.OK(id);
        return result;
    }


    @GetMapping("/payment/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id) {

        String result = userService.paymentCircuitBreaker(id);
        return result;
    }
}
