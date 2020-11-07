package com.lzp.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLUOD-PROVIDER-HYSTRIX-PAYMENT8001",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/ok/{id}")
    public String OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id);
}
