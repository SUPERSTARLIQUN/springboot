package com.whkj.project.service;

import com.github.pagehelper.PageInfo;
import com.whkj.project.entity.User;
public interface UserService{


    int deleteByPrimaryKey(String host,String user);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String host,String user);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    PageInfo findUserPage(User user, PageInfo pageInfo);

}
