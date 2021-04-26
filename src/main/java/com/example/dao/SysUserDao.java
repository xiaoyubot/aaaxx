package com.example.dao;

import com.example.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserDao {

        int register(@Param("sysUser") SysUser sysUser);

        SysUser findSysUserByName(String userName);

        SysUser login(@Param("username") String username, @Param("password") String password);
}
