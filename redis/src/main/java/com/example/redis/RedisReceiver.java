package com.example.redis;

import com.example.User;
import org.springframework.stereotype.Service;

/**
 * @author: podigua
 * @create: 2021-03-16 22:41
 **/
@Service
public class RedisReceiver {
    public void handleMessage(User user, String topic) {
        System.out.println("user:" + user + " ,topic: " + topic);
    }
}
