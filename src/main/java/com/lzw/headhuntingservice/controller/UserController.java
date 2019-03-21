package com.lzw.headhuntingservice.controller;

import com.lzw.headhuntingservice.bean.User;
import com.lzw.headhuntingservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //用户登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestBody User user){
        return String.valueOf(userService.login(user));
    }

    //是否已经存在用户
    @RequestMapping("/isExistUser")
    public String isExistUser(@RequestParam("username")String username){
        User user=new User();
        user.setUsername(username);
        return String.valueOf(userService.isExistUser(user));
    }

    //用户注册
    @RequestMapping("/register")
    public String register(@RequestParam("username")String username,@RequestParam("userpsd") String userpsd){
        User user=new User();
        user.setUsername(username);
        user.setUserpsd(userpsd);
        if(userService.isExistUser(user)){
            return String.valueOf(false);
        }else {
            return String.valueOf(userService.register(user));
        }
    }

}
