package com.example.service;


import com.example.model.SysUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface SysUserService {

    int register(SysUser sysUser);

    boolean findSysUserByName(String userName);

    SysUser login (String username , String password);
}
