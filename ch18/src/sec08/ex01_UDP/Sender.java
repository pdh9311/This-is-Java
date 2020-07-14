package sec08.ex01_UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Sender {
	public static void main(String[] args) throws Exception {
		DatagramSocket datagramSocket = new DatagramSocket();
		System.out.println("[발신 시작]");

		for(int i=1 ;i<=5; i++) {
			String sendData = "메시지" + i;
			byte[] buf = sendData.getBytes("UTF-8");
			
			DatagramPacket datagramPacket = new DatagramPacket(
				buf,buf.length,new InetSocketAddress("localhost",9000)
			);
		
			datagramSocket.send(datagramPacket);
			System.out.println("[보낸 데이터] " + new String(buf));
		}
		
		datagramSocket.close();
		System.out.println("[발신 종료]");
	}
}
