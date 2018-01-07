package com.didspringboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pc on 2017/12/25.
 */
@RestController
@EnableAutoConfiguration
public class HelloController1 {

    @RequestMapping("/hello")

    public String index() {
        return "hello world!";
    }

}
