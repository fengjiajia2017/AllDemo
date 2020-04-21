package com.fjj.project.demo2.service.imp;

import com.fjj.project.demo2.dao.UserDao;
import com.fjj.project.demo2.domain.User;
import com.fjj.project.demo2.domain.UserExample;
import com.fjj.project.demo2.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: fengjiajia
 * @Date: 2020/4/20
 * @Description: 用户管理
 */
@Service
public class UserService implements IUserService {

    @Resource
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.insert(user);
    }

    @Override
    public Map login(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(user.getUserName());
        List<User> users = userDao.selectByExample(example);

        Map<String, Object> map = new HashMap<>();
        if(!users.isEmpty()){
            User userDb = users.get(0);
            if (userDb.getPassword().equals(user.getPassword())){
                map.put("state", 1);
                map.put("msg", "登录成功");
            }else{
                map.put("state", -2);
                map.put("msg", "用户名或密码错误");
            }
        }else{
            map.put("state", -1);
            map.put("msg", "用户不存在");
        }
        return  map;
    }

    @Override
    public List<User> list() {
        UserExample example = new UserExample();
        example.createCriteria();
        return userDao.selectByExample(example);
    }
}
