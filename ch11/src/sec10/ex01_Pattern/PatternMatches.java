package sec10.ex01_Pattern;

import java.util.regex.Pattern;

public class PatternMatches {
	public static void main(String[] args) {
		String regExp = "(010|02)-\\d{3,4}-\\d{4}";
		String phone = "010-6381-0086";
		boolean result = Pattern.matches(regExp, phone);
		String str = result ? "정규식과 일치" : "정규식과 불일치"	;
		System.out.println(str);
		
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		String email = "pdh6381@naver.com";
		result = Pattern.matches(regExp, email);
		str = result ? "정규식과 일치" : "정규식과 불일치";
		System.out.println(str);
	}
}
