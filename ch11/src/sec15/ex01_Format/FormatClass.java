package sec15.ex01_Format;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatClass {
	public static void main(String[] args) {
		// 숫자 형식 클래스 DecimalForamt
		DecimalFormat df = new DecimalFormat("+#,##0.0;-#,##0.0");
		String result = df.format(1123234.23123);
		System.out.println(result);
		result = df.format(-12312.123123);
		System.out.println(result);
		
		// 날짜 형식 클래스 SimpleDateFormat
		/* y : 년								
		 * M : 월	
		 * d : 일 
		 * D : 월 구분없는 일(1~365)
		 * E : 요일
		 * a : 오전/오후
		 * w : 년의 몇 번째 주
		 * W : 월읠 몇 번째 주
		 * **************************
		 * H : 시(0~23)
		 * h : 시(1~12)
		 * m : 분 
		 * s : 초
		 * S : 밀리세컨드(1/1000초)
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm:ss");
		String now = sdf.format(new Date());
		System.out.println(now);
		
		// 매개변수화된 문자열 형식 클랙스 MessageFormat
		String id = "java";
		String name = "홍길동";
		String tel = "010-1234-1234";
		String text = "회원ID: {0} \n회원이름:{1} \n전화번호:{2}";
		String textComplete = MessageFormat.format(text,id,name,tel);
		System.out.println(textComplete);
		
		String sql = "insert into member values({0},{1},{2})";
		Object[] arguments = {"'java'","'홍길동'","'010-1234-1234'"};
		String sqlComplete = MessageFormat.format(sql, arguments);
		System.out.println(sqlComplete);
	}
}
