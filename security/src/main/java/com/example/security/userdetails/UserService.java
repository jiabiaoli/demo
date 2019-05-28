package com.example.security.userdetails;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * 模拟查询数据库,获取用户
 */
@Service
public class UserService {

   public  UserDetail loadUserByUsername(String username){
       //模拟用户不存在场景
       if("temp".equalsIgnoreCase(username)){
           return null;
       }
       UserDetail userDetail=new UserDetail();
       userDetail.setUsername(username);
       //模拟数据库密码 md5 加密
       userDetail.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
       return userDetail;
   }
}
