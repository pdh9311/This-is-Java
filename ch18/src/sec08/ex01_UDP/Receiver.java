package sec08.ex01_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver {
	public static void main(String[] args) throws Exception {
		DatagramSocket datagramSocket = new DatagramSocket(9000);
		
		/* DatagramSocket의 receive()메소드는 패킷정보를 항상 받을 준비를 해야 하고,
		 * 패킷 정보를 받을때까지 블로킹되므로 새로운 스레드에서 작업하는 것이 좋다. */
		Thread thread = new Thread() {
			@Override
			public void run() {
				System.out.println("[수신 시작]");
				try {
					while(true) {
						byte[] buf = new byte[100];
						DatagramPacket datagramPacket = new DatagramPacket(buf,buf.length);
						datagramSocket.receive(datagramPacket);
						
						/* DatagramPacket의 getData()메소드는 패킷에 저장된 바이트배열을 가져온다.
						 * DatagramPacket의 getLength()메소드는 패킷에 저장된 바이트배열의 길이 가져온다. 
						 * DatagramPacket의 getSocketAddress()메소드는 발신자의 주소(IP,PORT)를 가져온다. */
						String readData = new String(datagramPacket.getData(),0,datagramPacket.getLength(),"UTF-8");
						System.out.println("[받은 내용: " + datagramPacket.getSocketAddress() + "] " + readData);
					}
				} catch (IOException e) {
					System.out.println("[수신 종료]");
				}
			}
		};
		thread.start();
		
		Thread.sleep(5000);
		// receive()메소드가 블로킹되어있는동안 DatagramSocket을 close()하면 예외가 발생하고 수신 작업이 종료된다.
		datagramSocket.close();
		
	}
}
