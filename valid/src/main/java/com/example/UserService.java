package com.example;

import org.springframework.stereotype.Service;

/**
 * @auther jiabiaoli@boco.com.cn
 * @date 2018/12/17 20:54
 */
@Service
public class UserService {
    public User getUserByPhone(String phone){
        User user=new User();
        user.setPhone(phone);
        return user;
    }
}
