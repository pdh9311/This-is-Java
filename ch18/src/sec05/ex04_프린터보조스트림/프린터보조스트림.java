package sec05.ex04_프린터보조스트림;

import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

public class 프린터보조스트림 {
	public static void main(String[] args) throws Exception {
		OutputStream os = System.out;
		PrintStream ps = new PrintStream(os);
		ps.print("프린트스트림");
		ps.println(2134);
		ps.flush();
		ps.close();
		
		Writer writer = new FileWriter("D:\\SW PDH\\This is Java\\ch18\\src\\sec05\\ex04_프린터보조스트림\\PrintWriter.txt");
		PrintWriter pw = new PrintWriter(writer);
		pw.print("프린트스트림");
		pw.println(123554);
		pw.flush();
		writer.close();
		pw.close();
		
	}
}
