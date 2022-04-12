package com.mlr.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mlr
 * @date: 2022/4/11 22:05
 * @since: 1.0.0
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/employee/basic/hello")
    public String hello2(){
        return "/employee/basic/hello";
    }

    @GetMapping("/employee/advanced/hello")
    public String hello3(){
        return "/employee/advanced/hello";
    }
}
