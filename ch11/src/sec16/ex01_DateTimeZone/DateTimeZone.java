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
		// 날짜 얻기
		LocalDate localDate = LocalDate.of(2081, 3, 23);	// 직접 지정 가능
		System.out.println(localDate);
		localDate = LocalDate.now();
		System.out.println(localDate);

		System.out.println(localDate.getYear() + "-" + localDate.getMonthValue() + "-" + localDate.getDayOfMonth() + "(" + localDate.getDayOfWeek() + ")");
		System.out.println("이번 년이 윤년인가요 ?" + localDate.isLeapYear() + "\n");
		
		// 시간 얻기
		LocalTime localTime = LocalTime.of(1, 33, 23);		// 직접 지정 가능	
		System.out.println(localTime);
		localTime = LocalTime.now();
		System.out.println(localTime);
		
		System.out.println(localTime.getHour() + ":" + localTime.getMinute() + ":" + localTime.getSecond() + "\n");
		
		// 날짜와 시간 얻기
		LocalDateTime localDateTime = LocalDateTime.of(1993, 3, 11, 1, 22, 34);		// 직접 지정 가능
		System.out.println(localDateTime);
		
		localDateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일 a HH시 mm분 ss초");	// 날짜와 시간을 사용자 지정 형식으로~ 	 
		String now = localDateTime.format(dateTimeFormatter);		// 날짜와 시간을 문자열 형식으로 변환	
		System.out.println(now + "\n");
		
		// 협정 세계시와 시간존
		ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
		System.out.println("협정 세계시: " + utcDateTime);
		ZonedDateTime newyorkDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
		System.out.println("뉴욕 시간존: " + newyorkDateTime +"\n");
		
		// 특정 시점의 타임스탬프 얻기
		Instant instant1 = Instant.now();
		Thread.sleep(10);
		Instant instant2 = Instant.now();
		System.out.println("차이(nano): " + instant1.until(instant2, ChronoUnit.NANOS));		
	}
}
