package com.tencent.classroom.service.serviceImpl;

import com.tencent.classroom.config.TLSSigAPIv2;
import com.tencent.classroom.utils.MD5Util;
import com.tencent.classroom.utils.RestResult;
import com.tencent.classroom.vo.TencentVo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.tencent.classroom.mapper.UserMapper;
import com.tencent.classroom.pojo.User;
import com.tencent.classroom.service.UserService;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        record.setPassword(MD5Util.getMD5(record.getPassword()));
        record.setCreateTime(new Date());
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(User user) {
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        return userMapper.selectByPrimaryKey(user);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }
}




