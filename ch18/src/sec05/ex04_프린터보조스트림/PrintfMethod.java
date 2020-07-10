package sec05.ex04_프린터보조스트림;

import java.util.Date;

public class PrintfMethod {
	public static void main(String[] args) {
		System.out.printf("%d\n",123);
		System.out.printf("%6d\n",123);
		System.out.printf("%-6d\n",123);
		System.out.printf("%06d\n",123);
		
		System.out.printf("반지름 %d인 원의 넓이 %5.2f\n",10,Math.PI*10*10);
		
		System.out.printf("|%10s|%-10s|\n","홍길동","구마적");
		
		Date now = new Date();
		
		System.out.printf("%tY-%tm-%td|%ty-%tm-%td\n",now,now,now,now,now,now);
		System.out.printf("%1$tY-%1$tm-%1$td|%1$ty-%1$tm-%1$td\n",now);
		
		System.out.printf("%1$tH : %1$tM : %1$tS\n", now);
		System.out.printf("%1$tl : %1$tM : %1$tS\n", now);
		
	}
}
