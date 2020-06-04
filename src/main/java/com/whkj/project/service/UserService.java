package com.whkj.project.service;

import com.github.pagehelper.PageInfo;
import com.whkj.project.entity.User;
public interface UserService{


    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User queryUserByName(String principal);

    PageInfo findUserPage(User user, PageInfo pageInfo);
}
