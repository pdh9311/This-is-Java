package sec07.ex03_File전송;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception  {
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("localhost",5002));
		
		System.out.println("[서버 시작]");
		
		while(true) {
			try {
				Socket socket = serverSocket.accept();
				InputStream is = socket.getInputStream();
				
				byte[] buf = new byte[100];
				int readByteCount = -1;
				
				System.out.print("[파일 이름 받기] ");
				int readCount = is.read(buf,0,100);
				String readData = new String(buf,0,readCount,"UTF-8");
				System.out.println(readData + "|");
				
				System.out.println("[파일 받기 시작]");
				// 저장할 파일명을 받아올때 100바이트를 전부 문자열로 바꾸었기 때문에 확장자 뒤의 공백을 제거 해주어야 한다.
				FileOutputStream fos = new FileOutputStream("C:\\Users\\padohy\\Desktop\\" + readData.trim());	
				while((readByteCount = is.read(buf)) != -1) {
					fos.write(buf,0,readByteCount);
				}
				
				fos.flush();
				System.out.println("[파일 받기 완료]");
				
				fos.close();
				is.close();
				socket.close();
			} catch (Exception e) {
				System.out.println("예외 발생");
				break;
			}
		}
		
		serverSocket.close();
		
		
		
	}
}
