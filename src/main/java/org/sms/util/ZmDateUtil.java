package org.sms.util;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

/**
 * 日期处理函数
 * 
 * @author zmwu
 * 
 */
public class ZmDateUtil {
	/**
	 * 获取现在的时间
	 * 返回  yyyy年MM月dd日
	 */
	public static String getNowDateForChinese() {

		Date currentTime = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");

		String dateString = formatter.format(currentTime);

		return dateString;

	}
	/**
	 * 
	 * 获取现在时间
	 * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
	 */

	public static Date getNowDate() {

		Date currentTime = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String dateString = formatter.format(currentTime);

		ParsePosition pos = new ParsePosition(8);

		Date currentTime_2 = formatter.parse(dateString, pos);

		return currentTime_2;

	}

	/**
	 * 
	 * 获取现在时间
	 * 
	 * 
	 * 
	 * @return返回短时间格式 yyyy-MM
	 */
	public static String getStringDateYYYY_MM() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 
	 * 获取现在时间
	 * 
	 * 
	 * 
	 * @return返回短时间格式 yyyy
	 */
	public static String getStringDateYYYY() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 
	 * 获取现在时间
	 * 
	 * 
	 * 
	 * @return返回短时间格式 yyyy-MM-dd
	 */

	public static Date getNowDateShort() {

		Date currentTime = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		String dateString = formatter.format(currentTime);

		ParsePosition pos = new ParsePosition(8);

		Date currentTime_2 = formatter.parse(dateString, pos);

		return currentTime_2;

	}

	/**
	 * 
	 * 获取现在时间
	 * 
	 * 
	 * 
	 * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
	 */

	public static String getStringDate() {

		Date currentTime = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String dateString = formatter.format(currentTime);

		return dateString;

	}

	/**
	 * 
	 * 获取现在时间
	 * 
	 * 
	 * 
	 * @return 返回短时间字符串格式yyyy-MM-dd
	 */

	public static String getStringDateShort() {

		Date currentTime = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		String dateString = formatter.format(currentTime);

		return dateString;

	}

	/**
	 * 
	 * 获取时间 小时:分;秒 HH:mm:ss
	 * 
	 * 
	 * 
	 * @return
	 */

	public static String getTimeShort() {

		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

		Date currentTime = new Date();

		String dateString = formatter.format(currentTime);

		return dateString;

	}

	/**
	 * 
	 * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
	 * 
	 * 
	 * 
	 * @param strDate
	 * 
	 * @return
	 */

