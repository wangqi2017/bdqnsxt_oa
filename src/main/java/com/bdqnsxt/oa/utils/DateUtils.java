package com.bdqnsxt.oa.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Date getStartTime(Date date) {
        if(date==null){
            return null;
        }
        Calendar dayStart = Calendar.getInstance();
        dayStart.setTime(date);
        dayStart.set(Calendar.HOUR_OF_DAY, 0);
        dayStart.set(Calendar.MINUTE, 0);
        dayStart.set(Calendar.SECOND, 0);
        dayStart.set(Calendar.MILLISECOND, 0);
        return dayStart.getTime();
    }

    public static Date getEndTime(Date date) {
        if(date==null){
            return null;
        }
        Calendar dayEnd = Calendar.getInstance();
        dayEnd.setTime(date);
        dayEnd.set(Calendar.HOUR_OF_DAY, 23);
        dayEnd.set(Calendar.MINUTE, 59);
        dayEnd.set(Calendar.SECOND, 59);
        dayEnd.set(Calendar.MILLISECOND, 999);
        return dayEnd.getTime();
    }

    public static Date getTodayStartTime() {
        return getStartTime(new Date());
    }

    public static Date getTodayEndTime() {
        return getEndTime(new Date());
    }
}
