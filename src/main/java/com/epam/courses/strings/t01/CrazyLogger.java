package com.epam.courses.strings.t01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Date: 23.01.2017
 * @author Karapetyan N.K
 */
@SuppressWarnings("WeakerAccess")
public class CrazyLogger {
    private static StringBuilder info = new StringBuilder();
    private static TimeZone timeZone = TimeZone.getTimeZone("Europe/Moscow");
    private static Calendar calendar =
            new GregorianCalendar(timeZone);
    private static DateFormat dateFormat =
            new SimpleDateFormat("dd-MM-yyyy : HH-mm");

    public static void setLog(@SuppressWarnings("SameParameterValue") String message){
        calendar.setTime(new Date());
        info.append(dateFormat.format(calendar.getTime()));
        info.append(" - ").append(message).append("\n");
    }

    public static String getLog(){
        return info.toString();
    }

    public static String searchLog(@SuppressWarnings("SameParameterValue") String text){
        StringBuilder set = new StringBuilder();
        Pattern p = Pattern.compile((".*"+text+"$"),
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = p.matcher(info);
        while(m.find()){
            set.append(m.group()).append("\n");
        }
        return set.toString();
    }
}
