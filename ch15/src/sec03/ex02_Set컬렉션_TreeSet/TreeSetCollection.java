package sec03.ex02_Set�÷���_TreeSet;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetCollection {
	public static void main(String[] args) {
		/* TreeSet��ü�� Set�������̽�Ÿ������ �� �� ������ TreeSet�� �޼ҵ带 ����ϱ� ���� TreeSetŸ������ ���־���.
		 * TreeSet�� ��ü�� �����ϸ� �ڵ����� �������� ���ĵȴ�. */
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		for(int i=0; i<100; i=i+4) {
			treeSet.add(i);
		}
		
		System.out.println("���� ���� ��ü: " + treeSet.first());
		System.out.println("���� ���� ��ü: " + treeSet.last());
		System.out.println("���� ���� ��ü: " + treeSet.lower(20));
		System.out.println("���� ���� ��ü: " + treeSet.higher(44));
		System.out.println("�־��� ��ü�� ������� ���� ���� ��ü: " + treeSet.floor(20));
		System.out.println("�־��� ��ü�� ������� ���� ���� ��ü: " + treeSet.ceiling(44));
		System.out.println("���� ���� ��ü�� ������ �÷��ǿ��� ����: " + treeSet.pollFirst());
		System.out.println("���� ���� ��ü�� ������ �÷��ǿ��� ����: " + treeSet.pollLast());
		
		System.out.print("[������������ ����] ");
		Iterator<Integer> iterator = treeSet.descendingIterator(); 	// ������������ ���ĵ� Iterator�� ����
		while(iterator.hasNext()) {
			int value  = iterator.next();
			System.out.print(value + " | ");
		}
		
		System.out.print("\n[������������ ����] ");
		NavigableSet<Integer> navigable = treeSet.descendingSet();
		for(int value : navigable) {
			System.out.print(value + " | ");
		}

		System.out.print("\n[������������ ����] ");
		navigable = treeSet.descendingSet().descendingSet();	// descendingSet()�޼ҵ带 �� �� �����ϸ� ���������� �ȴ�.
		for(int value : navigable) {
			System.out.print(value + " | ");
		}
		
		System.out.print("\n[�־��� ��ü ���� ���ų� ���� ��ü��] ");
		NavigableSet<Integer> headSet = navigable.headSet(88, true);	
		for(int value : headSet) {
			System.out.print(value + " | ");
		}
		
		System.out.print("\n[�־��� ��ü ���� ���� ��ü��] ");
		NavigableSet<Integer> tailSet = navigable.tailSet(60, false);
		for(int value : tailSet) {
			System.out.print(value + " | ");
		}
		
		System.out.print("\n[���۰� ������ �־��� ��ü ������ ��ü��] ");
		NavigableSet<Integer> subSet = navigable.subSet(5,false,60, true);
		for(int value : subSet) {
			System.out.print(value + " | ");
		}
		
	}
}