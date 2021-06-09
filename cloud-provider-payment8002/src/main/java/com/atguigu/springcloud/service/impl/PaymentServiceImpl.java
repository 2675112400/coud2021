package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.bean.Payment;
import com.atguigu.springcloud.dao.PayMentDao;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PayMentDao payMentDao;

    public Payment select(Integer id){
        return payMentDao.select(id);
    }
    public  Integer insert(Payment payment){
        return payMentDao.insert(payment);
    }
}
