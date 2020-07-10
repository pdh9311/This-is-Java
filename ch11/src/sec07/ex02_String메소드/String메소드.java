package sec07.ex02_String메소드;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class String메소드 {
	public static void main(String[] args) {
		charValue();		// 문자 추출 charAt()
		equalsValue();		// 문자열 비교 equals()
		bytesEncoding();	// 바이트 배열로 변환 getBytes()
		searchString();		// 포함된 문자열이 시작되는 인덱스의 위치 indexOf() 
		lengthStr();		// 문자열 길이 length()
		replaceStr();		// 문자열 대체 replace()
		subString();		// 문자열 추출 substring()
		alphabet();			// 알파벳 대·소문자 toUpperCase() , toLowerCase()
		trimStr();			// 문자열 앞뒤 공백 제거 trim()
		valueOfStr();		// 기본타입의 값을 문자열로 변환 String.valueOf()
		splitStr();			// 구분자를 기준으로 문자열을 분리 split()
	}
	
	public static void charValue() {
		Scanner scan = new Scanner(System.in);
		System.out.print("주민등록 번호 입력(-포함): " );
		String str = scan.nextLine();
		System.out.println("입력한 값: "+ str);
		
		// 문자 추출
		char charValue = str.charAt(7);
		System.out.println("입력한 값의 8번째 문자: " + charValue);
	}
	public static void equalsValue() {
		// 문자열 비교
		// equals()메소는 원래 Object의 번지를 비교하는 메소드지만 String클래스가 재정의하여 문자열을 비교하도록 변경했음.
		String str1 = new String("홍길동");
		String str2 = new String("홍길동");
		String str3 = "홍길동";
		String str4 = "홍길동";
		System.out.println(str1 == str2);		// 객체의 참조 변수를 비교하므로 false
		System.out.println(str1.equals(str2));	// 문자열을 비교하므로 true
		System.out.println(str1 == str3);		// 객체의 참조 변수를 비교하므로 false
		System.out.println(str1.equals(str3));	// 문자열을 비교하므로 true
		System.out.println(str3 == str4);		// 객체의 참조 변수를 비교하므로 true , new 연산자를 이용하지 않았다면 같은 문자열일 경우 같은 객체를 참조한다.
		System.out.println(str3.equals(str4));	// 문자열을 비교하므로 true
	}
	public static void bytesEncoding() {
		// 바이트 배열로 변환
		String str = "안녕하세요";
		byte[] bytes1 = str.getBytes();			//문자열 → 바이트(인코딩)
		for(int i=0; i<bytes1.length; i++) {	
			System.out.print(bytes1[i] + " ");		
		}
		str = new String(bytes1);				//바이트 → 문자열(디코딩)
		System.out.println("\n" + str);		
		
		try {
			byte[] bytes2 = str.getBytes("UTF-8");	//문자열 → 바이트(인코딩)
			for(int i=0; i<bytes2.length; i++) {
				System.out.print(bytes2 + " ");		
			}
			str = new String(bytes2,"UTF-8");		//바이트 → 문자열(디코딩)
			System.out.println("\n" + str);
			str = new String(bytes2,"EUK-KR");		// 디코딩시 인코딩했을때와 같은 문자셋으로 디코딩해주어야한다. 
			System.out.println(str);				// 출력 안됨
		} catch (UnsupportedEncodingException e) {}		
	}
	public static void searchString() {
		String str = "indexOf() 메소드는 매개값으로 주어진 문자열이 시작되는 인덱스를 리턴한다. 포함 되어 있지 않으면 -1을 리턴";
		String searchStr = "자바";
		int index = str.indexOf(searchStr);	 
		if( index != -1) { 
			System.out.println(searchStr +" 문자열이 시작되는 인덱스의 위치는: " + index);
		} else {
			System.out.println(searchStr + " 문자열이 포함되어 있지 않습니다.");
		}
	}
	public static void lengthStr() {
		String str = "배열 길이가 아닌 문자열 길이를 알아보자";
		int lenStr = str.length();
		System.out.println("문자열 길이: " + lenStr);
	}
	public static void replaceStr() {
		// replace() 메소드는 첫 번째 매개값인 문자열을 찾아 두 번째 매개값으로 대치한 새로운 문자열을 만든다.
		String str ="자바 프로그래밍 연습";
		String newStr = str.replace("자바", "JAVA");
		System.out.println(newStr);
	}
	public static void subString() {
		String str = "930311-1234567";
		String firstToSecond = str.substring(2,6); // 첫번째 인덱스부터 두번째 인덱스전까지 문자열로 만든다.
		System.out.println(firstToSecond);
		String firstToEnd = str.substring(7);
		System.out.println(firstToEnd);
	}
	public static void alphabet() {
		// 영어로된 문자열의 대소문자와 관계없이 비교할 때 주로 사용됨.
		String str = "Java Programming";
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
	}
	public static void trimStr() {
		// trim()은 문자열 중간의 공백은 제거하지 않는다.
		String str = "     문자열  앞뒤   공백    제거     ";
		String newStr = str.trim();
		System.out.println(newStr);
		
	}
	public static void valueOfStr() {
		// 기본타입의 값을 문자열로 변환
		boolean b1 = true;
		boolean b2 = false;
		char c = '아';
		int i = 12345;
		long l = 12445L;
		double d = 123.123;
		float f = 123.44f;
		String str = String.valueOf(b1);
		System.out.println(str);
		str =String.valueOf(b2);
		System.out.println(str);
		str =String.valueOf(c);
		System.out.println(str);
		str =String.valueOf(i);
		System.out.println(str);
		str =String.valueOf(l);
		System.out.println(str);
		str =String.valueOf(d);
		System.out.println(str);
		str =String.valueOf(f);
		System.out.println(str);
		
	}
	public static void splitStr() {
		// split()는 정규표현식을 구분자로 해서 문자열을 분리한 후 배열에 저장하고 리턴한다.
		String str = "홍길동&홍일동,홍이동,홍삼동-홍사동";
		String[] arrStr = str.split("&|,|-");
		for(String strE : arrStr) {
			System.out.print(strE + " ");
		}
	}
}
