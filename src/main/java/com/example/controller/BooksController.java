package com.example.controller;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.example.model.SysBook;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 图书相关controller （新增图书方法  查询图书方法  根据id查询图书方法  修改图书方法）
 * @RestController == @Controller + @ResponseBody
 */

@Controller
@RequestMapping("/books")
@ResponseBody
@CrossOrigin // 解决了前端跨域的问题
public class BooksController {

    @Resource
    private IBookService iBookService;

    /**
     * 新增方法
     * @param sysBook
     * @return
     */

    @RequestMapping("/add")
    private String addBook(SysBook sysBook) {
        Map<String, Object> map = new HashMap<>();
        if (StrUtil.hasBlank(sysBook.getBooksName(), sysBook.getBooksCategory()) || sysBook.getBooksNumber() == null || sysBook.getBooksUnitprice() == null) {
            map.put("success", false);
            map.put("message", "参数存在空值");
            return JSONUtil.toJsonStr(map);
        }
        // 判断歌曲名是否重复
        boolean flag = iBookService.findSysUserByName(sysBook.getBooksName());
        if (flag) {
            map.put("fail", false);
            map.put("message", "图书已存在");
            return JSONUtil.toJsonStr(map);
        }
        Integer integer = iBookService.addBook(sysBook);
        if (integer > 0) {
            map.put("success", true);
            map.put("message", "新增成功");
            return JSONUtil.toJsonStr(map);
        } else {
            map.put("fail", false);
            map.put("message", "新增失败");
            return JSONUtil.toJsonStr(map);
        }
    }
    //  分页查询
    @RequestMapping("/findPage")
    public String findPage(@RequestParam("currentPage") Integer currentPage,
                           @RequestParam("pageSize") Integer pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (currentPage == null || pageSize == null) {
            map.put("success", false);
            map.put("message", "参数存在空值");
        }
        if (currentPage <= 0) {
            currentPage = 1;
        }
        int count = iBookService.countDyInteger();
        if (count > 0) {
            // 分页查询的数据、总页数
            // 起始索引 = （当前页 -1 ） * 页大小
            Integer startIndex = (currentPage - 1) * pageSize;
            // 最大整数页 = 总条数 / 总页数
            // 总页数 = 最大整数页 + （总条数 % 总页数 > 0 ? 1 : 0）
            Integer totalPage = count / pageSize;
            totalPage = count % pageSize > 0 ? totalPage + 1 : totalPage;
            List<SysBook> sysBooks = iBookService.pageSongVo(startIndex, pageSize);
            map.put("success", true);
            map.put("message", "查询成功");
            map.put("data", sysBooks);
            map.put("totalPage", totalPage);
        } else {
            map.put("success", false);
            map.put("message", "查询的数据为空");
        }
        return JSONUtil.toJsonStr(map);
    }
    /**
     * 查询图书方法
     */
    @GetMapping("/list")
    private String list(SysBook sysBook){
        Map<String, Object> map = new HashMap<>();
        List<SysBook> sysBooks = this.iBookService.select(sysBook);
        if (sysBooks != null && sysBooks.size() > 0) {
            map.put("success", true);
            map.put("message", "查询成功");
            map.put("data", sysBooks);
        } else {
            map.put("success", false);
            map.put("message", "查询失败");
        }
        return JSONUtil.toJsonStr(map);
    }
    /**
     *根据用户id查询数据
     */
    @RequestMapping("/getById")
    private String getById(Integer booksId) {
        Map<String, Object> map = new HashMap<>();
        if (booksId == null ) {
            map.put("success", false);
            map.put("message", "参数存在空值");
            return JSONUtil.toJsonStr(map);
        }
        SysBook sysBook = iBookService.getBooksById(booksId);
        if (sysBook != null ) {
            map.put("success", true);
            map.put("message", "查询成功");
            map.put("data", sysBook);
            return JSONUtil.toJsonStr(map);
        } else {
            map.put("success", false);
            map.put("message", "查询失败");
            return JSONUtil.toJsonStr(map);
        }
    }

    /**
     * 修改
     * @param sysBook
     * @return
     */
    @RequestMapping("/update")
    private String update(SysBook sysBook) {
        Map<String, Object> map = new HashMap<>();
        if (StrUtil.hasBlank(sysBook.getBooksName(), sysBook.getBooksCategory()) || sysBook.getBooksNumber() == null || sysBook.getBooksUnitprice() == null || sysBook.getBooksId() == null) {
            map.put("success", false);
            map.put("message", "参数存在空值");
            return JSONUtil.toJsonStr(map);
        }
        Integer integer = iBookService.updateBooks(sysBook);
        if (integer > 0) {
            map.put("success", true);
            map.put("message", "修改成功");
            return JSONUtil.toJsonStr(map);
        } else {
            map.put("success", false);
            map.put("message", "修改失败");
            return JSONUtil.toJsonStr(map);
        }
    }
    @RequestMapping("/delete")
    private String delete(Integer booksId) {
        Map<String, Object> map = new HashMap<>();
        if (booksId == null ) {
            map.put("success", false);
            map.put("message", "参数存在空值");
            return JSONUtil.toJsonStr(map);
        }
        Integer integer = iBookService.deleteBooks(booksId);
        if (integer > 0) {
            map.put("success", true);
            map.put("message", "删除成功");
            return JSONUtil.toJsonStr(map);
        } else {
            map.put("success", false);
            map.put("message", "删除失败");
            return JSONUtil.toJsonStr(map);
        }
    }
    @GetMapping("/hello")
    public String hello () {
        return "欢迎访问 hello";
    }

    @GetMapping("/helloAdmin")
    @PreAuthorize("hasAnyRole('admin')")
    public String hellodmin () {
        return "欢迎访问 helloAdmin";
    }
    @GetMapping("/helloUser")
    @PreAuthorize("hasAnyRole('normal','admin')")
    public String helloUser () {
        return "欢迎访问 helloUser";
    }
}
