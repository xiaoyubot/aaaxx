package com.example.service;



import com.example.model.SysBook;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


public interface IBookService {

    List<SysBook> pageSongVo(int startIndex, int pageSize);

    Integer countDyInteger ();

    int addBook (SysBook sysBook);

    List<SysBook> select(SysBook sysBook);

    SysBook getBooksById (Integer booksId);

    Integer updateBooks(SysBook sysBook);

    Integer deleteBooks(Integer booksId);

    boolean findSysUserByName(String booksName);
}
