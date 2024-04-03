package com.example.mp.controller;

import com.example.mp.entity.User;
import com.example.mp.entity.UserVo;
import com.example.mp.service.UserService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xi
 * @create 2024/4/3 13:35
 */
@Tag(name = "用户管理接口")
@RequestMapping("users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "新增用户接口")
    @PostMapping
    public void saveUser(@RequestBody UserVo userVo){
        //把VO拷贝到Entity
        User user = new User();
        BeanUtils.copyProperties(userVo,user);
        userService.save(user);
    }

    @Operation(summary = "删除用户接口")
    @DeleteMapping("{id}")
    @Parameters({
            @Parameter(name = "id",description = "用户id",in = ParameterIn.PATH),
    })
    public void deleteUserById(@PathVariable("id") Long id){
        userService.removeById(id);
    }

    @Operation(summary = "查询用户接口")
    @GetMapping("{id}")
    @Parameters({
            @Parameter(name = "id",description = "用户id",in = ParameterIn.PATH),
    })
    public UserVo queryById(@PathVariable("id") Long id){
        //查询用户
        User user = userService.getById(id);
        //把Entity拷贝到Vo
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user,userVo);
        return userVo;
    }

}
