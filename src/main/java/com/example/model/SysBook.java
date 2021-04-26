package com.example.model;

import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;

/** 图书java Big
 * @ClassName SysBook
 * @Description TODO
 * @Author 86132
 * @Date 2020/12/8 23:44
 **/
@Data
public class SysBook {

    // 图书id
    private Integer booksId;



    // 图书编号
    private Integer booksNumber;

    // 图书名称
    private String booksName;

    // 图书类别
    private String booksCategory;

    // 图书单价
    private Double booksUnitprice;

    // 创建时间
    private Timestamp createTime;

    // 图书封面
    private String booksCover;

    // 图书作者
    private String booksAuthor;

    // 操作人id
    private Integer userId;
}
