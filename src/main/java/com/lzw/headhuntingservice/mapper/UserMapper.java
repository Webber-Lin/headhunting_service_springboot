package com.lzw.headhuntingservice.mapper;

import com.lzw.headhuntingservice.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

   User selectUser(User user);

    User selectUsername(User user);

    boolean insertUser(User user);
}