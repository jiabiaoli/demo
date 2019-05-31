package com.podigua.demo.controller;

import com.podigua.demo.domain.User;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * @author jiabiaoli
 * @auther jiabiaoli@boco.com.cn
 * @date 2018/12/3 15:47
 */
@RestController
public class DemoController {
    @GetMapping("/echo/{name}")
    public String echo(@PathVariable("name") String name){
        return "hello:"+name;
    }
    @GetMapping("/long")
    public Long longValue(){
        return 1L;
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id){
        User user=new User(id,"Lucy",18);
        return user;
    }
    @GetMapping("/download")
    public ResponseEntity<FileSystemResource> download() {
        File file = new File("/Users/jiabiaoli/Desktop/1.jpg");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        try {
            headers.add("Content-Disposition", "attachment; filename=" + new String(file.getName().getBytes("GB2312"),"ISO-8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new FileSystemResource(file));
    }
}
