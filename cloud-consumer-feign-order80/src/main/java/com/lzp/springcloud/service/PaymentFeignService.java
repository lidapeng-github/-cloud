package com.lzp.springcloud.service;


import com.lzp.springcloud.entities.CommonResult;
import com.lzp.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {


    @GetMapping(value = "/payment/queryById/{id}")
    CommonResult<Payment> queryById(@PathVariable("id") Long id);
}
