package sec08.ex01_StringTokenizer;

import java.util.StringTokenizer;

public class StringTokenizerEX {
	public static void main(String[] args) {
		// 문자열을 어떤 하나의 구분자로 분리가능할 경우 사용
		String str = "홍길동/홍일동/홍이동";
		StringTokenizer st = new StringTokenizer(str,"/");
		int countTokens = st.countTokens();
		for(int i=0; i<countTokens; i++) {
			String token = st.nextToken();
			System.out.println(token);			
		}
		
		System.out.println();
		
		str = "홍길동 홍일동 홍이동";
		st = new StringTokenizer(str);		// 매개값으로 구분자를 생략하면 기본구분자를 공백으로 간주한다.
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}
}
