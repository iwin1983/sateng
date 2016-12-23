package com.xuke.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	public static String getCurrentTime() {
		String timeStr = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		timeStr = sdf.format(date);
		return timeStr;
	}
}
