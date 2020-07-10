package sec03.ex01_Object;

import java.util.Arrays;

public class Member implements Cloneable {
	public String id;
	public String job;
	public int[] scores;
	
	public Member(String id) {
		this.id = id;
	}
	
	public Member(String id, String job, int[] scores) {
		this.id = id;
		this.job = job;
		this.scores = scores;
	}

	// Object의 equals() 메소드
	// equals() 메소드를 재정의하여 id가 같은 객체를 논리적으로 동등한 객체로 취급한다.
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member)obj;
			if(id.equals(member.id)) {
				return true;
			}
		}
		return false;
	}
	
	// Object의 hashcode() 메소드
	// hashCode() 메소드를 재정의하여 id가 같으면 해시코드를 같도록 한다.
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	// Object의 toString() 메소드
	@Override
	public String toString() {
		return "당신의 아이디는 " + id + "입니다.";
	}

	// Object의 clone() 메소드 호출 [얕은 복제]
	/* clone() 메소드를 호출하기 위해서 implements Cloneable을 해주어야 한다.
	       또한 clone() 메소드는 CloneNotSupportedException예외가 발생하므로 예외처리를 해주어야 한다. */
	// clone() 메소드는 리턴타입이 Object이므로 타입변환이 필요하다.
	public Member getMember() {
		Member cloned = null;
		try {
			cloned = (Member) clone();		// 아래의 재정의된 clone()메소드를 호출하므로써 [깊은 복제]를 하게 된다.
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cloned;
	}
	// Object의 clone() 메소드 재정의 [깊은 복제]
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 먼저 얕은 복사로 id를 복제한다.
		/* clone()을 재정의 했기 때문에  clone()으로 호출하면 재귀호출되어 버려서 무한 호출하게 되고 StackOverflowError가 발생하므로
		 * super.를 붙여서 clone()을 호출해야한다. */
		Member cloned = (Member) super.clone();		
		// job을 깊은 복제한다.
		cloned.job = new String(this.job);
		// scores를 깊은 복제한다.
		cloned.scores = Arrays.copyOf(this.scores, this.scores.length);
		return cloned;
	}

	// Object의 finalize() 메소드
	@Override
	protected void finalize() throws Throwable {
		System.out.println(id + "인 객체의 finalize()가 실행됨");
	}
	
	
}

