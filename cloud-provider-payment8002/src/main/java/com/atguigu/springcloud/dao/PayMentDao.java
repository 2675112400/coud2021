package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.bean.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PayMentDao {

    int insert(@Param("payment") Payment payment);

    Payment select(@Param("id") Integer id);
}
