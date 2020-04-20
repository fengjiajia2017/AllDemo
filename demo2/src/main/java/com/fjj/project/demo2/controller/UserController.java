package com.fjj.project.demo2.controller;

import com.fjj.project.demo2.domain.User;
import com.fjj.project.demo2.service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: fengjiajia
 * @Date: 2020/4/20
 * @Description: 用户管理
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        userService.addUser(user);
        return "注册成功";
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user){
        return userService.login(user);
    }

    @PostMapping("/query")
    public List<User> query(){
        return userService.list();
    }

}
