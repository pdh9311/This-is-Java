package sec05.ex01_문자변환보조스트림;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class 문자변환보조스트림 {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("D:\\SW PDH\\This is Java\\ch18\\src\\sec02\\ex01_최상위_입출력_스트림_클래스\\입력 받을 파일");
		Reader reader = new InputStreamReader(is);
		
		OutputStream os = new FileOutputStream("D:\\SW PDH\\This is Java\\ch18\\src\\sec05\\ex01_문자변환보조스트림\\출력스트림 받는 파일.txt");
		Writer writer = new OutputStreamWriter(os);
		
		char[] cbuf = new char[100];
		int readCount;
		while( (readCount = reader.read(cbuf)) != -1 ) {
			String data = new String(cbuf,0,readCount);
			System.out.print(data);
			writer.write(cbuf,0,readCount);
		}
		writer.flush();
		
		reader.close();
		writer.close();
		
	}
}
