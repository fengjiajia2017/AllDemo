package com.fjj.project.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
//@Controller
//@ResponseBody
public class Demo1Application {

    @GetMapping("/hello1")
    public String test(@RequestParam("name") String name){
        return "hello world1, "+name+"!";
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello1(@RequestParam("name") String name){
        return "hello world2, "+name+"!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
}
