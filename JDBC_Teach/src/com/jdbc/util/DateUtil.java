package com.jdbc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    /*
     * ����ָ��������������ʱ�䣨Date��
     */
    public static Date setTime(int year, int month, int day) {
        // ����calendar����
        Calendar cal = Calendar.getInstance();
        // ����������
        cal.set(year, month - 1, day);
        return cal.getTime();
    }

    /*
     * ��������Date���ո����ĸ�ʽ��ʽ��
     */
    public static String formatDate(Date date, String pattern) {
        if (date != null && pattern != null && !"".equals(pattern)) {
            return new SimpleDateFormat(pattern).format(date);
        }
        return "";
    }

    /*
     * ���������ַ������ո����ĸ�ʽת����Date
     */
    public static Date parseDate(String str, String pattern) throws ParseException {
        if (str != null && !"".equals(str) 
                && pattern != null && !"".equals(pattern)) {
            return new SimpleDateFormat(pattern).parse(str);
        }
        return null;
    }
}
