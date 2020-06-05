package com.whkj.project.mapper;

import com.whkj.project.entity.RoleMenuMiddle;

public interface RoleMenuMiddleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleMenuMiddle record);

    int insertSelective(RoleMenuMiddle record);

    RoleMenuMiddle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleMenuMiddle record);

    int updateByPrimaryKey(RoleMenuMiddle record);
}