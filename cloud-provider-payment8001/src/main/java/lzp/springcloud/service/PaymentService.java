package lzp.springcloud.service;


import com.lzp.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;



public interface PaymentService {

    int create(Payment payment);

    Payment queryById(@Param("id") Long id);
}
