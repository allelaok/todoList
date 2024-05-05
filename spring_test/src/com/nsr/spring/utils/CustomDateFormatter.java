package com.nsr.spring.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.springframework.format.Formatter;

public class CustomDateFormatter implements Formatter<Date>{


    private final SimpleDateFormat dateFormat;
    private final String pattern;

    public CustomDateFormatter(String pattern) {
        this.pattern = pattern;
        this.dateFormat = new SimpleDateFormat(pattern);
    }

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        return (Date) dateFormat.parse(text);
    }

    @Override
    public String print(Date object, Locale locale) {
        return dateFormat.format(object);
    }
    
}
