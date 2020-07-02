package sec07.ex01_ListSetMap동기화;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsSynchroniezedXXX {
	public static void main(String[] args) {
		/* 경우에 따라서 ArrayList, HashSet, HashMap을 싱글 스레드 환경에서 사용하다가 멀티스레드 환경으로 전달할 필요가 있을 것이다.
		 * 이때 Collections에 정적메소드인 synchronizedXXX()메소드에 매개값으로 비동기화된 컬렉션을 넣어주면 동기화된 컬렉션을 리턴해준다. */
		
		List<Object> list = Collections.synchronizedList(new ArrayList<Object>());
		
		Set<Object> set = Collections.synchronizedSet(new HashSet<Object>());
		
		Map<Object,Object> map = Collections.synchronizedMap(new HashMap<Object,Object>());
		
	}
}
