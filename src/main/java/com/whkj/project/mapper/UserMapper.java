package com.whkj.project.mapper;

import com.whkj.project.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(@Param("host") String host, @Param("user") String user);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(@Param("host") String host, @Param("user") String user);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findUserPage(User user);
}