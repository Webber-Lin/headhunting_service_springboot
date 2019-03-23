package com.lzw.headhuntingservice.controller;

import com.lzw.headhuntingservice.bean.Applicant;
import com.lzw.headhuntingservice.bean.User;
import com.lzw.headhuntingservice.service.UserService;
import net.sf.json.JSONObject;
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
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestBody User user){
        if(userService.isExistUser(user)){
            return String.valueOf(false);
        }else {
            return String.valueOf(userService.register(user));
        }
    }

    //完善信息
    @RequestMapping(value="/improve_applicant",method = RequestMethod.POST)
    public String improveApplicant(@RequestBody Applicant applicant){
        return String.valueOf(userService.improveApplicant(applicant));
    }

    //查看求职者个人信息
    @RequestMapping("/select_applicant")
    public String selectApplicant(@RequestParam("id") Integer integer){
        JSONObject jsonObject=JSONObject.fromObject(userService.selectApplicant(integer));
        return jsonObject.toString();
    }

    //求职意向

    //招聘信息

}
