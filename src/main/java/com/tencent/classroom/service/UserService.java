package com.tencent.classroom.service;

import com.tencent.classroom.pojo.User;
import com.tencent.classroom.utils.RestResult;
import com.tencent.classroom.vo.TencentVo;

import java.util.HashMap;

public interface UserService {


    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(User user);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}




