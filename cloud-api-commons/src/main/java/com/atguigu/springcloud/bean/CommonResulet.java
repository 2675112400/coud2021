package com.atguigu.springcloud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResulet<T> {
    private Integer code;
    private  String message;
    private  T data;
    public CommonResulet(Integer id,String msg){
        this.code = id;
        this.message = msg;
    }
}
