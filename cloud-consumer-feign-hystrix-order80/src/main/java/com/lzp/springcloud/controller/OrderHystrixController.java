package com.lzp.springcloud.controller;


import com.lzp.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_global_fallbackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/ok/{id}")
    public String OK(@PathVariable("id") Integer id){

        String result = paymentHystrixService.OK(id);
        return result;
    }

   /* @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")  //3秒钟以内就是正常的业务逻辑
    })*/
    @HystrixCommand
    @GetMapping("/consumer/payment/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id){
        Map<Integer,String> map = new HashMap<Integer, String>();
        int x = 10/ 0 ;
        String result = paymentHystrixService.timeout(id);
        return result;

    }
    //兜底方法
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }

    public String payment_global_fallbackMethod(){

        return " 全局异常信息处理，请稍后再试";
    }

}