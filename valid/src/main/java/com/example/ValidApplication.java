package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @auther jiabiaoli@boco.com.cn
 * @date 2018/12/17 19:41
 */
@SpringBootApplication
public class ValidApplication {
    public static void main(String[] args) {
        SpringApplication.run(ValidApplication.class,args);
    }
    @RestController
    public class DemoController{
        @GetMapping("/print")
        //不支持
        public String print(@Valid @NotNull  String name){
            return "hello:"+name;
        }
        @PostMapping("/user")
        public User  insert(@Validated(User.InsertValid.class) User user){
            return user;
        }

        @PutMapping("/user")
        public User  update(@Validated(User.UpdateValid.class) User user){
            return user;
        }
    }
}
