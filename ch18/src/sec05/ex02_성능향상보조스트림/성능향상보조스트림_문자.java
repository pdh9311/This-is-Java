package sec05.ex02_성능향상보조스트림;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class 성능향상보조스트림_문자 {
	public static void main(String[] args) throws Exception {
		long start = 0;
		long end = 0;
		
		Reader reader1 = new FileReader("D:\\SW PDH\\This is Java\\ch18\\src\\sec05\\ex02_성능향상보조스트림\\조던 피터슨.txt");
		BufferedReader br1 = new BufferedReader(reader1);
		
		Writer writer1 = new FileWriter("C:\\Users\\padohy\\Desktop\\test1.txt");
		BufferedWriter bw1  = new BufferedWriter(writer1);
		
		char[] cbuf1 = new char[1024];
		int readCount1;
		start = System.nanoTime();
		while( (readCount1 = br1.read(cbuf1)) != -1) {
			bw1.write(cbuf1,0,readCount1);
		}
		end = System.nanoTime();
		System.out.println("걸린시간: " + (end-start) + "ns");			// 779900ns(1등)
		
		bw1.flush();	writer1.flush();	
		br1.close();	reader1.close(); 	bw1.close();	writer1.close();	
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Reader reader2 = new FileReader("D:\\SW PDH\\This is Java\\ch18\\src\\sec05\\ex02_성능향상보조스트림\\조던 피터슨.txt");
		BufferedReader br2 = new BufferedReader(reader2);
		
		Writer writer2 = new FileWriter("C:\\Users\\padohy\\Desktop\\test2.txt");
		BufferedWriter bw2  = new BufferedWriter(writer2);
		
		int readData1;
		start = System.nanoTime();
		while( (readData1 = br2.read()) != -1) {
			bw2.write(readData1);
		}
		end = System.nanoTime();
		System.out.println("걸린시간: " + (end-start) + "ns");			// 2732000ns(3등)
		
		bw2.flush();	writer2.flush();	
		br2.close();	reader2.close(); 	bw2.close();	writer2.close();	
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Reader reader3 = new FileReader("D:\\SW PDH\\This is Java\\ch18\\src\\sec05\\ex02_성능향상보조스트림\\조던 피터슨.txt");
		Writer writer3 = new FileWriter("C:\\Users\\padohy\\Desktop\\test3.txt");
		
		char[] cbuf2 = new char[1024];
		int readCount2;
		start = System.nanoTime();
		while( (readCount2 = reader3.read(cbuf2)) != -1) {
			writer3.write(cbuf2,0,readCount2);
		}
		end = System.nanoTime();
		System.out.println("걸린시간: " + (end-start) + "ns");			// 1290900ns(2등)
		
		writer3.flush();	
		reader3.close();	writer3.close();	
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Reader reader4 = new FileReader("D:\\SW PDH\\This is Java\\ch18\\src\\sec05\\ex02_성능향상보조스트림\\조던 피터슨.txt");
		Writer writer4 = new FileWriter("C:\\Users\\padohy\\Desktop\\test4.txt");
		
		int readData2;
		start = System.nanoTime();
		while( (readData2 = reader4.read()) != -1) {
			writer4.write(readData2);
		}
		end = System.nanoTime();
		System.out.println("걸린시간: " + (end-start) + "ns");			// 17237200ns(4등)
		
		writer4.flush();	
		reader4.close();	writer4.close();	
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
}
