package com.example.mp.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mp.entity.User;
import com.example.mp.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author xi
 * @create 2024/4/3 10:44
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
}
