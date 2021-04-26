package com.example.service.impl;

import com.example.dao.IBooksDao;
import com.example.model.SysBook;
import com.example.model.SysUser;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BooksServiceImpl implements IBookService {

    @Autowired
    private IBooksDao booksDao;


    @Override
    public List<SysBook> pageSongVo(int startIndex, int pageSize) {
        return booksDao.pageSysBook(startIndex,pageSize);
    }

    @Override
    public Integer countDyInteger() {
        return booksDao.countDyInteger();
    }

    public int addBook(SysBook sysBook) {
        return booksDao.addBook(sysBook);
    }

    @Override
    public List<SysBook> select(SysBook sysBook) {
        return booksDao.select(sysBook);
    }


    public SysBook getBooksById(Integer booksId) {
        return booksDao.getBooksById(booksId);
    }


    public Integer updateBooks(SysBook sysBook) {
        return booksDao.updateBooks(sysBook);
    }


    public Integer deleteBooks(Integer booksId) {
        return booksDao.deleteBooks(booksId);
    }

    @Override
    public boolean findSysUserByName(String booksName) {
        SysBook sysBook = booksDao.findSysUserByName(booksName);
        return sysBook != null;
    }
}
