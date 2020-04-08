package com.tencent.classroom.service;

import com.tencent.classroom.pojo.ClassRoom;

import java.util.List;

public interface ClassRoomService {


    int deleteByPrimaryKey(Integer id);

    int insert(ClassRoom record);

    int insertSelective(ClassRoom record);

    ClassRoom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassRoom record);

    int updateByPrimaryKey(ClassRoom record);

    int deleteByPrimaryKey(Integer id, Integer stauts);

    ClassRoom selectByPrimaryKey(Integer id, Integer stauts);

    List<ClassRoom> findAllClassRoom();
 }

