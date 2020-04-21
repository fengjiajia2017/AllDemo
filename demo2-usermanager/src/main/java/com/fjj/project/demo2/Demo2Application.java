package com.fjj.project.demo2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@MapperScan
public class Demo2Application {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("state", -1);
        map.put("msg", "登录成功");
        System.out.println(map);
        SpringApplication.run(Demo2Application.class, args);
    }

}
