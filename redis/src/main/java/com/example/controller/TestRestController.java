package com.example.controller;

import com.example.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: podigua
 * @create: 2021-03-16 22:42
 **/
@RestController
public class TestRestController {
    private final RedisTemplate redisTemplate;

    public TestRestController(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    @GetMapping("/test")
    public void test(){
        redisTemplate.convertAndSend("redis-topic-0",new User("1","Tom"));
        redisTemplate.convertAndSend("redis-topic-1",new User("2","Lucy"));
    }
}
