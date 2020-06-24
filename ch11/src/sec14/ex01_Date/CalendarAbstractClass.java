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
			dowStr = "��"; break;
		case Calendar.TUESDAY :
			dowStr = "ȭ"; break;
		case Calendar.WEDNESDAY : 
			dowStr = "��"; break;
		case Calendar.THURSDAY : 
			dowStr = "��"; break;
		case Calendar.FRIDAY : 
			dowStr = "��"; break;
		case Calendar.SATURDAY : 
			dowStr = "��"; break;
		case Calendar.SUNDAY :
			dowStr = "��"; break;
		}
		System.out.print(dowStr + "���� ");
		System.out.print(ampm == Calendar.AM ? "���� " : "���� ");
		System.out.print(hour + ":");
		System.out.print(minute + ":");
		System.out.print(second);
		
		// TimeZone.getTimeZone()�� �Ű������� ����� �� �ִ� ���ڿ� ����� Ȯ���� �� �ִ�. 
		String[] availableIDs = TimeZone.getAvailableIDs();
		for(String id : availableIDs) {
			System.out.println(id);
		}
	}
}
