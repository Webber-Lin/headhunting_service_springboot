package com.lzw.headhuntingservice.mapper;

import com.lzw.headhuntingservice.bean.Applicant;
import com.lzw.headhuntingservice.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    int selectUser(User user);

    User selectUsername(User user);

    boolean insertUser(User user);

    boolean improveApplicant(Applicant applicant);

    void deleteApplicant(Applicant applicant);

    Applicant selectApplicant(@Param("id") Integer integer);
}