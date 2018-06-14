package com.jdbc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    /*
     * 根据指定的年月日设置时间（Date）
     */
    public static Date setTime(int year, int month, int day) {
        // 创建calendar对象
        Calendar cal = Calendar.getInstance();
        // 设置年月日
        cal.set(year, month - 1, day);
        return cal.getTime();
    }

    /*
     * 将给定的Date按照给定的格式格式化
     */
    public static String formatDate(Date date, String pattern) {
        if (date != null && pattern != null && !"".equals(pattern)) {
            return new SimpleDateFormat(pattern).format(date);
        }
        return "";
    }

    /*
     * 将给定的字符串按照给定的格式转换成Date
     */
    public static Date parseDate(String str, String pattern) throws ParseException {
        if (str != null && !"".equals(str) 
                && pattern != null && !"".equals(pattern)) {
            return new SimpleDateFormat(pattern).parse(str);
        }
        return null;
    }
}
