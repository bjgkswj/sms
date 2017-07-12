package org.sms.util;

import java.util.Calendar;
import java.util.Date;

public class CommonUtil {
	/**
	* 从身份证获取出生日期
	* @param cardNumber 已经校验合法的身份证号
	* @return Strig YYYY-MM-DD 出生日期
	*/
	public static String getBirthDateFromCard(String cardNumber){
		if(cardNumber != null && !"".equals(cardNumber)){
			String card = cardNumber.trim();
		
		    String year;
		    String month;
		    String day;
		    if (card.length()==18){ //处理18位身份证
		        year=card.substring(6,10);
		        month=card.substring(10,12);
		        day=card.substring(12,14);
		    }else{ //处理非18位身份证
		    year=card.substring(6,8);
		        month=card.substring(8,10);
		        day=card.substring(10,12);
		    year="19"+year;        
		    }
		    if (month.length()==1){
		        month="0"+month; //补足两位
		    }
		    if (day.length()==1){
		        day="0"+day; //补足两位
		    }
		    return year+"-"+month+"-"+day;
		}
		return "";
	}
	
	/**
	 * 计算两个日期之间相差的天数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int daysBetween(Date date1,Date date2){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		long time1 = cal.getTimeInMillis();
		cal.setTime(date2);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2-time1)/(1000*3600*24);
		
		return Integer.parseInt(String.valueOf(between_days));
	}
}