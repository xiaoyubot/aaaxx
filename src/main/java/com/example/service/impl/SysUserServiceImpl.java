package com.example.service.impl;

import com.example.dao.SysUserDao;
import com.example.model.SysUser;
import com.example.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;


    @Override
    public int register(SysUser sysUser) {
        return sysUserDao.register(sysUser);
    }

    @Override
    public boolean findSysUserByName(String userName) {
        SysUser sysUser = sysUserDao.findSysUserByName(userName);
        return sysUser != null;
    }

    @Override
    public SysUser login(String username, String password) {
        return sysUserDao.login(username,password);
    }
}
