package com.sosnowka.core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Pawel on 27.11.2017.
 */
public class DateClass {
    public boolean isAfterNowday(String afterDay) throws ParseException {
        LocalDate date = LocalDate.parse(afterDay);
        LocalDate nowday = LocalDate.now();

        if(!nowday.isAfter(date))
            return true;
        return false;
    }
}
