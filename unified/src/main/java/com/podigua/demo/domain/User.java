package com.podigua.demo.domain;

import lombok.Data;

/**
 * @auther jiabiaoli@boco.com.cn
 * @date 2018/12/3 15:52
 */
@Data
public class User {
    public User(){

    }
    public User(Long id,String name,Integer age){
        this.id=id;
        this.name=name;
        this.age=age;
    }
    private Long id;
    private String name;
    private Integer age;
}
