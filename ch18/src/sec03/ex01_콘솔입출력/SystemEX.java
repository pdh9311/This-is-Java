package sec03.ex01_콘솔입출력;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class SystemEX {
	public static void main(String[] args) throws IOException {
		/* InputStream의 read()메소드는 1바이트만 읽기 때문에 문자열을 출력할 수 없고 문자 하나만 출력가능하다.
		 * 또한 2바이트로 표현되는 한글같은 경우 읽을 수 없다. */
		System.out.println("숫자를 입력하세요");
		Scanner scan = new Scanner(System.in);
		
		int selectNum = scan.nextInt();
		switch(selectNum) {
		case 1:
			System.out.println("[문자 하나(1byte)만 출력]");
			System.out.print("입력하세요> ");
			InputStream is1 = System.in;
			int asciicode = is1.read();
			char inputChar = (char) asciicode;
			System.out.println(inputChar);
			break;
		case 2:
			System.out.println("[문자열 출력]");
			System.out.print("입력하세요> ");
			InputStream is2 = System.in;
			byte[] byteBuffer1 = new byte[100];
			int readByteCount = is2.read(byteBuffer1);
			String byteData = new String(byteBuffer1,0,readByteCount-2);	// Enter(캐리지리턴,캐리지아웃)을 제외한 byte배열의 값을 문자열로 변환
			System.out.println(byteData);
			break;
		case 3: 
			System.out.println("[아스키 코드 문자 출력]");
			OutputStream os1 = System.out;
			for(int i=48; i<=57; i++) {
				os1.write(i);
			}
			os1.write(10);		// 라인피드(10)를 출력
			for(int i=65; i<=90; i++) {
				os1.write(i);
			}
			os1.write(13);		// 캐리지리턴(13)를 출력
			for(int i=97; i<123;i++) {
				os1.write(i);
			}
			os1.flush();
			os1.close();
			break;
		case 4:
			System.out.println("[문자열을 출력]");
			OutputStream os2 = System.out;
			String str = "가나다라마바사아자차카타파하";
			byte[] byteBuffer2 = str.getBytes();
			os2.write(byteBuffer2);
			os2.flush();
			os2.close();
			break;
		}
		PrintStream ps = System.out;
		ps.print("!!");
		ps.println("끝");
		scan.close();
	}
}
