package com.tencent.classroom.mapper;

import com.tencent.classroom.pojo.ClassRoom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassRoomMapper {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("stauts") Integer stauts);

    int insert(ClassRoom record);

    int insertSelective(ClassRoom record);

    ClassRoom selectByPrimaryKey(@Param("id") Integer id, @Param("stauts") Integer stauts);

    int updateByPrimaryKeySelective(ClassRoom record);

    int updateByPrimaryKey(ClassRoom record);

    int deleteByPrimaryKey(Integer id);

    ClassRoom selectByPrimaryKey(Integer id);

    List<ClassRoom> findAllClassRoom();
}