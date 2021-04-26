package com.example.controller;

import cn.hutool.core.util.StrUtil;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONUtil;
import com.example.model.SysUser;
import com.example.service.SysUserService;

import com.example.util.IdcardNoCheckUtil;
import com.example.util.MailBoxCheckUtil;
import com.example.util.PhoneNumCheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 用户相关controller（包含注册、登录等方法）
 */
@Controller
    @RequestMapping("/sysUser")
@ResponseBody
@CrossOrigin
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 注册方法
     * @param sysUser
     * @return
     */
    @RequestMapping("/register")
    private String register(SysUser sysUser) {
        Map<String, Object> map = new HashMap<>();
     if (sysUser.getUserName() == null || sysUser.getPassWord() == null){
             map.put("success", false);
             map.put("message", "参数存在空值");
             return JSONUtil.toJsonStr(map);
         }
            //1.校验用户名是否重复
            boolean flag = sysUserService.findSysUserByName(sysUser.getUserName());
            if (flag) {
                map.put("fail", false);
                map.put("message", "用户名已存在");
                return JSONUtil.toJsonStr(map);
            }
//            //2.校验手机号，这里只是对大陆手机号进行校验，需要除大陆以外的修改方法即可
//            if (!PhoneNumCheckUtil.isChinaPhoneLegal(sysUser.getPhoneNumber())) {
//                map.put("fail", false);
//                map.put("message", "手机号不合法");
//                return JSONUtil.toJsonStr(map);
//            }
//            //3.校验身份证号是否合法
//            if (!IdcardNoCheckUtil.identityCardNumber(sysUser.getIdcardNo())) {
//                map.put("fail", false);
//                map.put("message", "身份证不合法");
//                return JSONUtil.toJsonStr(map);
//            }
//            //4.校验邮箱是否合法
//            if (!MailBoxCheckUtil.mailboxVerification(sysUser.getMailBox())) {
//                map.put("fail", false);
//                map.put("message", "邮箱不合法");
//                return JSONUtil.toJsonStr(map);
//            }
            // 对用户密码MD5加密
            sysUser.setPassWord(SecureUtil.md5(sysUser.getPassWord()));
            Integer integer = sysUserService.register(sysUser);
            if (integer > 0) {
                map.put("success", true);
                map.put("message", "注册成功");
                return JSONUtil.toJsonStr(map);
            } else {
                map.put("fail", false);
                map.put("message", "注册失败");
                return JSONUtil.toJsonStr(map);
            }
        }

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    private String login (String username, String password) {
        Map<String, Object> map = new HashMap<>();
        if (StrUtil.hasBlank(username,password)) {
            map.put("fail", false);
            map.put("message", "参数存在空值");
            return JSONUtil.toJsonStr(map);
        }
        password = SecureUtil.md5(password);
        SysUser sysUser = sysUserService.login(username, password);

        // TODO 一般这里会把对象返回给前端
        if (sysUser == null) {
            map.put("fail", false);
            map.put("message", "用户名或者密码错误");
            return JSONUtil.toJsonStr(map);
        }else {
            map.put("success", true);
            map.put("message", "登录成功");
            return JSONUtil.toJsonStr(map);
        }
    }
}
