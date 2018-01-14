package com.didspringboot.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WebProperties {
    @Value("${com.didspringboot.web.name}")
    private String name;

    @Value("${com.didspringboot.web.title}")
    private String title;

    @Value("${com.didspringboot.web.desc}")
    public String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
