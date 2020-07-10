package sec02.ex01_List컬렉션_ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListCollection {
	public static void main(String[] args) {
		/* 일반배열은 생성할때 크기가 고정되고 사용 중에 크기를 변경할 수 없다.
		 * 하지만 List 인터페이스로 구현된 클래스는 저장용량을 초과하여 객체가 들어올 경우 자동적으로 저장용량이 늘어난다.
		 * 또한, 초기용량은 10이지만 생성자의 매개값으로 값을 넣어서 초기용량을 설정할 수 있다. */
		String[] strArr = new String[10];	// 일반배열
		List<String> list = new ArrayList<String>();	// List인터페이스로 구현된 ArrayList(초기용량:10)
		list = new ArrayList<String>(7);	// 생성자의 매개값으로 초기용량을 설정(초기용량:7)
		
		// 맨끝에 객체를 추가
		list.add("day");
		list.add("MON");	
		list.add("THU");
		list.add("FRI");
		list.add("SAT");
		// 주어진 인덱스에 객체를 삽입
		list.add(1,"TUE"); 
		list.add(2,"WEN");
		// 주어진 인덱스에 저장된 객체를 주어진 객체로 바꿈
		list.set(0,"SUN");
		
		// contains()메소드의 매개값으로 주어진 객체가 저장되어 있는지 알 수 있다.
		if(list.contains("day")) {
			System.out.println("day가 포함되어있습니다.");
		} else {
			System.out.println("day가 포함되어있지 않습니다.");
		}
		
		// size()메소드로 List에 저장된 객체의 수를 알 수 있다.
		for(int i=0;i<list.size();i++) {
			System.out.print("  " + i + "  |");
		}
		
		System.out.println();
		
		// isEmpty()메소드로 List에 저장된 객체가 없는지 확인 할 수 있다.
		if(!list.isEmpty()) {
			for(int i=0; i<list.size(); i++) {
				System.out.print(" " + list.get(i) + " |");		// 
			}
		}
		
		System.out.println();

		list.remove(3);			// 인덱스로 객체 삭제
		list.remove(3);			// 인덱스로 객체 삭제
		list.remove("MON");		// 주어진 객체를 삭제
		
		for(String str : list) {
			System.out.print(" " + str + " |");
		}
		
		list.clear();		// clear()메소드로 List에 저장된 모든 객체를 삭제 한다. 
		if(list.isEmpty()) { System.out.println("\n저장된 객체가 없습니다."); }
		
		// 고정된 객체들로 구성된 List를 생성할 때 Arrays.asList();
		list = Arrays.asList("HTML","Java","JSP/Servlet");
		for(String str : list) {
			System.out.print(" " + str + " |");
		}
	}
}
