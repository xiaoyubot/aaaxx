package com.example.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @ClassName MailBoxCheckUtil
 * @Description TODO
 * @Author 86132
 * @Date 2020/12/9 23:40
 **/
public class MailBoxCheckUtil {
    private static final Pattern CHINA_PATTERN = Pattern.compile("\\w+@(\\w+\\.)+\\w+$");

    public static  boolean  mailboxVerification(String str)throws PatternSyntaxException {
        Matcher m = CHINA_PATTERN.matcher(str);
        return m.matches();
    }
}
