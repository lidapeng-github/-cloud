package com.lzp.springcloud.controller;

import com.lzp.springcloud.entities.CommonResult;
import com.lzp.springcloud.entities.Payment;
import com.lzp.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult creat(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info("执行结果"+i);

        if(i > 0){
        return  new CommonResult(200,"操作成功serverPort:"+serverPort,i);
        }else {
            return  new CommonResult(200,"操作成功",null);
        }
    }

    @GetMapping(value = "/payment/queryById/{id}")
    public CommonResult queryById(@PathVariable("id") Long id){
        Payment payment = paymentService.queryById(id);
        log.info("执行结果"+payment);
        if(payment != null ){
            return  new CommonResult(200,"操作成功,serverPort:"+serverPort,payment);
        }else {
            return  new CommonResult(400,"无记录",null);
        }
    }

    @RequestMapping("/payment/consul")
    public String patmentConsul(){
        return "springCloud with consul "+serverPort + "  "+ UUID.randomUUID().toString();
    }
}
