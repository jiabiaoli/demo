package com.podigua.demo.method.annotation;

import com.podigua.demo.core.Result;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * @author jiabiaoli
 * @auther jiabiaoli@boco.com.cn
 * @date 2018/12/3 16:13
 */
@ControllerAdvice()
public class ResponseAdvisor implements ResponseBodyAdvice<Object> {

    /**
     * 判断是否需要拦截
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        if (body instanceof Resource) {
            return body;
        }
        if (body instanceof Result) {
            return body;
        }
        return new Result.Builder<>().data(body).build();
    }
}
