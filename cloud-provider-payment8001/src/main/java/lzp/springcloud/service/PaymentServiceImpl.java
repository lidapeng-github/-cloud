package lzp.springcloud.service;

import com.lzp.springcloud.entities.Payment;
import lzp.springcloud.dao.PaymentDao;

import org.springframework.beans.factory.annotation.Autowired;
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
