package lzp.springcloud.controller;

import com.lzp.springcloud.entities.CommonResult;
import com.lzp.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;

import lzp.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    DiscoveryClient discoveryClient;

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
            return  new CommonResult(200,"操作成功serverPort:"+serverPort,payment);
        }else {
            return  new CommonResult(400,"无记录",null);
        }
    }




    @GetMapping("/payment/discovery")
    public Object getDiscoveryClient(){

        List<String> services = discoveryClient.getServices();
        for (String s : services
             ) {
            log.info("==============>"+s );

        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance i : instances
             ) {
            log.info(i.getInstanceId() +" "+i.getHost()+" "+i.getPort()+"  "+i.getUri() );
        }
        return this.discoveryClient;
    }
}
