package com.tencent.classroom.mapper;

import com.tencent.classroom.pojo.ClassPeopleMiddle;

public interface ClassPeopleMiddleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassPeopleMiddle record);

    int insertSelective(ClassPeopleMiddle record);

    ClassPeopleMiddle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassPeopleMiddle record);

    int updateByPrimaryKey(ClassPeopleMiddle record);
}