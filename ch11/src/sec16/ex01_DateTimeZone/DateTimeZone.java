package sec16.ex01_DateTimeZone;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeZone {
	public static void main(String[] args) throws InterruptedException {
		// ��¥ ���
		LocalDate localDate = LocalDate.of(2081, 3, 23);	// ���� ���� ����
		System.out.println(localDate);
		localDate = LocalDate.now();
		System.out.println(localDate);

		System.out.println(localDate.getYear() + "-" + localDate.getMonthValue() + "-" + localDate.getDayOfMonth() + "(" + localDate.getDayOfWeek() + ")");
		System.out.println("�̹� ���� �����ΰ��� ?" + localDate.isLeapYear() + "\n");
		
		// �ð� ���
		LocalTime localTime = LocalTime.of(1, 33, 23);		// ���� ���� ����	
		System.out.println(localTime);
		localTime = LocalTime.now();
		System.out.println(localTime);
		
		System.out.println(localTime.getHour() + ":" + localTime.getMinute() + ":" + localTime.getSecond() + "\n");
		
		// ��¥�� �ð� ���
		LocalDateTime localDateTime = LocalDateTime.of(1993, 3, 11, 1, 22, 34);		// ���� ���� ����
		System.out.println(localDateTime);
		
		localDateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy�� MM�� dd�� E���� a HH�� mm�� ss��");	// ��¥�� �ð��� ����� ���� ��������~ 	 
		String now = localDateTime.format(dateTimeFormatter);		// ��¥�� �ð��� ���ڿ� �������� ��ȯ	
		System.out.println(now + "\n");
		
		// ���� ����ÿ� �ð���
		ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
		System.out.println("���� �����: " + utcDateTime);
		ZonedDateTime newyorkDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
		System.out.println("���� �ð���: " + newyorkDateTime +"\n");
		
		// Ư�� ������ Ÿ�ӽ����� ���
		Instant instant1 = Instant.now();
		Thread.sleep(10);
		Instant instant2 = Instant.now();
		System.out.println("����(nano): " + instant1.until(instant2, ChronoUnit.NANOS));		
	}
}
