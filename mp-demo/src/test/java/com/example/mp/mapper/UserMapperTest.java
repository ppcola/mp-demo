package com.example.mp.mapper;

import com.example.mp.entity.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xi
 * @create 2024/4/1 11:14
 */
@SpringBootTest
@MapperScan("com.example.mp.mapper")
@Repository
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void test(){
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void save(){
        User user = new User();
        user.setUsername("梅西");
        user.setPassword("123456");
        user.setInfo("{\"age\": 30, \"intro\": \"足球\", \"gender\": \"male\"}");
        userMapper.insert(user);
    }

    @Test
    void testQueryByIds(){
        List<User> users=userMapper.queryUserByIds(List.of(1L,2L,3L,4L));
        users.forEach(System.out::println);
    }

}