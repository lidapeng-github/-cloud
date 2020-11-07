package com.lzp.springcloud.controller;

import com.lzp.springcloud.entities.CommonResult;
import com.lzp.springcloud.entities.Payment;
import com.lzp.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "consumer/payment/queryById/{id}")
    public CommonResult queryById(@PathVariable("id") Long id){
      return paymentFeignService.queryById(id);
    }
}
