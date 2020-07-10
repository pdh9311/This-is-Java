package sec02.ex01_최상위_입출력_스트림_클래스;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamOutputStream {
	public static void main(String[] args) throws Exception {
		/** InputStream과 Reader의 read(...)메소드는 읽어들일 값이 없을 때 -1을 리턴하도록 되어있다. */
		
		InputStream inputStream1 = new FileInputStream("D:\\SW PDH\\This is Java\\ch18\\src\\sec02\\ex01_최상위_입출력_스트림_클래스\\입력 받을 파일");
		OutputStream outputStream1 = new FileOutputStream("D:\\SW PDH\\This is Java\\ch18\\src\\sec02\\ex01_최상위_입출력_스트림_클래스\\1. 출력 받을 파일write(int)");
		/* inputStream의 read()메소드를 `한번 실행할때 마다` 파일에서 읽어들인 1바이트를 리턴하기 때문에
		 * 1. while문의 조건 값안에 작성해야 반복적으로 읽어들이면서 끝까지 읽어 들였는지 확인 할 수 있다.
		 * 2. 읽은 바이트를 출력하기위해 읽은 바이트를 담을 변수를 선언해준다. */
		System.out.print("읽은 바이트: ");
		int readByte ;	// 읽은 바이트
		while((readByte = inputStream1.read()) != -1) {		
			System.out.print(readByte + " ");
			outputStream1.write(readByte);
		}
		System.out.println();
		outputStream1.flush();
		
		inputStream1.close();
		outputStream1.close();
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		InputStream inputStream2 = new FileInputStream("D:\\SW PDH\\This is Java\\ch18\\src\\sec02\\ex01_최상위_입출력_스트림_클래스\\입력 받을 파일");
		OutputStream outputStream2 = new FileOutputStream("D:\\SW PDH\\This is Java\\ch18\\src\\sec02\\ex01_최상위_입출력_스트림_클래스\\2. 출력 받을 파일write(byte[])");
		/* read(byte[])메소드를 `한번 실행할때 마다` 파일에서 byte배열의 길이 만큼 읽어서 byte배열에 저장하고 읽은 바이트수를 리턴하기 때문에
		 * 1. while문의 조건 값안에 작성해야 반복적으로 읽어들이면서 끝까지 읽어들였는지 확인 할 수 있다.
		 * 2. 읽은 바이트를 같은 byte배열 객체에 저장하기 위해 read()메소드의 매개값으로 byte배열객체를 생성하는게 아니라 byte배열을 따로 선언해준다. */
		System.out.print("읽은 바이트의 수: ");
		byte[] b1 = new byte[512];
		int readCount1 ;	 // 읽은 바이트의 수
		// 방법 1 (초기화 작업이 없으면 불필요한 값이 출력 될 수 있고, 초기화작업이 추가 되므로써 상대적으로 프로그램 성능이 떨어질 수 있다.)
		while((readCount1 = inputStream2.read(b1)) != -1) {
			System.out.print(readCount1 + " ");
			outputStream2.write(b1);
			for(int i=0;i<b1.length;i++) { b1[i] = 0; }		// 이전에 읽은 byte배열을 초기화해 주는 작업
		}
		// 방법 2
		while((readCount1 = inputStream2.read(b1)) != -1) {
			outputStream2.write(b1,0,readCount1);
		}
		
		System.out.println();
		outputStream2.flush();
		
		inputStream2.close();
		outputStream2.close();
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		InputStream inputStream3 = new FileInputStream("D:\\SW PDH\\This is Java\\ch18\\src\\sec02\\ex01_최상위_입출력_스트림_클래스\\입력 받을 파일");
		OutputStream outputStream3 = new FileOutputStream("D:\\SW PDH\\This is Java\\ch18\\src\\sec02\\ex01_최상위_입출력_스트림_클래스\\3. 출력 받을 파일write(byte[],start,len)");

		byte[] b2 = new byte[1024];
		int readCount2 ;	// 읽은 바이트의 수
		
		while( (readCount2 = inputStream3.read(b2,0,100)) != -1) {
			outputStream3.write(b2, 0, readCount2);
		}
		
		outputStream3.flush();
		
		inputStream3.close();
		outputStream3.close();
		
	}

}
