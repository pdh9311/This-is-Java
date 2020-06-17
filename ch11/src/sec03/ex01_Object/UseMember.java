package sec03.ex01_Object;

import java.util.Date;

public class UseMember {
	public static void main(String[] args) {
		Member m1 = new Member("홍길동");
		Member m2 = new Member("시라소니");
		Member m3 = new Member("홍길동");
		
		System.out.println(m1.equals(m2));
		System.out.println(m1.equals(m3));
		System.out.println("----------------------------");
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());
		System.out.println(m3.hashCode());
		System.out.println("홍길동".hashCode());
		System.out.println("----------------------------");
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
		System.out.println("----------------------------");
		Object obj = new Object();
		System.out.println(obj.toString());		// 클래스명@16진수해시코드
		Date date = new Date();
		System.out.println(date.toString());	// Date클래스가 재정의한 toString()메소드를 출력
		System.out.println("----------------------------");
		
		/* 신뢰하지 않는 영역에서 원본 객체로 작업할 경우 데이터가 훼손될 수 있기 때문에 
		 * 객체를 복제하여 사용하는 것이 좋다. */
		Member originalMember = new Member("김두한","프로게이머",new int[] {90,87});
		System.out.print("원본객체 아이디: " + originalMember.id + " | ");
		System.out.print("원본객체 job: " + originalMember.job + " | ");
		System.out.print("원본객체 점수: " + originalMember.scores[0] + "," + originalMember.scores[1] + "\n" );
		
		Member clonedMember = originalMember.getMember();
		clonedMember.id = "구마적";
		clonedMember.job = "프로그래머";
		clonedMember.scores[0] =20;
		System.out.print("복제객체 아이디: " + clonedMember.id + " | ");
		System.out.print("복제객체 job: " + clonedMember.job + " | ");
		System.out.print("복제객체 점수: " + clonedMember.scores[0] + "," + clonedMember.scores[1] + "\n" );

		System.out.println("----------------------------");
		Member member = null;
		for(int i=0;i<10;i++) {
			// 객체를 생성하고 바로 쓰레기(null)로 만들었다.
			member = new Member("id" + i);	
			member = null;
			System.gc();	// JVM에게 Garbage Collector를 가급적 빨리 실행하도록 요청.
		}
		
		
	}
}

