package com.whkj.project.service;

import com.whkj.project.entity.UserRoleMiddle;
public interface UserRoleMiddleService{


    int deleteByPrimaryKey(Integer id);

    int insert(UserRoleMiddle record);

    int insertSelective(UserRoleMiddle record);

    UserRoleMiddle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRoleMiddle record);

    int updateByPrimaryKey(UserRoleMiddle record);

}
