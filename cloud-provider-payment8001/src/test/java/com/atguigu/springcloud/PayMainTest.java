package com.atguigu.springcloud;

import com.atguigu.springcloud.bean.Payment;
import com.atguigu.springcloud.dao.PayMentDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PayMainTest {

    @Autowired
    PayMentDao payMentDao;

    @Test
    public void test(){
        int insert = payMentDao.insert(new Payment(null, "1"));
        System.out.println(insert);
    }

}
