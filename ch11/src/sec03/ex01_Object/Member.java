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

	// Object�� equals() �޼ҵ�
	// equals() �޼ҵ带 �������Ͽ� id�� ���� ��ü�� �������� ������ ��ü�� ����Ѵ�.
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
	
	// Object�� hashcode() �޼ҵ�
	// hashCode() �޼ҵ带 �������Ͽ� id�� ������ �ؽ��ڵ带 ������ �Ѵ�.
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	// Object�� toString() �޼ҵ�
	@Override
	public String toString() {
		return "����� ���̵�� " + id + "�Դϴ�.";
	}

	// Object�� clone() �޼ҵ� ȣ�� [���� ����]
	/* clone() �޼ҵ带 ȣ���ϱ� ���ؼ� implements Cloneable�� ���־�� �Ѵ�.
	       ���� clone() �޼ҵ�� CloneNotSupportedException���ܰ� �߻��ϹǷ� ����ó���� ���־�� �Ѵ�. */
	// clone() �޼ҵ�� ����Ÿ���� Object�̹Ƿ� Ÿ�Ժ�ȯ�� �ʿ��ϴ�.
	public Member getMember() {
		Member cloned = null;
		try {
			cloned = (Member) clone();		// �Ʒ��� �����ǵ� clone()�޼ҵ带 ȣ���ϹǷν� [���� ����]�� �ϰ� �ȴ�.
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cloned;
	}
	// Object�� clone() �޼ҵ� ������ [���� ����]
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// ���� ���� ����� id�� �����Ѵ�.
		/* clone()�� ������ �߱� ������  clone()���� ȣ���ϸ� ���ȣ��Ǿ� ������ ���� ȣ���ϰ� �ǰ� StackOverflowError�� �߻��ϹǷ�
		 * super.�� �ٿ��� clone()�� ȣ���ؾ��Ѵ�. */
		Member cloned = (Member) super.clone();		
		// job�� ���� �����Ѵ�.
		cloned.job = new String(this.job);
		// scores�� ���� �����Ѵ�.
		cloned.scores = Arrays.copyOf(this.scores, this.scores.length);
		return cloned;
	}

	// Object�� finalize() �޼ҵ�
	@Override
	protected void finalize() throws Throwable {
		System.out.println(id + "�� ��ü�� finalize()�� �����");
	}
	
	
}

