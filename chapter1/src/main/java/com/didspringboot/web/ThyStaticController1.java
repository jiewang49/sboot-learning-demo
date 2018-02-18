package com.didspringboot.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 访问静态页面时不能用 @RestController,必须要用 @Controller
 * 参考 http://blog.csdn.net/wangb_java/article/details/71775637
 */
@Controller
@EnableAutoConfiguration
public class ThyStaticController1 {

    @RequestMapping("/")

    public String index(ModelMap modelMap) {

        modelMap.addAttribute("host", "study spring boot");
        return "index";
    }

}
