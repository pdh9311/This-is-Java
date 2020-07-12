package sec07.ex01_TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket();
			System.out.println("[Server에 연결 요청]");
			socket.connect(new InetSocketAddress("localhost",5001));	// Server가 연결을 수락 할 때까지 블로킹된다.
			System.out.println("<Server와 연결 성공>");
			
			// Socket객체로 InputStream과 OutputStream 객체를 얻어서 서버와 클라이언트가 통신을 한다.
			byte[] buf = null;
			
			OutputStream os = socket.getOutputStream();
			String sendData = "Hello Server";
			buf = sendData.getBytes("UTF-8");
			os.write(buf);
			os.flush();
			System.out.println(" >> Server에 보낸 데이터(" + sendData +")");
			
			InputStream is = socket.getInputStream();
			buf = new byte[100];
			int readCount = is.read(buf);
			if(readCount == -1) { throw new IOException(); }		// 상대방이 정상적으로 Socket의 close()메소드를 호출하면 read()메소드는 -1을 리턴하게 된다.
			String readData = new String(buf,0,readCount,"UTF-8");
			System.out.println(" << Server로 부터 받은 데이터(" + readData + ")");
			
			os.close();
			is.close();
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(!socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) { }
		}
	}
}
