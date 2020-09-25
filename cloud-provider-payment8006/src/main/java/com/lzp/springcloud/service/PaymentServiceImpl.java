package com.lzp.springcloud.service;

import com.lzp.springcloud.dao.PaymentDao;
import com.lzp.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment queryById(Long id) {

        return paymentDao.queryById(id);
    }
}
