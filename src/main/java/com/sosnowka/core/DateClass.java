package com.sosnowka.core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Pawel on 27.11.2017.
 */
public class DateClass {
    public boolean isAfterNowday(String afterDay) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(afterDay);
        Date nowday = new Date();
        if(date.after(nowday))
            return true;
        return false;
    }
}
