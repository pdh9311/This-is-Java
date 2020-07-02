package sec04.ex02_Map�÷���_Hashtable;

import java.util.*;

public class HashtableCollection {
	public static void main(String[] args) {
		// Hashtable�� ����ȭ�� �޼ҵ�� �����Ǿ� �ֱ� ������ �����尡 ����(Thread Safe)�ϴ�.
		Map<String,Integer> map = new Hashtable<String,Integer>();
		map.put("��", 1);
		map.put("��", 2);
		map.put("��", 3);
		map.put("��", 4);
		map.put("��", 5);
		map.put("��", 6);
		map.put("ĥ", 7);
		map.put("��", 8);
		Integer v = map.put("��", 10);
		System.out.println(v);
		v = map.put("��", 9);	
		System.out.println(v);
		
		if(map.containsKey("��")) {
			System.out.println("Map�� key������ \"��\"�� �ֽ��ϴ�.");
		}
		if(map.containsValue(3)) {
			System.out.println("Map�� value������ 3�� �ֽ��ϴ�.");
		}

		if(!map.isEmpty()) {	
			System.out.println("���� �� Entry��ü�� ��: " + map.size());
			
			System.out.print("[��ü ���� ��� 1] ");
			Set<Map.Entry<String,Integer>>	entrySet = map.entrySet();	
			Iterator<Map.Entry<String,Integer>> entryIterator = entrySet.iterator();
			while(entryIterator.hasNext()) {
				Map.Entry<String, Integer> entry = entryIterator.next();
				String key = entry.getKey();		
				Integer value = entry.getValue();	
				System.out.print(key + ": " + value + " |");
			}
			System.out.println();
			map.remove("ĥ");	
			
			System.out.print("[��ü ���� ��� 2] ");
			Set<String> keySet = map.keySet();		
			Iterator<String> keyIterator = keySet.iterator();	
			while(keyIterator.hasNext()) {
				String key = keyIterator.next();
				Integer value = map.get(key);		
				System.out.print(key + ": " + value + " |");
			}
			System.out.println();
			
			System.out.print("[Entry�� value���� ����] ");
			Collection<Integer> values = map.values();		
			Iterator<Integer> valueIterator = values.iterator();
			while(valueIterator.hasNext()) {
				System.out.print(valueIterator.next() + " |");
			}
			System.out.println(); 
		
		}
		map.clear();	
		System.out.println("���� �� Entry��ü�� ��: " + map.size());
	}
}
