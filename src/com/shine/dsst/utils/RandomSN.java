package com.shine.dsst.utils;

import java.util.Date;

public class RandomSN {
	
	public static String getRandomSn() {
		
		Date date = new Date();
		long time = date.getTime();
		time += (Math.random()*10000 + 1);
		return String.valueOf(time);
		
	}

}
