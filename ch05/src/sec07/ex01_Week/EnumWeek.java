package sec07.ex01_Week;

import java.util.Calendar;

public class EnumWeek {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		
		int week = now.get(Calendar.DAY_OF_WEEK);
		Week dow = null;
		switch(week) {
			case 1: dow = Week.SUNDAY; break;
			case 2: dow = Week.MONDAY; break;
			case 3: dow = Week.TUESDAY; break;
			case 4: dow = Week.WEDNESDAY; break;
			case 5: dow = Week.THURSDAY; break;
			case 6: dow = Week.FRIDAY; break;
			case 7: dow = Week.SATURDAY; break;
		}
		
		int ampm = now.get(Calendar.AM_PM);
		String ampmStr = (ampm == 0) ? "����" : "����";
		
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		System.out.println("���� ��/��/��/����/�ð� ��? \n" + year+"/"+month+"/"+day+"("+dow.name()+") "+ ampmStr+" " + hour+":"+minute+":"+second);

		System.out.print("\nWeek ���� : ");
		Week[] day7s = Week.values();
		for(Week day7 : day7s) {
			System.out.print(day7 + " | ");
		}
	}
}
