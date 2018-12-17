package com.podigua.demo.core;

import lombok.Data;

import java.util.Date;
/**
 * @auther jiabiaoli@boco.com.cn
 * @date 2018/12/3 15:49
 */
@Data
public class Result<T> {
    public static final int SUCCESS = 200;
    public static final int ERROR = 500;
    public Result() {

    }
    public Result(int code, String message,T data) {
        this.timestamp = System.currentTimeMillis();
        this.code = code;
        this.message = message;
        this.data=data;
    }

    private long timestamp;
    private String message;
    private int code=SUCCESS;
    private T data;

    @Data
    public static class Builder<T> {

        private String message="OK";
        private int code = SUCCESS;
        private T data;

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }
        public Builder<T> error(int code,String message) {
            this.code = code;
            this.message = message;
            return this;
        }
        public Builder<T> error(int code) {
            this.code = code;
            return this;
        }

        public Result<T> build() {
            return new Result<T>(this.code, this.message,this.data);
        }
        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }
    }
}
