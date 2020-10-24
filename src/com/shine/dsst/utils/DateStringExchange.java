package com.shine.dsst.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateStringExchange {
	
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private final static SimpleDateFormat sd = new SimpleDateFormat("mm:ss");
	public static String dateToString(Date date) {
		return sdf.format(date);
	}
	public static Date dateToString(String s) {
		try {
			return sdf.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static String dateToString_ms(Date date) {
		return sd.format(date);
	}
	public static Date dateToString_ms(String s) {
		try {
			return sd.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