	public static Date strToDateLong(String strDate) {
		if(StringUtils.isBlank(strDate)){
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		ParsePosition pos = new ParsePosition(0);

		Date strtodate = formatter.parse(strDate, pos);

		return strtodate;

	}

	/**
	 * 
	 * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
	 * 
	 * 
	 * 
	 * @param dateDate
	 * 
	 * @return
	 */

	public static String dateToStrLong(java.util.Date dateDate) {

		if(dateDate == null){
			return "";
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String dateString = formatter.format(dateDate);

		return dateString;

	}

	/**
	 * 
	 * 将长时间格式时间转换为字符串
	 * 
	 * 
	 * 
	 * @param dateDate
	 * 
	 * @param formStr
	 *            格式 yyyy-MM ； yyyy-MM-dd ； yyyy-MM-dd HH ； yyyy-MM-dd HH:mm
	 * 
	 * @return
	 */

	public static String dateToStrLong_FormStr(java.util.Date dateDate,
			String formStr) {

		SimpleDateFormat formatter = new SimpleDateFormat(formStr);

		String dateString = formatter.format(dateDate);

		return dateString;

	}

	/**
	 * 
	 * 将短时间格式时间转换为字符串 yyyy-MM-dd
	 * 
	 * 
	 * 
	 * @param dateDate
	 * 
	 * @param k
	 * 
	 * @return
	 */

	public static String dateToStr(java.util.Date dateDate) {

		if(dateDate == null){
			return "";
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		String dateString = formatter.format(dateDate);

		return dateString;

	}

	/**
	 * 
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd
	 * 
	 * 
	 * 
	 * @param strDate
	 * 
	 * @return
	 */

	public static Date strToDate(String strDate) {

		if(StringUtils.isBlank(strDate)){
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		ParsePosition pos = new ParsePosition(0);

		Date strtodate = formatter.parse(strDate, pos);

		return strtodate;

	}

	/**
	 * 
	 * 得到现在时间
	 * 
	 * 
	 * 
	 * @return
	 */

	public static Date getNow() {

		Date currentTime = new Date();

		return currentTime;

	}

	/**
	 * 
	 * 提取一个月中的最后一天
	 * 
	 * 
	 * 
	 * @param day
	 * 
	 * @return
	 */

	public static Date getLastDate(long day) {

		Date date = new Date();

		long date_3_hm = date.getTime() - 3600000 * 34 * day;

		Date date_3_hm_date = new Date(date_3_hm);

		return date_3_hm_date;

	}

	/**
	 * 
	 * 得到现在时间
	 * 
	 * 
	 * 
	 * @return 字符串 yyyyMMdd HHmmss
	 */

	public static String getStringToday() {

		Date currentTime = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");

		String dateString = formatter.format(currentTime);

		return dateString;

	}

	/**
	 * 
	 * 得到现在小时
	 */

	public static String getHour() {

		Date currentTime = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String dateString = formatter.format(currentTime);

		String hour;

		hour = dateString.substring(11, 13);

		return hour;

	}

	/**
	 * 
	 * 得到现在分钟
	 * 
	 * 
	 * 
	 * @return
	 */

	public static String getTime() {

		Date currentTime = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String dateString = formatter.format(currentTime);

		String min;

		min = dateString.substring(14, 16);

		return min;

	}

	/**
	 * 
	 * 根据用户传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
	 * 
	 * 
	 * 
	 * @param sformat
	 * 
	 *            yyyyMMddhhmmss
	 * 
	 * @return
	 */

	public static String getUserDate(String sformat) {

		Date currentTime = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat(sformat);

		String dateString = formatter.format(currentTime);

		return dateString;

	}

	/**
	 * 
	 * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟
	 */

	public static String getTwoHour(String st1, String st2) {

		String[] kk = null;

		String[] jj = null;

		kk = st1.split(":");

		jj = st2.split(":");

		if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0]))

			return "0";

		else {

			double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1])
					/ 60;

			double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1])
					/ 60;

			if ((y - u) > 0)

				return y - u + "";

			else

				return "0";

		}

	}

	/**
	 * 
	 * 得到二个日期间的间隔天数
	 */

	public static String getTwoDay(String sj1, String sj2) {

		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");

		long day = 0;

		try {

			java.util.Date date = myFormatter.parse(sj1);

			java.util.Date mydate = myFormatter.parse(sj2);

			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);

		} catch (Exception e) {

			return "";

		}

		return day + "";

	}
	
	/**
	 * 
	 * 得到二个时间 间的间隔天数浮点型
	 */

	public static String getTwoDayTime(String sj1, String sj2) {

		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String day = "0";

		try {

			java.util.Date date = myFormatter.parse(sj1);

			java.util.Date mydate = myFormatter.parse(sj2);
			long jgtimes = (date.getTime() - mydate.getTime());
			if(jgtimes < 0){
				jgtimes = jgtimes * -1;
			}
			double bctag = (24 * 60 * 60 * 1000*1.0);
			day = String.format("%.1f",(double)(jgtimes / bctag));
		} catch (Exception e) {

			return "0";

		}

		return day + "";

	}
	

	/**
	 * 
	 * 时间前推或后推分钟,其中JJ表示分钟.
	 */

	public static String getPreTime(String sj1, String jj) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String mydate1 = "";

		try {

			Date date1 = format.parse(sj1);

			long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;

			date1.setTime(Time * 1000);

			mydate1 = format.format(date1);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mydate1;

	}

	/**
	 * 
	 * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
	 */

	public static String getNextDay(String nowdate, String delay) {

		try {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			String mdate = "";

			Date d = strToDate(nowdate);

			long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24
					* 60 * 60;

			d.setTime(myTime * 1000);

			mdate = format.format(d);

			return mdate;

		} catch (Exception e) {

			return "";

		}

	}

	/**
	 * 
	 * 判断是否润年
	 * 
	 * 
	 * 
	 * @param ddate
	 * 
	 * @return
	 */

	public static boolean isLeapYear(String ddate) {

		/**
		 * 
		 * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
		 * 
		 * 3.能被4整除同时能被100整除则不是闰年
		 */

		Date d = strToDate(ddate);

		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();

		gc.setTime(d);

		int year = gc.get(Calendar.YEAR);

		if ((year % 400) == 0)

			return true;

		else if ((year % 4) == 0) {

			if ((year % 100) == 0)

				return false;

			else

				return true;

		} else

			return false;

	}

	/**
	 * 
	 * 返回美国时间格式 26 Apr 2006
	 * 
	 * 
	 * 
	 * @param str
	 * 
	 * @return
	 */

	public static String getEDate(String str) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		ParsePosition pos = new ParsePosition(0);

		Date strtodate = formatter.parse(str, pos);

		String j = strtodate.toString();

		String[] k = j.split(" ");

		return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);

	}

	/**
	 * 
	 * 获取一个月的最后一天
	 * 
	 * 
	 * 
	 * @param dat
	 * 
	 * @return
	 */

	public static String getEndDateOfMonth(String dat) {// yyyy-MM-dd

		String str = dat.substring(0, 8);

		String month = dat.substring(5, 7);

		int mon = Integer.parseInt(month);

		if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8
				|| mon == 10 || mon == 12) {

			str += "31";

		} else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {

			str += "30";

		} else {

			if (isLeapYear(dat)) {

				str += "29";

			} else {

				str += "28";

			}

		}

		return str;

	}

	/**
	 * 
	 * 判断二个时间是否在同一个周
	 * 
	 * 
	 * 
	 * @param date1
	 * 
	 * @param date2
	 * 
	 * @return
	 */

	public static boolean isSameWeekDates(Date date1, Date date2) {

		Calendar cal1 = Calendar.getInstance();

		Calendar cal2 = Calendar.getInstance();

		cal1.setTime(date1);

		cal2.setTime(date2);

		int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);

		if (0 == subYear) {

			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))

				return true;

		} else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {

			// 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周

			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))

				return true;

		} else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {

			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))

				return true;

		}

		return false;

	}

	/**
	 * 
	 * 产生周序列,即得到当前时间所在的年度是第几周
	 * 
	 * 
	 * 
	 * @return
	 */

	public static String getSeqWeek() {

		Calendar c = Calendar.getInstance(Locale.CHINA);

		String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));

		if (week.length() == 1)

			week = "0" + week;

		String year = Integer.toString(c.get(Calendar.YEAR));

		return year + week;

	}

	/**
	 * 
	 * 获得一个日期所在的周的星期几的日期，如要找出2002年2月3日所在周的星期一是几号
	 * 
	 * 
	 * 
	 * @param sdate
	 * 
	 * @param num
	 * 
	 * @return
	 */

	public static String getWeek(String sdate, String num) {

		// 再转换为时间

		Date dd = ZmDateUtil.strToDate(sdate);

		Calendar c = Calendar.getInstance();

		c.setTime(dd);

		if (num.equals("1")) // 返回星期一所在的日期

			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

		else if (num.equals("2")) // 返回星期二所在的日期

			c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);

		else if (num.equals("3")) // 返回星期三所在的日期

			c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);

		else if (num.equals("4")) // 返回星期四所在的日期

			c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);

		else if (num.equals("5")) // 返回星期五所在的日期

			c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);

		else if (num.equals("6")) // 返回星期六所在的日期

			c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);

		else if (num.equals("0")) // 返回星期日所在的日期

			c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());

	}

	/**
	 * 
	 * 根据一个日期，返回是星期几的字符串
	 * 
	 * 
	 * 
	 * @param sdate
	 * 
	 * @return
	 */

	public static String getWeek(String sdate) {

		// 再转换为时间

		Date date = ZmDateUtil.strToDate(sdate);

		Calendar c = Calendar.getInstance();

		c.setTime(date);

		// int hour=c.get(Calendar.DAY_OF_WEEK);

		// hour中存的就是星期几了，其范围 1~7

		// 1=星期日 7=星期六，其他类推

		return new SimpleDateFormat("EEEE").format(c.getTime());

	}

	/**
	 * 
	 * 根据一个日期，返回该日期在是第几周
	 * 
	 * 
	 * 
	 * @param sdate
	 * 
	 * @return
	 */

	public static String getWeekByDate(String sdate) {

		// 再转换为时间

		Date date = ZmDateUtil.strToDate(sdate);

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.WEEK_OF_YEAR) + "";

	}

	public static String getWeekStr(String sdate) {

		String str = "";

		str = ZmDateUtil.getWeek(sdate);

		if ("1".equals(str)) {

			str = "星期日";

		} else if ("2".equals(str)) {

			str = "星期一";

		} else if ("3".equals(str)) {

			str = "星期二";

		} else if ("4".equals(str)) {

			str = "星期三";

		} else if ("5".equals(str)) {

			str = "星期四";

		} else if ("6".equals(str)) {

			str = "星期五";

		} else if ("7".equals(str)) {

			str = "星期六";

		}

		return str;

	}

	/**
	 * 
	 * 两个时间之间的天数
	 * 
	 * 
	 * 
	 * @param date1
	 * 
	 * @param date2
	 * 
	 * @return
	 */

	public static long getDays(String date1, String date2) {

		if (date1 == null || date1.equals(""))

			return 0;

		if (date2 == null || date2.equals(""))

			return 0;

		// 转换为标准时间

		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");

		java.util.Date date = null;

		java.util.Date mydate = null;

		try {

			date = myFormatter.parse(date1);

			mydate = myFormatter.parse(date2);

		} catch (Exception e) {

		}

		long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);

		return day;

	}
	
	/**
	 * 获取两个时间 之间间隔的 周数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getWeeks(String endDate, String fromdate) {
		
		if(StringUtils.isEmpty(endDate) || StringUtils.isEmpty(endDate)){
			return 0;
		}
		
		Long days = getDays(endDate,fromdate);
		if(days == 0){
			return 0;
		}
		if(days < 7 || days == 7){
			return 1;
		}
		Long ots = days % 7;
		if(ots != 0){
			return days / 7;
		}
		
		return (days / 7);
	}
	
	
	/**
	 * 
	 * 形成如下的日历 ， 根据传入的一个时间返回一个结构 星期日 星期一 星期二 星期三 星期四 星期五 星期六 下面是当月的各个时间
	 * 
	 * 此函数返回该日历第一行星期日所在的日期
	 * 
	 * 
	 * 
	 * @param sdate
	 * 
	 * @return
	 */

	public static String getNowMonth(String sdate) {

		// 取该时间所在月的一号

		sdate = sdate.substring(0, 8) + "01";

		// 得到这个月的1号是星期几

		Date date = ZmDateUtil.strToDate(sdate);

		Calendar c = Calendar.getInstance();

		c.setTime(date);

		int u = c.get(Calendar.DAY_OF_WEEK);

		String newday = ZmDateUtil.getNextDay(sdate, (1 - u) + "");

		return newday;

	}

	/**
	 * 
	 * 取得数据库主键 生成格式为yyyymmddhhmmss+k位随机数
	 * 
	 * 
	 * 
	 * @param k
	 * 
	 *            表示是取几位随机数，可以自己定
	 */

	public static String getNo(int k) {

		return getUserDate("yyyyMMddhhmmss") + getRandom(k);

	}

	/**
	 * 
	 * 返回一个随机数
	 * 
	 * 
	 * 
	 * @param i
	 * 
	 * @return
	 */

	public static String getRandom(int i) {

		Random jjj = new Random();

		// int suiJiShu = jjj.nextInt(9);

		if (i == 0)

			return "";

		String jj = "";

		for (int k = 0; k < i; k++) {

			jj = jj + jjj.nextInt(9);

		}

		return jj;

	}

	/**
	 * 获取当月的第一天yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getFirstDayOfMonth() {
		String rsrc = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);
		rsrc = sdf.format(lastDate.getTime());
		return rsrc;
	}

	/**
	 * 获取上个月的第一天yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getFirstDayOfPreMonth() {
		String rsrc = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);
		lastDate.add(Calendar.MONTH, -1);
		rsrc = sdf.format(lastDate.getTime());
		return rsrc;
	}

	/**
	 * 获取下个月的第一天yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getFirstDayOfNextMonth() {
		String rsrc = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);
		lastDate.add(Calendar.MONTH, 1);
		rsrc = sdf.format(lastDate.getTime());
		return rsrc;
	}

	/**
	 * 获取下个月的第N天yyyy-MM-dd
	 * 
	 * @param n
	 * @return
	 */
	public static String getFirstDayOfNextMonth(int n) {
		String rsrc = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, n);
		lastDate.add(Calendar.MONTH, 1);
		rsrc = sdf.format(lastDate.getTime());
		return rsrc;
	}

	/**
	 * 获取上个月的最后一天
	 * 
	 * @return
	 */
	public static String getPreviousMonthEnd() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, -1);// 减一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**
	 * 
	 * 
	 * 
	 * @param args
	 */

	public static boolean RightDate(String date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		;

		if (date == null)

			return false;

		if (date.length() > 10) {

			sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		} else {

			sdf = new SimpleDateFormat("yyyy-MM-dd");

		}

		try {

			sdf.parse(date);

		} catch (ParseException pe) {

			return false;

		}

		return true;

	}

	/**
	 * 时间比较 如果:[ 大于0:dat1>dat2];[ 等于0:dat1=dat2];[ 小于0:dat1<dat2]
	 * 
	 * @param dat1
	 * @param dat2
	 * @return
	 */
	public static int compareDate(String dat1, String dat2) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			java.util.Date date1 = dateFormat.parse(dat1);
			java.util.Date date2 = dateFormat.parse(dat2);

			long l1 = date1.getTime();
			long l2 = date2.getTime();
			if (l1 > l2) {
				return 1;
			}
			if (l1 == l2) {
				return 0;
			}
			if (l1 < l2) {
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

		return 1;
	}

	/**
	 * 获取两个时间之间的 所有日期
	 * 
	 * @param date1
	 *            起始日期
	 * @param date2
	 *            结束日期
	 * @return
	 */
	public static List<String> listBettweenDate(String date1, String date2) {
		List<String> listStr = new ArrayList<String>();
		if ((date1 == null || "".equals(date1.trim()))
				&& (date2 != null && !"".equals(date2.trim()))) {
			listStr.add(date2.split(" ")[0]);
			return listStr;
		}

		listStr.add(date1.split(" ")[0]);
		long days = ZmDateUtil.getDays(date2, date1);
		for (long i = 0; i < days; i++) {
			String xday = ZmDateUtil.getNextDay(date1, (i + 1) + "");
			listStr.add(xday);
		}

		return listStr;

	}


	/**
	 * 获取两个月份之间的 所有月份列表
	 * 
	 * @param date1
	 *            起始月YYYY-MM
	 * @param date2
	 *            结束月YYYY-MM
	 * @return
	 */
	public static List<String> listBettweenMonth(String date1, String date2)
			throws Exception {
		List<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		Date d1 = null;
		Date d2 = null;
		d1 = sdf.parse(date1 + "-0 00:00:00");
		d2 = sdf.parse(date2 + "-0 00:00:00");
		calendar.setTime(d1);
		int start = calendar.get(Calendar.MONTH);
		calendar.setTime(d2);
		int end = calendar.get(Calendar.MONTH);
		if (end < start) {
			return result;
		}

		if (end == start) {
			result.add(date1);
			return result;
		}
		result.add(date1);
		for (int i = start + 1; i < end; i++) {
			calendar.set(Calendar.MONTH, i);
			result.add(sdf.format(calendar.getTime()));
		}
		result.add(date2);
		return result;

	}

	/**
	 * 获取某年的所有月份，如果year为空的话，就是当前年份1月份至现在的月份
	 * 
	 * @param year
	 * @return
	 */
	public static List<String> listMonthBettweenYear(String year) {
		List<String> listStr = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		SimpleDateFormat sdfm = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		int max;
		int xyear;
		if (year == null || "".equals(year.trim())
				|| year.equals("" + calendar.get(Calendar.YEAR))) {
			max = Integer.parseInt(sdf.format(calendar.getTime()));
			xyear = calendar.get(Calendar.YEAR);
		} else {
			max = 12;
			xyear = Integer.parseInt(year);
		}
		for (int i = 0; i < max; i++) {
			calendar.set(Calendar.MONTH, i);
			calendar.set(Calendar.YEAR, xyear);
			listStr.add(sdfm.format(calendar.getTime()));
		}

		return listStr;

	}

	/**
	 * 或去指定日期所在周的下一个月
	 * 
	 * @return
	 */
	public static String findNextMonthByDate(String date) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(date));
		int currmonth = calendar.get(Calendar.MONTH);
		calendar.set(Calendar.MONTH, currmonth + 1);
		String restr = sdf.format(calendar.getTime());

		return restr;
	}

	/**
	 * 计算时间之后的的时间,执行失败的话，会返回 date
	 * 
	 * @param date
	 * @param xfeilt
	 *            "y"：年 "m": 月 "d":天 "h":小时 "mm" 分钟
	 * @param addx
	 *            加的参数值，可以为负数
	 * @return
	 */
	public static String addXFeilt(Date date, String xfeilt, Integer addx) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		String rdate = "";
		calendar.setTime(date);
		if ("y".equals(xfeilt)) {
			int cyear = calendar.get(Calendar.YEAR);
			calendar.set(Calendar.YEAR, cyear + addx);
			rdate = sdf.format(calendar.getTime());
		}
		if ("m".equals(xfeilt)) {
			int cmonth = calendar.get(Calendar.MONTH);
			calendar.set(Calendar.MONTH, cmonth + addx);
			rdate = sdf.format(calendar.getTime());
		}
		if ("d".equals(xfeilt)) {
			int cmonth = calendar.get(Calendar.DAY_OF_YEAR);
			calendar.set(Calendar.DAY_OF_YEAR, cmonth + addx);
			rdate = sdf.format(calendar.getTime());
		}
		if ("h".equals(xfeilt)) {
			int cmonth = calendar.get(Calendar.HOUR_OF_DAY);
			calendar.set(Calendar.HOUR_OF_DAY, cmonth + addx);
			rdate = sdf.format(calendar.getTime());
		}
		if ("mm".equals(xfeilt)) {
			int cmonth = calendar.get(Calendar.MINUTE);
			calendar.set(Calendar.MINUTE, cmonth + addx);
			rdate = sdf.format(calendar.getTime());
		}
		return rdate;
	}

	
	/**
	 * 获取 dateStr所在周的信息(周一~周六 以及下周的第一天（周日）):
	 * @param dateStr  YYYY-MM-DD
	 * @return 返回的数据结构是:[ { 日期,周几 },.... ]
	 */
	public static List<Map<String, String>> getWeekInfoForDateStr(String dateStr){
		
		List<Map<String, String>> _resList = new ArrayList<Map<String,String>>();
		if(StringUtils.isBlank(dateStr)){
			return _resList;
		}
		Date _date = null;
		try{
			_date = ZmDateUtil.strToDate(dateStr);
			Calendar calendar = Calendar.getInstance();
			for(int i = 2; i < 8 ; i++){
				calendar.setTime(_date);
				calendar.set(Calendar.DAY_OF_WEEK, i);
				String _dateStr = calendar.get( Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DATE);
				Map<String, String> _map = new HashMap<String, String>();
				_map.put(_dateStr, ZmDateUtil.getWeek(_dateStr));
				_resList.add(_map);
			}
			calendar.setTime(_date);
			calendar.add(Calendar.WEEK_OF_YEAR, 1);
			calendar.set(Calendar.DAY_OF_WEEK, 1);
			String _dateStr = calendar.get( Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DATE);
			Map<String, String> _map = new HashMap<String, String>();
			_map.put(_dateStr, ZmDateUtil.getWeek(_dateStr));
			_resList.add(_map);
			
			return _resList;
		}catch(Exception e){
			return new ArrayList<Map<String,String>>();
		}
	}
	
	/**
	 * 获取date日期所属周  下一个周 的第一天日期
	 * @param date yyyy-mm-dd
	 * @return
	 */
	public static String getFirstDateOfCurrentWeek(String date){
		if(StringUtils.isBlank(date)){
		   return null;	
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(ZmDateUtil.strToDate(date));
		calendar.add(Calendar.WEEK_OF_YEAR, 1);
		calendar.set(Calendar.DAY_OF_WEEK, 1);
		String _dateStr = calendar.get( Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DATE);
		return _dateStr;
	}
	
	/**
	 * 获取date日期所属周 的上一个周的  最后一天日期
	 * @param date yyyy-mm-dd
	 * @return
	 */
	public static String getLastDateOfCurrentWeek(String date){
		if(StringUtils.isBlank(date)){
		   return null;	
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(ZmDateUtil.strToDate(date));
		calendar.add(Calendar.WEEK_OF_YEAR, -1);
		calendar.set(Calendar.DAY_OF_WEEK, 7);
		String _dateStr = calendar.get( Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DATE);
		return _dateStr;
	}
	
	/**
	 * 获取 固定日期内的周的日期显示
	 * @param date yyyy-mm-dd
	 * @return
	 */
	public static List<Map> getDateBetweenStartDateAndEndDate(String startDate,String endDate){
		if(StringUtils.isBlank(startDate) || StringUtils.isBlank(endDate)){
		   return null;	
		}
		List<Map> nodes=new ArrayList<Map>();
		String[] startStr=startDate.split("-");
		String[] endStr=endDate.split("-");
		
		
		 Calendar c_begin = new GregorianCalendar();
	     Calendar c_end = new GregorianCalendar();
	     DateFormatSymbols dfs = new DateFormatSymbols();
	     String[] weeks = dfs.getWeekdays();
	    
	     c_begin.set(Integer.valueOf(startStr[0]), Integer.valueOf((startStr[1]))-1, Integer.valueOf(startStr[2])); //Calendar的月从0-11，所以4月是3.
	     c_end.set(Integer.valueOf(endStr[0]), Integer.valueOf((endStr[1]))-1, Integer.valueOf(endStr[2])); //Calendar的月从0-11，所以5月是4.

	     int count = 0;
	     String weeStr=getWeek(startDate);
	     if(weeStr.equals("星期一")){
	    	 count=1;
	     }
	     c_end.add(Calendar.DAY_OF_YEAR, 1);  //结束日期下滚一天是为了包含最后一天
	    
	     while(c_begin.before(c_end)){
	        //System.out.println("第"+count+"周  日期："+new java.sql.Date(c_begin.getTime().getTime())+","+weeks[c_begin.get(Calendar.DAY_OF_WEEK)]);
	        Map node=new HashMap();
			node.put("zc",count);
			node.put("date", new java.sql.Date(c_begin.getTime().getTime()));
			node.put("week", weeks[c_begin.get(Calendar.DAY_OF_WEEK)]);
			nodes.add(node);
	       
	      if(c_begin.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
	          count++;
	      }
	      c_begin.add(Calendar.DAY_OF_YEAR, 1);
	     }
		return nodes;
	
	}
	
	/**
	 * 根据周次查询该周次的具体日期
	 * @param args
	 */
	public static String getDateStr(String startDate,String endDate, String weekNum){
		
		List<Map> list=getDateBetweenStartDateAndEndDate(startDate,endDate);
		String beginDateStr="";
		String endDateStr="";
		List<String> list2=new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).get("zc").toString().equals(weekNum)){
				
				list2.add(list.get(i).get("date").toString());
				
			}
			
		}
		
		String dataStr=list2.get(0)+"至"+list2.get(6);
		return dataStr;
		
	}
	
	public static void main(String args[]){
		
	}
}
