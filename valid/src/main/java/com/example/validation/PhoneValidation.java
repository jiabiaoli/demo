package com.example.validation;

import com.example.User;
import com.example.UserService;
import com.example.validation.annotation.PhoneAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @auther jiabiaoli@boco.com.cn
 * @date 2018/12/17 20:50
 */
public class PhoneValidation implements ConstraintValidator<PhoneAnnotation, String> {
    @Autowired
    private UserService userService;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(StringUtils.isEmpty(value)){
            //若手机号为空,则不进行校验(走NotNull校验)
            return true;
        }
        User user=userService.getUserByPhone(value);
        if(user==null){
            return true;
        }
        if(!value.equals(user.getPhone())){
            return true;
        }
        return false;
    }
}
