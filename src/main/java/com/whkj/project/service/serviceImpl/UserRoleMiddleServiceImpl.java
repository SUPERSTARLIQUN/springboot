package com.whkj.project.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.whkj.project.entity.UserRoleMiddle;
import com.whkj.project.mapper.UserRoleMiddleMapper;
import com.whkj.project.service.UserRoleMiddleService;
@Service
public class UserRoleMiddleServiceImpl implements UserRoleMiddleService{

    @Resource
    private UserRoleMiddleMapper userRoleMiddleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userRoleMiddleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserRoleMiddle record) {
        return userRoleMiddleMapper.insert(record);
    }

    @Override
    public int insertSelective(UserRoleMiddle record) {
        return userRoleMiddleMapper.insertSelective(record);
    }

    @Override
    public UserRoleMiddle selectByPrimaryKey(Integer id) {
        return userRoleMiddleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserRoleMiddle record) {
        return userRoleMiddleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserRoleMiddle record) {
        return userRoleMiddleMapper.updateByPrimaryKey(record);
    }

}
