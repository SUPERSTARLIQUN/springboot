package com.tencent.classroom.mapper;

import com.tencent.classroom.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(User record);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}