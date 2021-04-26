package com.example.model;


import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class SysUser {

//    用户id
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDeteofBirth() {
        return deteofBirth;
    }

    public void setDeteofBirth(Date deteofBirth) {
        this.deteofBirth = deteofBirth;
    }

    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    public String getUserAvate() {
        return userAvate;
    }

    public void setUserAvate(String userAvate) {
        this.userAvate = userAvate;
    }

    public String getMailBox() {
        return mailBox;
    }

    public void setMailBox(String mailBox) {
        this.mailBox = mailBox;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    // 用户名
        private String userName;

    // 密码
    private String passWord;

    // 真实姓名
    private String userRealname;

    // 手机号码
    private String phoneNumber;

    // 出生日期
    private Date deteofBirth;

    // 个人简介
    private String personalProfile;

    // 创建时间
    private Timestamp createTime;

    // 身份证号码
    private String  idcardNo;

    // 用户头像
    private String userAvate;

    //电子邮箱
    private String mailBox;

    // 删除标志
    private Integer deleteFlag;

}
