package com.tencent.classroom.service;

import com.tencent.classroom.pojo.ClassPeopleMiddle;
public interface ClassPeopleMiddleService{


    int deleteByPrimaryKey(Integer id);

    int insert(ClassPeopleMiddle record);

    int insertSelective(ClassPeopleMiddle record);

    ClassPeopleMiddle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassPeopleMiddle record);

    int updateByPrimaryKey(ClassPeopleMiddle record);

}
