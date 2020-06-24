package sec14.ex01_Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateClass {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.toString());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm:ss");
		System.out.println(sdf.format(date));
				
	}
}
