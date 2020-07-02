package sec03.ex01_Set�÷���_HashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetCollection {
	public static void main(String[] args) {
		/* HashSet�� ��ü�� ���� ���� �����ϰ� ������ ��ü�� �ߺ� �������� �ʴ´�.
		 * ������ ��ü�� �Ǵ��ϴ� ������ ���� ��ü�� hashCode()�� ����, equals()�� ������ ������ ��ü�� �Ǵ��Ѵ�.
		 * String��ü�� ���ڿ��� ������ hashCode()�� equals()������ �����ǵǾ� �־ ���ڿ��� ������ ������ ��ü�� �Ǵ��Ѵ�. */
		Set<String> set = new HashSet<String>();
		// Set�÷��ǿ� �����Ҷ� add()�޼ҵ带 ����ϸ� ���������� ����Ǹ� true�� �ߺ���ü�� false�� �����Ѵ�.
		set.add("SUN");
		set.add("MON");
		set.add("TUE");
		set.add("WEN");
		set.add("THR");
		set.add("FRI");
		boolean isSuccess = set.add("SAT");
		System.out.println("��ü ���� ����? " + isSuccess);
		isSuccess = set.add("SAT");	// ���� "SAT"���ڿ��� Set�÷��ǿ� �����ص� �ߺ�������� �ʰ� �ϳ��� ����ȴ�.
		System.out.println("��ü ���� ����? " + isSuccess);
		
		// size()�޼ҵ�� Set�÷��ǿ� ����� ��ü ���� �����Ѵ�.
		System.out.println("Set�÷��ǿ� ����� ��ü ��:" + set.size());	
		
		// contains()�޼ҵ�� Set�÷��ǿ� �Ű������� �־��� ��ü�� ����Ǿ� �ִ��� Ȯ���Ѵ�. 
		if(set.contains("WEN")) {
			System.out.println("Set �÷��ǿ� WEN�� ���ԵǾ� �ֽ��ϴ�.");
		}

		/* Set�÷��ǿ��� ���� ���� ��ü�� ����ǹǷ� �ε����� �Ű������� ���� �޼ҵ尡 ��� 
		 * for(int i=0; i<set.size(); i++) {} �� for�ݺ����� �̿��ؼ� ��ü�� �ϳ��� �������ų�, �����ϴµ� ������ �ڵ尡 �ʿ�������.
		 * ���� ���� for������ ��ü�� �ϳ��� ������ ���� ������ �����ϴµ����� ������ �ڵ尡 �ʿ�������.
		 * 
		 * ���� Iterator�������̽��� ������ ��ü(�ݺ���)�� iterator()�޼ҵ�� ȣ���Ͽ� ��ü�� �������ų� �����ϴ� �۾��� �մϴ�. 
		 * �ݺ����� �޼ҵ��� hasNext()�޼ҵ�� ������ ��ü�� �ִ��� Ȯ���ϰ�, next()�޼ҵ�� ��ü�� �ϳ� �����´�. 
		 * �׸��� remove()�� Iterator�� next()�޼ҵ�� ������ ��ü�� �����Ѵ�. ������ Set�÷����� ��ü�� ���ŵǰ� �ȴ�. */
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String str = iterator.next();
			if(str.equals("SAT")) {
				iterator.remove();	// �� Iterator�� remove()�޼ҵ�
			}
			System.out.print(str + " | ");
		}
		System.out.println();
		for(String str : set) {
			System.out.print(str + " | ");
		}
		
		if(!set.isEmpty()) {	// isEmpty()�޼ҵ�� Set�÷����� ����ִ��� Ȯ���մϴ�.	
			set.remove("WEN");	// Set�� remove()�޼ҵ�� �Ű������� �־��� ��ü�� Set�÷��ǿ��� �����մϴ�.
			System.out.println("\nSet�÷��ǿ� ����� \"WEN\"�� �����߽��ϴ�.");
			set.clear();		// clear()�޼ҵ�� Set�÷��ǿ� ����� ��� ��ü�� �����մϴ�.
			System.out.println("Set�÷����� ������ϴ�.");
			System.out.println("Set�÷��ǿ� ����� ��ü ��:" + set.size());
		}
	}
}
