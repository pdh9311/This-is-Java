package sec06.ex01_InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
/** 네트워크 > 홈 네트워크, 지역 네트워크, 인터넷
 * 	지역 네트워크: 회사, 건물, 특정 영역에 존재하는 컴퓨터를 통신회선으로 연결한 것
 * 	인터넷: 지역 네트워크를 통신회선으로 연결한 것 	*/
 public class GetIP {
	/* 대중에게 서비스를 제공하는 서버는 도메인 이름을 가지고 있는데, DNS에 {도메인 이름과 IP주소}를 등록해 놓는다. 
	 * 프로그램은 도메인 이름을 DNS에서 검색하여 IP주소를 얻은 다음 해당 IP주소를 가진 서버로 연결한다.
	 * IP주소는 네트워크 어댑터(랜(Lan)카드)마다 할당된다. 	*/
	public static void main(String[] args) {
		try { 
			String ip ;
			InetAddress ia ;
			// getLocalHost()메소드는 로컬 컴퓨터의 InetAddress객체를 가져온다.
			ia = InetAddress.getLocalHost();
			ip = ia.getHostAddress();		// getHostAddress()로 IP주소를 문자열로 가져온다.
			System.out.println("집 IP 주소: " + ip);
	
			// getByName()메소드는 매개값으로 준 도메인 이름으로 DNS에 등록된 단 하나의 IP주소를 가져와 InetAddress객체를 생성한다.
			ia = InetAddress.getByName("www.naver.com");
			ip = ia.getHostAddress();		// getHostAddress()로 IP주소를 문자열로 가져온다.
			System.out.println("네이버 IP 주소 1개: " + ip);
	
			// getAllName()메소드는 매개값으로 준 도메인 이름으로 DNS에 등록된 IP주소를 모두 가져와서 InetAddress객체배열로 가져온다.
			InetAddress[] naverIPs = InetAddress.getAllByName("www.naver.com");
			System.out.print("네이버에서 운영하는 컴퓨터 IP들: ");
			for(InetAddress naverIP : naverIPs) {
				System.out.print(naverIP.getHostAddress() + " | ");			// getHostAddress()로 IP주소를 문자열로 가져온다.
			}
	
			System.out.println();
			InetAddress[] youtubeIPs = InetAddress.getAllByName("www.youtube.com");
			System.out.print("유튜브에서 운영하는 컴퓨터 IP들: ");
			for(InetAddress youtubeIP : youtubeIPs) {
				System.out.print(youtubeIP.getHostAddress() + " | ");		// getHostAddress()로 IP주소를 문자열로 가져온다.
			}
	
			System.out.println();
			InetAddress[] googleIPs = InetAddress.getAllByName("www.google.com");
			System.out.print("구글에서 운영하는 컴퓨터 IP들: ");
			for(InetAddress googleIP : googleIPs) {
				System.out.print(googleIP.getHostAddress() + " | ");		// getHostAddress()로 IP주소를 문자열로 가져온다.
			}
			
			
		} catch(UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
