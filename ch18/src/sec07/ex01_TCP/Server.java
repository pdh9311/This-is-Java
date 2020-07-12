package sec07.ex01_TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;


public class Server {
	public static void main(String[] args) {
		/* ServerSocket: 클라이언트의 요청을 기다리면서 연결 수락을 담당.
		 * Socket: 연결된 클라이언트와 통신을 담당.
		 * 바인딩포드: 클라이언트가 서버에 접속할 포트
		 * 클라이언트가 Socket의 connect()메소드로 특정 IP/Port에 연결을 요청하면 
		 * 서버의 바인딩포드를 통해 ServerSocket의 accept()메소드는 연결을 수락하고 클라이언트와 통신할 Socket객체를 생성한다. */
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost",5001));
			while(true) {
				System.out.println("[Client의 연결 요청 기다리는 중]");
				Socket socket = serverSocket.accept();			// Client의 연결요청이 올 때까지 블로킹된다.
				System.out.println(" <Client와 연결 성공>");
				/* getRemoteSocketAddress()메소드는 SocketAddress객체를 리턴하지만 Client의 정보를 알기 위해
				 * InetSocketAddress로 형변화을 하며, InetSocketAddress의 getHostName(),getPort()메소드로 Client의 IP와 PORT를 알 수 있다. */
				SocketAddress socketAddress = socket.getRemoteSocketAddress(); 	
				InetSocketAddress isa = (InetSocketAddress) socketAddress;
				String ip = isa.getHostName();
				int port = isa.getPort();
				System.out.println("  - Client 정보: " + ip + "(" + port+ ")");
				
				// Socket객체로 InputStream과 OutputStream 객체를 얻어서 서버와 클라이언트가 통신을 한다.
				byte[] buf = null;
				
				OutputStream os = socket.getOutputStream();
				String sendData = "Hello Client";
				buf = sendData.getBytes("UTF-8");
				os.write(buf);
				System.out.println(" >> Client에 보낸 데이터(" + sendData +")");
				os.flush();
				
				InputStream is = socket.getInputStream();
				buf = new byte[100];
				int readCount = is.read(buf);
				if(readCount == -1) { throw new IOException(); }		// 상대방이 정상적으로 Socket의 close()메소드를 호출하면 read()메소드는 -1을 리턴하게 된다.
				String readData = new String(buf,0,readCount,"UTF-8");
				System.out.println(" << Client로 부터 받은 데이터(" + readData + ")");
				
				os.close();
				is.close();
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch (IOException e) { }
		}
		
	}
}
