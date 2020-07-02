package sec01.ex01_List_Set_Map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class ListSetMap {
	public static void main(String[] args) {
		/* List와 Set은 객체를 추가, 삭제, 검색하는 방법에 많은 공통점이 있기 때문에
		 * List 인터페이스와 Set 인터페이스 의 공통된 메소드들만 모아 Collection 인터페이스로 정의해 두고 있다. */
		Collection<Object> collectionArrayList = new ArrayList<>();
		Collection<Object> collectionVector = new Vector<>();
		Collection<Object> collectionLinkedList = new LinkedList<>();
		Collection<Object> collectionHashSet = new HashSet<>();
		Collection<Object> collectionTreeSet = new TreeSet<>();
		
		List<Object> arrayList = new ArrayList<>();
		List<Object> vector = new Vector<>();				// 동기화된 메소드로 구성되어 있어 멀티 스레드환경에서 안전하다.
		List<Object> linkedList = new LinkedList<>();		
		
		Set<Object> hashSet = new HashSet<>();
		Set<Object> treeSet = new TreeSet<>();				// 검색 기능을 강화시킨 컬렉션
		
		Map<Object,Object> hashMap = new HashMap<>();
		Map<Object,Object> hashtable = new Hashtable<>();	// 동기화된 메소드로 구성되어 있어 멀티 스레드환경에서 안전하다.
		Map<Object,Object> treeMap = new TreeMap<>();		// 검색 기능을 강화시킨 컬렉션
		Properties properties = new Properties(); 			// Properties는 Hashtable의 하위클래스이며 키와 값을 String타입으로 제한한 컬렉션이다.	
	}
}
