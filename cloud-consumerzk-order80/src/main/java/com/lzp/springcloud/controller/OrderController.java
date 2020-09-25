package com.lzp.springcloud.controller;


import com.lzp.springcloud.entities.CommonResult;
import com.lzp.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/queryById/{id}")
    public CommonResult<Payment> queryById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/queryById/"+id,CommonResult.class);
    }

    @GetMapping("/payment/zk")
    public String patmentzk(){

        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk",String.class);
    }
}
