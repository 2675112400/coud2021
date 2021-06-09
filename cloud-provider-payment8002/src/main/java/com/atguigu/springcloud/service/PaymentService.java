package com.atguigu.springcloud.service;

import com.atguigu.springcloud.bean.Payment;
import org.springframework.stereotype.Service;


public interface PaymentService {

    Payment select(Integer id);
    Integer insert(Payment payment);

}
