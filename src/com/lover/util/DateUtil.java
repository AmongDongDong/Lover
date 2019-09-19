package com.lover.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String dateToStr(Date date,String pattern){ 
		SimpleDateFormat  simplePattern = new SimpleDateFormat(pattern);
		return simplePattern.format(date);
	}
	public static  Date  strToDate(String date,String pattern) throws ParseException{
		SimpleDateFormat  simplePattern = new SimpleDateFormat(pattern);
		return simplePattern.parse(date);
	}

}
