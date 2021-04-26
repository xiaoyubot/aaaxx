package com.example.util;

import com.example.model.SysUser;
import org.apache.ibatis.ognl.ParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @ClassName IdcardNoCheckUtil
 * @Description TODO
 * @Author 86132
 * @Date 2020/12/9 22:15
 **/
public class IdcardNoCheckUtil {
    private static final Pattern CHINA_PATTERN = Pattern.compile("(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +

            "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)");

    public static  boolean  identityCardNumber(String str)throws PatternSyntaxException {
        Matcher m = CHINA_PATTERN.matcher(str);
        return m.matches();
    }


}

