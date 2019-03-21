package com.lzw.headhuntingservice.service;

import com.lzw.headhuntingservice.bean.User;
import com.lzw.headhuntingservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public boolean login(User user) {
        return userMapper.selectUser(user) != null;
    }

    public boolean isExistUser(User user) {
        return userMapper.selectUsername(user)!=null;
    }

    public boolean register(User user) {
        return userMapper.insertUser(user);
    }
}
