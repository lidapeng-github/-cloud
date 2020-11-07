package com.lzp.springcloud.cpm.lzp.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface UserService {
     String OK(Integer id);

    String timeout(Integer id);
    public String paymentCircuitBreaker(Integer id);
}
