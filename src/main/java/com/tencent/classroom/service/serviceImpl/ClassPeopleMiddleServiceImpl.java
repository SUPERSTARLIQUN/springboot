package com.tencent.classroom.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.tencent.classroom.pojo.ClassPeopleMiddle;
import com.tencent.classroom.mapper.ClassPeopleMiddleMapper;
import com.tencent.classroom.service.ClassPeopleMiddleService;
@Service
public class ClassPeopleMiddleServiceImpl implements ClassPeopleMiddleService{

    @Resource
    private ClassPeopleMiddleMapper classPeopleMiddleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return classPeopleMiddleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ClassPeopleMiddle record) {
        return classPeopleMiddleMapper.insert(record);
    }

    @Override
    public int insertSelective(ClassPeopleMiddle record) {
        return classPeopleMiddleMapper.insertSelective(record);
    }

    @Override
    public ClassPeopleMiddle selectByPrimaryKey(Integer id) {
        return classPeopleMiddleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ClassPeopleMiddle record) {
        return classPeopleMiddleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ClassPeopleMiddle record) {
        return classPeopleMiddleMapper.updateByPrimaryKey(record);
    }

}
