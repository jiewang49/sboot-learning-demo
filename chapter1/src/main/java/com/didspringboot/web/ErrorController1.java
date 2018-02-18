package com.didspringboot.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注意：在本工程中必须要在类上加上@RequestMapping，否则会出现 there is already bean 的错误
 */
@RestController
@RequestMapping(value = "/error")
public class ErrorController1 {

    @RequestMapping("/")
    public String error() throws Exception {
        throw new Exception("发生错误!");
    }

}
