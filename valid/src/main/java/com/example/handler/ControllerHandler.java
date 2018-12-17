package com.example.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther jiabiaoli@boco.com.cn
 * @date 2018/12/17 20:35
 */
@ControllerAdvice
public class ControllerHandler extends HandlerInterceptorAdapter {
    private Logger log= LoggerFactory.getLogger(getClass());
    // 异常处理方法：
    // 根据特定的异常返回指定的 HTTP 状态码
    @ResponseStatus(value = HttpStatus.BAD_REQUEST) // 400
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Map<String,Object> handleValidationException(BindException ex) {
        log.error("校验异常", ex);
        StringBuilder strBuilder = new StringBuilder();
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        for (ObjectError error : errors) {
            strBuilder.append(error.getDefaultMessage()).append("\n");
        }
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("message",strBuilder.toString());
        return result;
    }

    /**
     * 也可以捕获其他异常.接收参数以及ExceptionHandler为异常类型即可
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR) // 500
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> handleException(Exception ex) {
        log.error("内部异常", ex);
        Map<String,Object> result=new HashMap<>();
        result.put("code",500);
        result.put("message",ex.getMessage());
        return result;
    }
}
