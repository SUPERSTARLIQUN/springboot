package com.tencent.classroom.service.serviceImpl;

import com.tencent.classroom.utils.MD5Util;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.tencent.classroom.mapper.ClassRoomMapper;
import com.tencent.classroom.pojo.ClassRoom;
import com.tencent.classroom.service.ClassRoomService;
import sun.security.provider.MD5;

import java.util.Date;
import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    @Resource
    private ClassRoomMapper classRoomMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return classRoomMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ClassRoom record) {
        return classRoomMapper.insert(record);
    }

    @Override
    public int insertSelective(ClassRoom record) {
        record.setPassword(MD5Util.getMD5(record.getPassword()));
        record.setCreateTime(new Date());
        return classRoomMapper.insertSelective(record);
    }

    @Override
    public ClassRoom selectByPrimaryKey(Integer id) {
        return classRoomMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ClassRoom record) {
        return classRoomMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ClassRoom record) {
        return classRoomMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id, Integer stauts) {
        return classRoomMapper.deleteByPrimaryKey(id, stauts);
    }

    @Override
    public ClassRoom selectByPrimaryKey(Integer id, Integer stauts) {
        return classRoomMapper.selectByPrimaryKey(id, stauts);
    }

    @Override
    public List<ClassRoom> findAllClassRoom() {
        return classRoomMapper.findAllClassRoom();
    }
}

