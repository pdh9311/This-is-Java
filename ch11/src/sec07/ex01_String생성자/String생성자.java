package sec07.ex01_String생성자;

import java.io.IOException;

public class String생성자 {
	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[100];
		System.out.print("입력: ");
		/* System.in.read()는 키보드로 입력한 내용(캐리지리턴"\r",라인피드"\n" 포함)을 
		 * 매개값으로 주어진 byte배열에 저장하고
		 * 읽은 바이트수를 리턴한다. */
		int readByte = System.in.read(bytes);	
		
		// byte배열을 문자열로 만들어준다. 
		String str = new String(bytes);
		System.out.println(str);
		
		// byte배열을 지정한 문자셋으로 문자열을 만들어준다.
		str = new String(bytes,"UTF-8");
		System.out.println(str);
		
		// byte배열의 0번째 인덱스 위치부터 읽은 바이트수(캐리지리턴과 라인피드 제외)만큼 문자열을 만들어 준다.
		str = new String(bytes,0,readByte-2);
		System.out.println(str);
		
		// byte배열의 0번째 인덱스 위치부터 읽은 바이트수(캐리지리턴과 라인피드 제외)만큼 지정한 문자셋으로 문자열을 만들어 준다.
		str = new String(bytes,0,readByte-2,"UTF-8");
		System.out.println(str);
		
	}
}
