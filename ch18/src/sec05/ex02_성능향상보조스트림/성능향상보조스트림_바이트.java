package sec05.ex02_성능향상보조스트림;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class 성능향상보조스트림_바이트 {
	public static void main(String[] args) throws Exception {
		long start = 0;
		long end = 0;
		
		InputStream is1 = new FileInputStream("D:\\SW PDH\\This is Java\\ch18\\src\\sec05\\ex02_성능향상보조스트림\\forest.jpg");
		BufferedInputStream bis1 = new BufferedInputStream(is1);
		
		OutputStream os1 = new FileOutputStream("C:\\Users\\padohy\\Desktop\\숲1.jpg");
		BufferedOutputStream bos1 = new BufferedOutputStream(os1);
		
		byte[] buf1 = new byte[512];
		int readCount;
		start = System.nanoTime();
		while((readCount = bis1.read(buf1)) != -1 ) {
			bos1.write(buf1,0,readCount);
		}
		end = System.nanoTime();
		System.out.println("걸린시간: " +  (end-start) +  "ns");			// 2519800ns(1등)

		bos1.flush();	os1.flush();
		bos1.close();	bis1.close();	os1.close();	is1.close();
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		InputStream is2 = new FileInputStream("D:\\SW PDH\\This is Java\\ch18\\src\\sec05\\ex02_성능향상보조스트림\\forest.jpg");
		BufferedInputStream bis2 = new BufferedInputStream(is2);
		
		OutputStream os2 = new FileOutputStream("C:\\Users\\padohy\\Desktop\\숲2.jpg");
		BufferedOutputStream bos2 = new BufferedOutputStream(os2);
		
		int readByte1;
		start = System.nanoTime();
		while((readByte1 = bis2.read()) != -1) {
			bos2.write(readByte1);
		}
		end = System.nanoTime();
		System.out.println("걸린시간: " +  (end-start) +  "ns");			// 39209200ns(2등)
		
		bos2.flush();	os2.flush();
		bos2.close();	bis2.close();	os2.close();	is2.close();
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		InputStream is3 = new FileInputStream("D:\\SW PDH\\This is Java\\ch18\\src\\sec05\\ex02_성능향상보조스트림\\forest.jpg");
		OutputStream os3 = new FileOutputStream("C:\\Users\\padohy\\Desktop\\숲3.jpg");
		
		byte[] buf2 = new byte[512];
		int readCount2;
		start = System.nanoTime();
		while((readCount2 = is3.read(buf2)) != -1) {
			os3.write(buf2,0,readCount2);
		}
		end = System.nanoTime();
		System.out.println("걸린시간: " +  (end-start) +  "ns");			// 7523900ns(2등)
		
		os3.flush();
		os3.close();	is3.close();
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		InputStream is4 = new FileInputStream("D:\\SW PDH\\This is Java\\ch18\\src\\sec05\\ex02_성능향상보조스트림\\forest.jpg");
		OutputStream os4 = new FileOutputStream("C:\\Users\\padohy\\Desktop\\숲4.jpg");
		
		int readByte2;
		start = System.nanoTime();
		while((readByte2 = is4.read()) != -1) {
			os4.write(readByte2);
		}
		end = System.nanoTime();
		System.out.println("걸린시간: " +  (end-start) +  "ns");			// 2974137600ns(4등)
		
		os4.flush();
		os4.close();	is4.close();		
	}
}
