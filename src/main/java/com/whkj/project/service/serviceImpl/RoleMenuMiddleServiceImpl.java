package com.whkj.project.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.whkj.project.entity.RoleMenuMiddle;
import com.whkj.project.mapper.RoleMenuMiddleMapper;
import com.whkj.project.service.RoleMenuMiddleService;
@Service
public class RoleMenuMiddleServiceImpl implements RoleMenuMiddleService{

    @Resource
    private RoleMenuMiddleMapper roleMenuMiddleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return roleMenuMiddleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RoleMenuMiddle record) {
        return roleMenuMiddleMapper.insert(record);
    }

    @Override
    public int insertSelective(RoleMenuMiddle record) {
        return roleMenuMiddleMapper.insertSelective(record);
    }

    @Override
    public RoleMenuMiddle selectByPrimaryKey(Integer id) {
        return roleMenuMiddleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RoleMenuMiddle record) {
        return roleMenuMiddleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RoleMenuMiddle record) {
        return roleMenuMiddleMapper.updateByPrimaryKey(record);
    }

}
