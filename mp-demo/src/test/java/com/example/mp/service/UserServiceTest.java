package com.example.mp.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xi
 * @create 2024/4/3 10:55
 */
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    //新增


    @Test
    void addTest() {
        User user = new User();
        user.setUsername("Iservice");
        user.setPassword("ServiceImpl");
        user.setInfo("{\"key\":\"value\",\"age\":10}");
        userService.save(user);
    }

    @Test
    void queryTest() {
        List<User> users = userService.listByIds(List.of(1L, 2L, 3L));
        users.forEach(System.out::println);
    }

    @Test
    void queryOne() {
        List<User> users = userService.list(new LambdaQueryWrapper<User>()
                .like(User::getUsername, "service"));
        users.forEach(System.out::println);
    }
}