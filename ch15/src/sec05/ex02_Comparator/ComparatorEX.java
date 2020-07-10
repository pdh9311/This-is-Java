package sec05.ex02_Comparator;

import java.util.TreeSet;

public class ComparatorEX {
	public static void main(String[] args) {
		Man m1 = new Man("일번남",1);
		Man m2 = new Man("이번남",2);
		Man m3 = new Man("삼번남",3);
		Man m4 = new Man("사번남",4);
		Man m5 = new Man("오번남",5);
		
		TreeSet<Man> treeSet = new TreeSet<Man>(new AscendingComparator());
		treeSet.add(m1);
		treeSet.add(m2);
		treeSet.add(m3);
		treeSet.add(m4);
		treeSet.add(m5);
		
		for(Man m : treeSet) {
			System.out.print(m.name + " : " + m.age + " | ");
		}
		
		System.out.println();
		
		treeSet = new TreeSet<Man>(new DescendingComparator());
		treeSet.add(m1);
		treeSet.add(m2);
		treeSet.add(m3);
		treeSet.add(m4);
		treeSet.add(m5);
		
		for(Man m : treeSet) {
			System.out.print(m.name + " : " + m.age + " | ");
		}

	}
}
