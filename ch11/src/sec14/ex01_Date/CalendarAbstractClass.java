package sec14.ex01_Date;

import java.util.Calendar;
import java.util.TimeZone;

public class CalendarAbstractClass {
	public static void main(String[] args) {
		TimeZone timeZone = TimeZone.getTimeZone("Asia/Seoul");
		Calendar now = Calendar.getInstance(timeZone);
		
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DATE);
		int dow = now.get(Calendar.DAY_OF_WEEK);
		String dowStr = "";
		int ampm = now.get(Calendar.AM_PM);
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		System.out.print(year + "-");
		System.out.print(month + "-");
		System.out.print(day + " ");
		switch(dow) {
		case Calendar.MONDAY : 
			dowStr = "월"; break;
		case Calendar.TUESDAY :
			dowStr = "화"; break;
		case Calendar.WEDNESDAY : 
			dowStr = "수"; break;
		case Calendar.THURSDAY : 
			dowStr = "목"; break;
		case Calendar.FRIDAY : 
			dowStr = "금"; break;
		case Calendar.SATURDAY : 
			dowStr = "토"; break;
		case Calendar.SUNDAY :
			dowStr = "일"; break;
		}
		System.out.print(dowStr + "요일 ");
		System.out.print(ampm == Calendar.AM ? "오전 " : "오후 ");
		System.out.print(hour + ":");
		System.out.print(minute + ":");
		System.out.print(second);
		
		// TimeZone.getTimeZone()의 매개값으로 사용할 수 있는 문자열 목록을 확인할 수 있다. 
		String[] availableIDs = TimeZone.getAvailableIDs();
		for(String id : availableIDs) {
			System.out.println(id);
		}
	}
}
