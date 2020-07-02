package sec04.ex02_Map컬렉션_Hashtable;

import java.util.*;

public class HashtableCollection {
	public static void main(String[] args) {
		// Hashtable은 동기화된 메소드로 구성되어 있기 때문에 스레드가 안전(Thread Safe)하다.
		Map<String,Integer> map = new Hashtable<String,Integer>();
		map.put("일", 1);
		map.put("이", 2);
		map.put("삼", 3);
		map.put("사", 4);
		map.put("오", 5);
		map.put("육", 6);
		map.put("칠", 7);
		map.put("팔", 8);
		Integer v = map.put("구", 10);
		System.out.println(v);
		v = map.put("구", 9);	
		System.out.println(v);
		
		if(map.containsKey("사")) {
			System.out.println("Map의 key값으로 \"사\"가 있습니다.");
		}
		if(map.containsValue(3)) {
			System.out.println("Map의 value값으로 3이 있습니다.");
		}

		if(!map.isEmpty()) {	
			System.out.println("현재 총 Entry객체의 수: " + map.size());
			
			System.out.print("[객체 관리 방법 1] ");
			Set<Map.Entry<String,Integer>>	entrySet = map.entrySet();	
			Iterator<Map.Entry<String,Integer>> entryIterator = entrySet.iterator();
			while(entryIterator.hasNext()) {
				Map.Entry<String, Integer> entry = entryIterator.next();
				String key = entry.getKey();		
				Integer value = entry.getValue();	
				System.out.print(key + ": " + value + " |");
			}
			System.out.println();
			map.remove("칠");	
			
			System.out.print("[객체 관리 방법 2] ");
			Set<String> keySet = map.keySet();		
			Iterator<String> keyIterator = keySet.iterator();	
			while(keyIterator.hasNext()) {
				String key = keyIterator.next();
				Integer value = map.get(key);		
				System.out.print(key + ": " + value + " |");
			}
			System.out.println();
			
			System.out.print("[Entry의 value값만 추출] ");
			Collection<Integer> values = map.values();		
			Iterator<Integer> valueIterator = values.iterator();
			while(valueIterator.hasNext()) {
				System.out.print(valueIterator.next() + " |");
			}
			System.out.println(); 
		
		}
		map.clear();	
		System.out.println("현재 총 Entry객체의 수: " + map.size());
	}
}
