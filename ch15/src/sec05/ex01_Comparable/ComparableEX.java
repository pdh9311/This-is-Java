package sec05.ex01_Comparable;

import java.util.TreeSet;

/* TreeSet, TreeMap은 정렬을 위해 Comparable을 구현한 객체를 요구하는데,
 * Integer,Double,String은 모두 Comparable 인터페이스를 구현하고 있습니다.
 * 만약 사용자 정의 클래스를 TreeSet이나 TreeMap에서 사용하기 위해서는 
 * 사용자 정의 클래스가 Comparable 인터페이스를 구현하여 compareTo()메소드를 정의하고 있어야 합니다. */
public class ComparableEX {
	public static void main(String[] args) {
		Person p1 = new Person("일번사람",1);
		Person p2 = new Person("이번사람",2);
		Person p3 = new Person("삼번사람",3);
		Person p4 = new Person("사번사람",4);
		Person p5 = new Person("오번사람",5);
		
		TreeSet<Person> treeSet = new TreeSet<Person>();
		treeSet.add(p1);
		treeSet.add(p2);
		treeSet.add(p3);
		treeSet.add(p4);
		treeSet.add(p5);
		
		for(Person p : treeSet) {
			System.out.println(p.name +" : " + p.age);
		}
	}
}
