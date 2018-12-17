package com.example;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auther jiabiaoli@boco.com.cn
 * @date 2018/12/17 21:30
 */
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }
    @RestController
    public class DemoController{
        @GetMapping("/list")
        @JsonView(User.ListUser.class)
        public List<User> list(){
             return User.buildList();
        }
        @GetMapping("/{id}")
        @JsonView(User.SingleUser.class)
        public User getById(@PathVariable("id") Integer id){
            return User.build(id);
        }
    }
}
