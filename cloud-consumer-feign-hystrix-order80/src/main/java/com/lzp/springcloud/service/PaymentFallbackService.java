package com.lzp.springcloud.service;


import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements  PaymentHystrixService{
    public String OK(Integer id) {
        return "------------服务器正在忙，稍后再试------------------------";
    }

    public String timeout(Integer id) {
        return null;
    }
}
