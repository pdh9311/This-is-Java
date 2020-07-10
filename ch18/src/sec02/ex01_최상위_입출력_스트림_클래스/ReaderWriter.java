package sec02.ex01_최상위_입출력_스트림_클래스;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class ReaderWriter {
	public static void main(String[] args) throws Exception {
		Reader reader1 = new FileReader("D:\\SW PDH\\This is Java\\ch18\\src\\sec02\\ex01_최상위_입출력_스트림_클래스\\입력 받을 파일");
		Writer writer1 = new FileWriter("D:\\SW PDH\\This is Java\\ch18\\src\\sec02\\ex01_최상위_입출력_스트림_클래스\\1. 출력 받을 파일write(int)");
		int readData1 ;	// 읽은 문자의 바이트
		while((readData1 = reader1.read()) != -1) {
			char charData1 = (char) readData1 ;	// 읽은 문자의 바이트를 다시 문자로 변환
			System.out.print(charData1);
		}
		
		writer1.flush();
		
		reader1.close();
		writer1.close();
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Reader reader2 = new FileReader("D:\\SW PDH\\This is Java\\ch18\\src\\sec02\\ex01_최상위_입출력_스트림_클래스\\입력 받을 파일");
		Writer writer2 = new FileWriter("D:\\SW PDH\\This is Java\\ch18\\src\\sec02\\ex01_최상위_입출력_스트림_클래스\\4. 출력 받을 파일write(char[])");
		char[] charBuffer1 = new char[100];
		int readCount1 ;	// 읽은 문자 수
		// 방법1
		while( (readCount1 = reader2.read(charBuffer1)) != -1) {
			writer2.write(charBuffer1);
			for(int i=0; i<charBuffer1.length;i++) { charBuffer1[i] = ' '; }	// 이전에 읽은 char배열을 초기화해 주는 작업
		}
		// 방법2
		while( (readCount1 = reader2.read(charBuffer1)) != -1) {
			writer2.write(charBuffer1, 0, readCount1);
		}
		
		writer2.flush();
		
		reader2.close();
		writer2.close();
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Reader reader3 = new FileReader("D:\\SW PDH\\This is Java\\ch18\\src\\sec02\\ex01_최상위_입출력_스트림_클래스\\입력 받을 파일");
		Writer writer3 = new FileWriter("D:\\SW PDH\\This is Java\\ch18\\src\\sec02\\ex01_최상위_입출력_스트림_클래스\\5. 출력 받을 파일write(char[],start,len)");
		char[] charBuffer2 = new char[100];
		int readCount2 ;	// 읽은 문자 수
		while((readCount2 = reader3.read(charBuffer2,0,100)) != -1) {
			writer3.write(charBuffer2,0,readCount2); 
		}
		writer3.flush();
		
		reader3.close();
		writer3.close();
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Reader reader4 = new FileReader("D:\\SW PDH\\This is Java\\ch18\\src\\sec02\\ex01_최상위_입출력_스트림_클래스\\입력 받을 파일");
		Writer writer4 = new FileWriter("D:\\SW PDH\\This is Java\\ch18\\src\\sec02\\ex01_최상위_입출력_스트림_클래스\\6. 출력 받을 파일write(String)");
		Writer writer5 = new FileWriter("D:\\SW PDH\\This is Java\\ch18\\src\\sec02\\ex01_최상위_입출력_스트림_클래스\\7. 출력 받을 파일write(String,start,len)");
		
		StringBuilder sb = new StringBuilder();
		int readData2 ;
		while( (readData2= reader4.read()) != -1) {
			char charData2 = (char) readData2;
			sb.append(charData2);
		}
		writer4.write(sb.toString());
		writer5.write(sb.toString(),10,120);
		
		writer4.flush();
		writer5.flush();
		
		reader4.close();
		writer4.close();
		writer5.close();
		
	}
}
