package com.fjj.project.demo2;

import com.fjj.project.demo2.dao.UserDao;
import com.fjj.project.demo2.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class Demo2ApplicationTests {

    @Resource
    private JdbcTemplate jdbcTemplate;


    @Resource
    private UserDao userDao;

    /**
     * spring jdbc查询数据
     */
    @Test
    void contextLoads() {
        String sql = "select id, user_name, password, remark from user";
        List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                user.setRemark(resultSet.getString("remark"));
                return user;
            }
        });
        System.out.println("----------查询结果如下：----------");
        //下面使用JDK8的新特性，如果没有安装JDK8的可以修改为普通的for循环
        userList.stream().forEach(user -> {System.out.println(user.toString());});
    }


    /**
     * mybatis dao测试
     */
    @Test
    void testMybatis(){
        User user = userDao.selectByPrimaryKey(1L);
        System.out.println(user.toString());
    }

}
