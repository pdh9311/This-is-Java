package sec05.ex01_Comparable;

import java.util.TreeSet;

/* TreeSet, TreeMap�� ������ ���� Comparable�� ������ ��ü�� �䱸�ϴµ�,
 * Integer,Double,String�� ��� Comparable �������̽��� �����ϰ� �ֽ��ϴ�.
 * ���� ����� ���� Ŭ������ TreeSet�̳� TreeMap���� ����ϱ� ���ؼ��� 
 * ����� ���� Ŭ������ Comparable �������̽��� �����Ͽ� compareTo()�޼ҵ带 �����ϰ� �־�� �մϴ�. */
public class ComparableEX {
	public static void main(String[] args) {
		Person p1 = new Person("�Ϲ����",1);
		Person p2 = new Person("�̹����",2);
		Person p3 = new Person("������",3);
		Person p4 = new Person("������",4);
		Person p5 = new Person("�������",5);
		
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
