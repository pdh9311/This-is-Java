package sec04.ex04_Map컬렉션_TreeMap;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapCollection {
	public static void main(String[] args) {
		/* TreeMap객체를 Map인터페이스타입으로 할 수 있지만 TreeMap의 메소드를 사용하기 위해 TreeMap타입으로 해주었다.
		 * TreeMap에 객체를 저장하면 자동으로 Entry의 key값을 기준으로 오름차순 정렬된다. */
		TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
		for(int i=0; i<100; i=i+3) {
			treeMap.put(i, i*3/7*22);
		}

		System.out.println("가장 낮은 Entry객체: " + treeMap.firstEntry());
		System.out.println("가장 높은 Entry객체: " + treeMap.lastEntry());
		System.out.println("보다 낮은 Entry객체: " + treeMap.lowerEntry(21));
		System.out.println("보다 높은 Entry객체: " + treeMap.higherEntry(33));
		System.out.println("주어진 객체가 없을경우 보다 낮은 Entry객체: " + treeMap.floorEntry(21));
		System.out.println("주어진 객체가 없을경우 보다 높은 Entry객체: " + treeMap.ceilingEntry(33));
		System.out.println("가장 낮은 Entry객체를 꺼내고 컬렉션에서 제거: " + treeMap.pollFirstEntry());
		System.out.println("가장 높은 Entry객체를 꺼내고 컬렉션에서 제거: " + treeMap.pollLastEntry());
		// descendingKeySet(), descendingMap() 메소드 둘 다 메소드를 두 번 적용하면 오름차순이 된다. 
		System.out.print("[내림차순으로 정렬] ");
		NavigableSet<Integer> navigableSet = treeMap.descendingKeySet();
		for(int key : navigableSet) {
			System.out.print(key + "," + treeMap.get(key) + "|");
		}
		
		System.out.print("\n[오름차순으로 정렬] ");
		navigableSet = treeMap.descendingKeySet().descendingSet();
		for(int key : navigableSet) {
			System.out.print(key + "," + treeMap.get(key) + "|");
		}

		System.out.println("\n[내림차순으로 정렬] ");
		NavigableMap<Integer,Integer> navigableMap = treeMap.descendingMap();
		Set<Map.Entry<Integer,Integer>> navigableEntrySet = navigableMap.entrySet();
		// 방법1
		for(Map.Entry<Integer, Integer> entry : navigableEntrySet) {
			System.out.print("("+entry.getKey()+","+entry.getValue()+")");
		}
		
		System.out.println();
		// 방법2
		Iterator<Map.Entry<Integer,Integer>> navigableIterator = navigableEntrySet.iterator();
		while(navigableIterator.hasNext()) {
			Map.Entry<Integer, Integer> entry = navigableIterator.next();
			int key = entry.getKey();
			int value = entry.getValue();
			System.out.print("("+key+","+value+")");
		}
		
		System.out.println("\n[오름차순으로 정렬] ");
		navigableMap = treeMap.descendingMap().descendingMap();
		// 방법3
		Set<Integer> navigableKeySet = navigableMap.keySet();
		for(int key : navigableKeySet) {
			System.out.print("(" + key + "," +navigableMap.get(key)+")");
		}
		
	}
}
