package com.banquemisr.utils;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static String getTimeStamp() {
        return dateFormat.format(System.currentTimeMillis());
    }

    public static Timestamp addDays(int days) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        calendar.setTime(timestamp);
        calendar.add(Calendar.DATE, days);
        return new Timestamp(calendar.getTime().getTime());
    }
}
