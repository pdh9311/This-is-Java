package sec04.ex01_Map�÷���_HashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapCollection {
	public static void main(String[] args) {
		/* Map�÷����� key�� value�� ������ Entry��ü�� �����Ѵ�. key�� �ߺ����� �ɼ� ����, value�� �ߺ������� �� �ִ�.
		 * ���� ������ key�� �����ϸ� ������ ���� �������� ���ο� ������ ��ü�ȴ�.
		 * Hashtable�� key�� �ߺ�����Ǹ� �ȵǹǷ� hashCode()�� equals()�� �̿��ؼ� ���ü���� Ȯ���Ѵ�. 
		 * Hashtable�� ����ȭ�� �޼ҵ�� �����Ǿ� �־ ��Ƽ �����尡 ���ÿ� �޼ҵ带 ������ �� ����.*/
		Map<String,Integer> map = new HashMap<String,Integer>();
		// Map�÷��ǿ� Entry��ü�� �����ϱ� ���ؼ� put()�޼ҵ带 ����ϸ� �ߺ����� �ʴ� key�� null�� �����ϰ�, �ߺ��� key�� ��ü�Ǳ����� ���� �����Ѵ�.
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
		v = map.put("��", 9);		// �ߺ��Ǵ� key�� ����� ���ο� value������ ��ü�ȴ�.
		System.out.println(v);
		
		// containsKey()�޼ҵ�� �־��� �Ű����� ���� key�� �ִ��� Ȯ���Ѵ�. 
		if(map.containsKey("��")) {
			System.out.println("Map�� key������ \"��\"�� �ֽ��ϴ�.");
		}
		// containsValue()�޼ҵ�� �־��� �Ű����� ���� value�� �ִ��� Ȯ���Ѵ�. 
		if(map.containsValue(3)) {
			System.out.println("Map�� value������ 3�� �ֽ��ϴ�.");
		}

		if(!map.isEmpty()) {	// isEmpty()�޼ҵ�� Map�÷����� ����ִ��� Ȯ���Ѵ�.
			System.out.println("���� �� Entry��ü�� ��: " + map.size());	// Map�÷��ǿ� ����Ǿ��ִ� Entry��ü�� �� ���� �� �� �ִ�.
			
			System.out.print("[��ü ���� ��� 1] ");
			Set<Map.Entry<String,Integer>>	entrySet = map.entrySet();	// entrySet()�޼ҵ�� ��� Map.Entry��ü�� Set�÷��ǿ� ����ش�.
			Iterator<Map.Entry<String,Integer>> entryIterator = entrySet.iterator();
			while(entryIterator.hasNext()) {
				Map.Entry<String, Integer> entry = entryIterator.next();
				String key = entry.getKey();		// getKey()�޼ҵ�� Entry�� key���� �����´�.
				Integer value = entry.getValue();	// getValue()�޼ҵ�� Entry�� value���� �����´�.
				System.out.print(key + ": " + value + " |");
			}
			System.out.println();
			map.remove("ĥ");	// Map�� remove()�޼ҵ�� �־��� �Ű����� ���� key�� Entry��ü�� �����Ѵ�.
			
			System.out.print("[��ü ���� ��� 2] ");
			Set<String> keySet = map.keySet();		// keySet()�޼ҵ�� ��� key���� Set�÷��ǿ� ����ش�.
			Iterator<String> keyIterator = keySet.iterator();	
			while(keyIterator.hasNext()) {
				String key = keyIterator.next();
				Integer value = map.get(key);		// get()�޼ҵ�� �־��� �Ű����� ���� key�� ���� Entry�� value���� �����´�.
				System.out.print(key + ": " + value + " |");
			}
			System.out.println();
			
			System.out.print("[Entry�� value���� ����] ");
			Collection<Integer> values = map.values();		// values()�޼ҵ�� ��� value���� Collection�� ����ش�.
			Iterator<Integer> valueIterator = values.iterator();
			while(valueIterator.hasNext()) {
				System.out.print(valueIterator.next() + " |");
			}
			System.out.println(); 
		
		}
		map.clear();	// clear()�޼ҵ�� ��� Entry��ü�� �����Ѵ�.
		System.out.println("���� �� Entry��ü�� ��: " + map.size());
	}
}
