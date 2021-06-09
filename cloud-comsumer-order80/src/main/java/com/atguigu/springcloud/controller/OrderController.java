package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.bean.CommonResulet;
import com.atguigu.springcloud.bean.Payment;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/order/paument/create")
    public CommonResulet<Payment> create(Payment payment){
        System.out.println(payment);
        return restTemplate.postForObject("http://pay-service/payment/insert",payment,CommonResulet.class);
    }
    @GetMapping("/order/paument/{id}")
    public CommonResulet<Payment> select(@PathVariable Integer id){
        return restTemplate.getForObject("http://pay-service/payment/"+id,CommonResulet.class);
    }
}
