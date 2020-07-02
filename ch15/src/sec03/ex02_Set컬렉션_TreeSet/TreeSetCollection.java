package sec03.ex02_Set컬렉션_TreeSet;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetCollection {
	public static void main(String[] args) {
		/* TreeSet객체를 Set인터페이스타입으로 할 수 있지만 TreeSet의 메소드를 사용하기 위해 TreeSet타입으로 해주었다.
		 * TreeSet에 객체를 저장하면 자동으로 오름차순 정렬된다. */
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		for(int i=0; i<100; i=i+4) {
			treeSet.add(i);
		}
		
		System.out.println("가장 낮은 객체: " + treeSet.first());
		System.out.println("가장 높은 객체: " + treeSet.last());
		System.out.println("보다 낮은 객체: " + treeSet.lower(20));
		System.out.println("보다 높은 객체: " + treeSet.higher(44));
		System.out.println("주어진 객체가 없을경우 보다 낮은 객체: " + treeSet.floor(20));
		System.out.println("주어진 객체가 없을경우 보다 높은 객체: " + treeSet.ceiling(44));
		System.out.println("가장 낮은 객체를 꺼내고 컬렉션에서 제거: " + treeSet.pollFirst());
		System.out.println("가장 높은 객체를 꺼내고 컬렉션에서 제거: " + treeSet.pollLast());
		
		System.out.print("[내림차순으로 정렬] ");
		Iterator<Integer> iterator = treeSet.descendingIterator(); 	// 내림차순으로 정렬된 Iterator를 리턴
		while(iterator.hasNext()) {
			int value  = iterator.next();
			System.out.print(value + " | ");
		}
		
		System.out.print("\n[내림차순으로 정렬] ");
		NavigableSet<Integer> navigable = treeSet.descendingSet();
		for(int value : navigable) {
			System.out.print(value + " | ");
		}

		System.out.print("\n[오름차순으로 정렬] ");
		navigable = treeSet.descendingSet().descendingSet();	// descendingSet()메소드를 두 번 적용하면 오름차순이 된다.
		for(int value : navigable) {
			System.out.print(value + " | ");
		}
		
		System.out.print("\n[주어진 객체 보다 낮거나 같은 객체들] ");
		NavigableSet<Integer> headSet = navigable.headSet(88, true);	
		for(int value : headSet) {
			System.out.print(value + " | ");
		}
		
		System.out.print("\n[주어진 객체 보다 높은 객체들] ");
		NavigableSet<Integer> tailSet = navigable.tailSet(60, false);
		for(int value : tailSet) {
			System.out.print(value + " | ");
		}
		
		System.out.print("\n[시작과 끝으로 주어진 객체 사이의 객체들] ");
		NavigableSet<Integer> subSet = navigable.subSet(5,false,60, true);
		for(int value : subSet) {
			System.out.print(value + " | ");
		}
		
	}
}