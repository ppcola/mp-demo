package com.example.mp.controller;


import com.example.mp.entity.User;
import com.example.mp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xi
 * @since 2024-04-03
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("list",userService.list(null));
        return modelAndView;
    }

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id){
        User user = userService.getById(id);
        return user;
    }

    @PostMapping()
    public void saveUser(@RequestBody User user){
        if (user.getGender().equals("")){
            user.setGender(0);
        }
        user.setDeleted(0);
        userService.save(user);
    }
}

