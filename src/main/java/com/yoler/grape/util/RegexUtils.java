package com.yoler.grape.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式校验工具类
 */
public class RegexUtils {

    /**
     * 验证由数字、26个英文字母、下划线组成的字符串
     *
     * @param toValidate
     * @return
     */
    public static boolean checkEngNum_(String toValidate) {
        String regEx = "^\\w+$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(toValidate);
        return matcher.matches();
    }
}
