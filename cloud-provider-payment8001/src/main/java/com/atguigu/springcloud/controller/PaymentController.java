package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.bean.CommonResulet;
import com.atguigu.springcloud.bean.Payment;
//import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/payment/{id}")
    public CommonResulet test(@PathVariable("id")Integer id){
        Payment select = paymentService.select(id);
        if (select!=null){

          return  new CommonResulet<Payment>(200,"8001",select);
        }else{
            return new CommonResulet<Payment>(500,"8001");
        }
    }
    @PostMapping("/payment/insert")
    public  CommonResulet test( @RequestBody Payment payment){
        Integer insert = paymentService.insert(payment);
        if (insert>0){
            CommonResulet<Payment> paymentCommonResult = new CommonResulet<>();
            paymentCommonResult.setCode(200);
            paymentCommonResult.setMessage("8001");
//            paymentCommonResult.setData(pa);
            return paymentCommonResult;
        }else{
            return new CommonResulet(500,"8001");
        }
    }

    @Autowired
    DiscoveryClient discoveryClient;
    @GetMapping("payment/service")
    public Object test2(){
        List<String> services = discoveryClient.getServices();
        return services;
    }

    @GetMapping("payment/ins")
    public Object test3(){
        List<ServiceInstance> instances = discoveryClient.getInstances("pay-service");
        return instances;
    }
}
