package sec03.ex01_Object;

import java.util.Date;

public class UseMember {
	public static void main(String[] args) {
		Member m1 = new Member("ȫ�浿");
		Member m2 = new Member("�ö�Ҵ�");
		Member m3 = new Member("ȫ�浿");
		
		System.out.println(m1.equals(m2));
		System.out.println(m1.equals(m3));
		System.out.println("----------------------------");
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());
		System.out.println(m3.hashCode());
		System.out.println("ȫ�浿".hashCode());
		System.out.println("----------------------------");
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
		System.out.println("----------------------------");
		Object obj = new Object();
		System.out.println(obj.toString());		// Ŭ������@16�����ؽ��ڵ�
		Date date = new Date();
		System.out.println(date.toString());	// DateŬ������ �������� toString()�޼ҵ带 ���
		System.out.println("----------------------------");
		
		/* �ŷ����� �ʴ� �������� ���� ��ü�� �۾��� ��� �����Ͱ� �Ѽյ� �� �ֱ� ������ 
		 * ��ü�� �����Ͽ� ����ϴ� ���� ����. */
		Member originalMember = new Member("�����","���ΰ��̸�",new int[] {90,87});
		System.out.print("������ü ���̵�: " + originalMember.id + " | ");
		System.out.print("������ü job: " + originalMember.job + " | ");
		System.out.print("������ü ����: " + originalMember.scores[0] + "," + originalMember.scores[1] + "\n" );
		
		Member clonedMember = originalMember.getMember();
		clonedMember.id = "������";
		clonedMember.job = "���α׷���";
		clonedMember.scores[0] =20;
		System.out.print("������ü ���̵�: " + clonedMember.id + " | ");
		System.out.print("������ü job: " + clonedMember.job + " | ");
		System.out.print("������ü ����: " + clonedMember.scores[0] + "," + clonedMember.scores[1] + "\n" );

		System.out.println("----------------------------");
		Member member = null;
		for(int i=0;i<10;i++) {
			// ��ü�� �����ϰ� �ٷ� ������(null)�� �������.
			member = new Member("id" + i);	
			member = null;
			System.gc();	// JVM���� Garbage Collector�� ������ ���� �����ϵ��� ��û.
		}
		
		
	}
}

