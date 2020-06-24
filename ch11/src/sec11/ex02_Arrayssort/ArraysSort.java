package sec11.ex02_Arrayssort;

import java.util.Arrays;

public class ArraysSort {
	public static void main(String[] args) {
		int[] arr1 = {93,23,45,112};
		Arrays.sort(arr1);
		System.out.println(Arrays.toString(arr1));
		
		String[] arr2 = {"ȫ�⵿","ȫ�ϵ�","ȫ�̵�","ȫ�ﵿ","ȫ�絿"};
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		
		Member m1 = new Member("�ڵ���");
		Member m2 = new Member("�ڼ���");
		Member m3 = new Member("�ڳ���");
		Member m4 = new Member("�ں���");
		Member[] ms = {m1,m2,m3,m4};
		Arrays.sort(ms);		
		for(Member m : ms) {
			System.out.print(m.name + "  ");
		}
		
		// �迭 �˻�   Arrays.binarySearch(�迭,ã����);
		int index = Arrays.binarySearch(arr1, 93);
		System.out.println("\nã�� �ε���: " + index);
		
		
		
		
		
		
	}
	
}

//����ڰ� ������ Ŭ������ �����Ұ�쿡�� ����� ���� Ŭ������ Comparable�������̽��� �����ؾ� ������ �����ϴ�.
class Member implements Comparable<Member> {
	String name;
	
	public Member(String name) {
		this.name = name;
	}

	/* A.compareTo(B)���� ���������� ���
	 * A�� B���� ���� ��� ������ ���� 
	 * A�� B���� ���� ��� ����� ����
	 * A�� B�� ���� ��� 0�� ����
	 */
	@Override
	public int compareTo(Member o) {
		return name.compareTo(o.name);
	}	
	
}
