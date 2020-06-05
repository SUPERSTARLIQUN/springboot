package com.whkj.project.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.whkj.project.entity.Menu;
import com.whkj.project.mapper.MenuMapper;
import com.whkj.project.service.MenuService;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{

    @Resource
    private MenuMapper menuMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Menu record) {
        return menuMapper.insert(record);
    }

    @Override
    public int insertSelective(Menu record) {
        return menuMapper.insertSelective(record);
    }

    @Override
    public Menu selectByPrimaryKey(Integer id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return menuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return menuMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Menu> findUserMenu(String primaryPrincipal) {
        return menuMapper.findUserMenu(primaryPrincipal);
    }

}
