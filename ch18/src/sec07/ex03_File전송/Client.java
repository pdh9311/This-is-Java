package sec07.ex03_File전송;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class Client {
	public static void main(String[] args) throws Exception {
		/* Socket socket = new Socket();
		 * socket.connect(new InetSocketAddress("localhost",5002));  */
		Socket socket = new Socket("localhost",5002);
		
		OutputStream os = socket.getOutputStream();

		File file = new File("D:\\SW PDH\\This is Java\\ch18\\src\\sec07\\ex03_File전송\\house.jpg");

		System.out.println("[파일 이름 보내기]");
		byte[] buf = file.getName().getBytes("UTF-8");
		buf = Arrays.copyOf(buf, 100);
		os.write(buf);
		
		System.out.println("[파일 보내기] " + file.getName());
		FileInputStream fis = new FileInputStream(file);
		byte[] fileBuf = new byte[1000];
		int readByteCount = -1;
		while((readByteCount = fis.read(fileBuf)) != -1) {
			os.write(fileBuf,0, readByteCount);
		}
		
		os.flush();
		System.out.println("[파일 보내기 완료]");
		fis.close();
		os.close();
		socket.close();
	}
}
