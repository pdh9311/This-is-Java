package sec04.ex04_Map�÷���_TreeMap;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapCollection {
	public static void main(String[] args) {
		/* TreeMap��ü�� Map�������̽�Ÿ������ �� �� ������ TreeMap�� �޼ҵ带 ����ϱ� ���� TreeMapŸ������ ���־���.
		 * TreeMap�� ��ü�� �����ϸ� �ڵ����� Entry�� key���� �������� �������� ���ĵȴ�. */
		TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
		for(int i=0; i<100; i=i+3) {
			treeMap.put(i, i*3/7*22);
		}

		System.out.println("���� ���� Entry��ü: " + treeMap.firstEntry());
		System.out.println("���� ���� Entry��ü: " + treeMap.lastEntry());
		System.out.println("���� ���� Entry��ü: " + treeMap.lowerEntry(21));
		System.out.println("���� ���� Entry��ü: " + treeMap.higherEntry(33));
		System.out.println("�־��� ��ü�� ������� ���� ���� Entry��ü: " + treeMap.floorEntry(21));
		System.out.println("�־��� ��ü�� ������� ���� ���� Entry��ü: " + treeMap.ceilingEntry(33));
		System.out.println("���� ���� Entry��ü�� ������ �÷��ǿ��� ����: " + treeMap.pollFirstEntry());
		System.out.println("���� ���� Entry��ü�� ������ �÷��ǿ��� ����: " + treeMap.pollLastEntry());
		// descendingKeySet(), descendingMap() �޼ҵ� �� �� �޼ҵ带 �� �� �����ϸ� ���������� �ȴ�. 
		System.out.print("[������������ ����] ");
		NavigableSet<Integer> navigableSet = treeMap.descendingKeySet();
		for(int key : navigableSet) {
			System.out.print(key + "," + treeMap.get(key) + "|");
		}
		
		System.out.print("\n[������������ ����] ");
		navigableSet = treeMap.descendingKeySet().descendingSet();
		for(int key : navigableSet) {
			System.out.print(key + "," + treeMap.get(key) + "|");
		}

		System.out.println("\n[������������ ����] ");
		NavigableMap<Integer,Integer> navigableMap = treeMap.descendingMap();
		Set<Map.Entry<Integer,Integer>> navigableEntrySet = navigableMap.entrySet();
		// ���1
		for(Map.Entry<Integer, Integer> entry : navigableEntrySet) {
			System.out.print("("+entry.getKey()+","+entry.getValue()+")");
		}
		
		System.out.println();
		// ���2
		Iterator<Map.Entry<Integer,Integer>> navigableIterator = navigableEntrySet.iterator();
		while(navigableIterator.hasNext()) {
			Map.Entry<Integer, Integer> entry = navigableIterator.next();
			int key = entry.getKey();
			int value = entry.getValue();
			System.out.print("("+key+","+value+")");
		}
		
		System.out.println("\n[������������ ����] ");
		navigableMap = treeMap.descendingMap().descendingMap();
		// ���3
		Set<Integer> navigableKeySet = navigableMap.keySet();
		for(int key : navigableKeySet) {
			System.out.print("(" + key + "," +navigableMap.get(key)+")");
		}
		
	}
}
