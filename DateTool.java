package com.ubot.application.util;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTool {


	public static String AdDateTimeFormat(String date, String datepattern, String formet) {
		try {
			LocalDateTime dateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(datepattern));
			return dateTime.format(DateTimeFormatter.ofPattern(formet));
		} catch (DateTimeException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//取得現在時間並轉呈指定格式
	public String getNowDateTime() {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		return strDate;
	}

}
