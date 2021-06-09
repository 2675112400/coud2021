package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.bean.CommonResulet;
import com.atguigu.springcloud.bean.Payment;
//import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/payment/{id}")
    public CommonResulet test(@PathVariable("id")Integer id){
        Payment select = paymentService.select(id);
        if (select!=null){

          return  new CommonResulet<Payment>(200,"8002",select);
        }else{
            return new CommonResulet<Payment>(500,"8002");
        }
    }
    @PostMapping("/payment/insert")
    public  CommonResulet test( @RequestBody Payment payment){
        Integer insert = paymentService.insert(payment);
        if (insert>0){
            CommonResulet<Payment> paymentCommonResult = new CommonResulet<>();
            paymentCommonResult.setCode(200);
            paymentCommonResult.setMessage("8002");
//            paymentCommonResult.setData(pa);
            return paymentCommonResult;
        }else{
            return new CommonResulet(500,"8002");
        }
    }

}
