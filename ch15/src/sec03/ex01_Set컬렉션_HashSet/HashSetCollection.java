package sec03.ex01_Set컬렉션_HashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetCollection {
	public static void main(String[] args) {
		/* HashSet은 객체를 순서 없이 저장하고 동일한 객체는 중복 저장하지 않는다.
		 * 동일한 객체를 판단하는 기준은 먼저 객체의 hashCode()가 같고, equals()가 같으면 동일한 객체로 판단한다.
		 * String객체는 문자열이 같으면 hashCode()와 equals()같도록 재정의되어 있어서 문자열만 같으면 동일한 객체로 판단한다. */
		Set<String> set = new HashSet<String>();
		// Set컬렉션에 저장할땐 add()메소드를 사용하며 성공적으로 저장되면 true를 중복객체면 false를 리턴한다.
		set.add("SUN");
		set.add("MON");
		set.add("TUE");
		set.add("WEN");
		set.add("THR");
		set.add("FRI");
		boolean isSuccess = set.add("SAT");
		System.out.println("객체 저장 성공? " + isSuccess);
		isSuccess = set.add("SAT");	// 같은 "SAT"문자열을 Set컬렉션에 저장해도 중복저장되지 않고 하나만 저장된다.
		System.out.println("객체 저장 성공? " + isSuccess);
		
		// size()메소드는 Set컬렉션에 저장된 객체 수를 리턴한다.
		System.out.println("Set컬렉션에 저장된 객체 수:" + set.size());	
		
		// contains()메소드는 Set컬렉션에 매개값으로 주어진 객체가 저장되어 있는지 확인한다. 
		if(set.contains("WEN")) {
			System.out.println("Set 컬렉션에 WEN이 포함되어 있습니다.");
		}

		/* Set컬렉션에는 순서 없이 객체가 저장되므로 인덱스를 매개값으로 갖는 메소드가 없어서 
		 * for(int i=0; i<set.size(); i++) {} 이 for반복문을 이용해서 객체를 하나씩 가져오거나, 제거하는데 복잡한 코드가 필요해진다.
		 * 또한 향상된 for문으로 객체를 하나씩 가져올 수는 있지만 제거하는데에는 복잡한 코드가 필요해진다.
		 * 
		 * 따라서 Iterator인터페이스를 구현한 객체(반복자)를 iterator()메소드로 호출하여 객체를 가져오거나 제거하는 작업을 합니다. 
		 * 반복자의 메소드인 hasNext()메소드는 가져올 객체가 있는지 확인하고, next()메소드는 객체를 하나 가져온다. 
		 * 그리고 remove()는 Iterator의 next()메소드로 가져온 객체를 제거한다. 실제로 Set컬렉션의 객체가 제거되게 된다. */
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String str = iterator.next();
			if(str.equals("SAT")) {
				iterator.remove();	// ← Iterator의 remove()메소드
			}
			System.out.print(str + " | ");
		}
		System.out.println();
		for(String str : set) {
			System.out.print(str + " | ");
		}
		
		if(!set.isEmpty()) {	// isEmpty()메소드는 Set컬렉션이 비어있는지 확인합니다.	
			set.remove("WEN");	// Set의 remove()메소드는 매개값으로 주어진 객체를 Set컬렉션에서 제거합니다.
			System.out.println("\nSet컬렉션에 저장된 \"WEN\"을 제거했습니다.");
			set.clear();		// clear()메소드는 Set컬렉션에 저장된 모든 객체를 제거합니다.
			System.out.println("Set컬렉션을 비웠습니다.");
			System.out.println("Set컬렉션에 저장된 객체 수:" + set.size());
		}
	}
}
