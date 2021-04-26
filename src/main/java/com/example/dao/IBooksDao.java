package com.example.dao;

import com.example.model.SysBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface IBooksDao {
       // 分页查询
       List<SysBook> pageSysBook(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

       // 分页查询
       Integer countDyInteger ();


       // 新增
       int addBook(@Param("sysBook") SysBook sysBook);
       // 查询
       List<SysBook> select(SysBook sysBook);
       // 根据ID查询
       SysBook getBooksById(@Param("booksId") Integer booksId);
       // 修改
       Integer updateBooks(@Param("sysBook") SysBook sysBook);
       // 删除
       Integer deleteBooks(@Param("booksId") Integer booksId);

       // 根据id 判断歌曲名是否重复
       SysBook findSysUserByName(String booksName);

}
