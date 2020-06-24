package sec15.ex01_Format;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatClass {
	public static void main(String[] args) {
		// ���� ���� Ŭ���� DecimalForamt
		DecimalFormat df = new DecimalFormat("+#,##0.0;-#,##0.0");
		String result = df.format(1123234.23123);
		System.out.println(result);
		result = df.format(-12312.123123);
		System.out.println(result);
		
		// ��¥ ���� Ŭ���� SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm:ss");
		String now = sdf.format(new Date());
		System.out.println(now);
		
		// �Ű�����ȭ�� ���ڿ� ���� Ŭ���� MessageFormat
		String id = "java";
		String name = "ȫ�浿";
		String tel = "010-1234-1234";
		String text = "ȸ��ID: {0} \nȸ���̸�:{1} \n��ȭ��ȣ:{2}";
		String textComplete = MessageFormat.format(text,id,name,tel);
		System.out.println(textComplete);
		
		String sql = "insert into member values({0},{1},{2})";
		Object[] arguments = {"'java'","'ȫ�浿'","'010-1234-1234'"};
		String sqlComplete = MessageFormat.format(sql, arguments);
		System.out.println(sqlComplete);
	}
}
