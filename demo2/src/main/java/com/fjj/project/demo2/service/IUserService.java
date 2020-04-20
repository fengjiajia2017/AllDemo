package com.fjj.project.demo2.service;

import com.fjj.project.demo2.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @Author: fengjiajia
 * @Date: 2020/4/20
 * @Description: 用户管理
 */
public interface IUserService {

    /**
     * 描述:注册用户
     * @author 2020年04月20日  fengjiajia
     * @param user 用户信息
     */
    void addUser(User user);

    /**
     * 描述:登录
     * @author 2020年04月20日  fengjiajia
     * @param user 用户信息
     * @return 登录结果
     */
    Map<String, Object> login(User user);

    /**
     * 描述:用户列表查询
     * @author 2020年04月20日  fengjiajia
     * @return 列表数据
     */
    List<User> list();
}
