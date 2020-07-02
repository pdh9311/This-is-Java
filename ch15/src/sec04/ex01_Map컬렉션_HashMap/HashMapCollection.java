package sec04.ex01_Map컬렉션_HashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapCollection {
	public static void main(String[] args) {
		/* Map컬렉션은 key와 value로 구성된 Entry객체를 저장한다. key는 중복저장 될수 없고, value는 중복저장할 수 있다.
		 * 만약 동일한 key로 저장하면 기존의 값은 없어지고 새로운 값으로 대체된다.
		 * Hashtable의 key는 중복저장되면 안되므로 hashCode()와 equals()를 이용해서 동등객체인지 확인한다. 
		 * Hashtable은 동기화된 메소드로 구성되어 있어서 멀티 스레드가 동시에 메소드를 실행할 수 없다.*/
		Map<String,Integer> map = new HashMap<String,Integer>();
		// Map컬렉션에 Entry객체를 저장하기 위해서 put()메소드를 사용하며 중복되지 않는 key는 null을 리턴하고, 중복인 key는 대체되기전의 값을 리턴한다.
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
		v = map.put("구", 9);		// 중복되는 key로 저장시 새로운 value값으로 대체된다.
		System.out.println(v);
		
		// containsKey()메소드는 주어진 매개값과 같은 key가 있는지 확인한다. 
		if(map.containsKey("사")) {
			System.out.println("Map의 key값으로 \"사\"가 있습니다.");
		}
		// containsValue()메소드는 주어진 매개값과 같은 value가 있는지 확인한다. 
		if(map.containsValue(3)) {
			System.out.println("Map의 value값으로 3이 있습니다.");
		}

		if(!map.isEmpty()) {	// isEmpty()메소드는 Map컬렉션이 비어있는지 확인한다.
			System.out.println("현재 총 Entry객체의 수: " + map.size());	// Map컬렉션에 저장되어있는 Entry객체의 총 수를 알 수 있다.
			
			System.out.print("[객체 관리 방법 1] ");
			Set<Map.Entry<String,Integer>>	entrySet = map.entrySet();	// entrySet()메소드는 모든 Map.Entry객체를 Set컬렉션에 담아준다.
			Iterator<Map.Entry<String,Integer>> entryIterator = entrySet.iterator();
			while(entryIterator.hasNext()) {
				Map.Entry<String, Integer> entry = entryIterator.next();
				String key = entry.getKey();		// getKey()메소드는 Entry의 key값을 가져온다.
				Integer value = entry.getValue();	// getValue()메소드는 Entry의 value값을 가져온다.
				System.out.print(key + ": " + value + " |");
			}
			System.out.println();
			map.remove("칠");	// Map의 remove()메소드는 주어진 매개값과 같은 key의 Entry객체를 제거한다.
			
			System.out.print("[객체 관리 방법 2] ");
			Set<String> keySet = map.keySet();		// keySet()메소드는 모든 key값을 Set컬렉션에 담아준다.
			Iterator<String> keyIterator = keySet.iterator();	
			while(keyIterator.hasNext()) {
				String key = keyIterator.next();
				Integer value = map.get(key);		// get()메소드는 주어진 매개값과 같은 key를 가진 Entry의 value값을 가져온다.
				System.out.print(key + ": " + value + " |");
			}
			System.out.println();
			
			System.out.print("[Entry의 value값만 추출] ");
			Collection<Integer> values = map.values();		// values()메소드는 모든 value값을 Collection에 담아준다.
			Iterator<Integer> valueIterator = values.iterator();
			while(valueIterator.hasNext()) {
				System.out.print(valueIterator.next() + " |");
			}
			System.out.println(); 
		
		}
		map.clear();	// clear()메소드는 모든 Entry객체를 제거한다.
		System.out.println("현재 총 Entry객체의 수: " + map.size());
	}
}
