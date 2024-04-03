package com.example.mp.service;

import com.example.mp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xi
 * @create 2024/4/3 19:50
 */
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void queryTest(){
        userMapper.selectList(null).forEach(System.out::println);
    }
}