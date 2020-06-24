package sec11.ex02_Arrayssort;

import java.util.Arrays;

public class ArraysSort {
	public static void main(String[] args) {
		int[] arr1 = {93,23,45,112};
		Arrays.sort(arr1);
		System.out.println(Arrays.toString(arr1));
		
		String[] arr2 = {"홍기동","홍일동","홍이동","홍삼동","홍사동"};
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		
		Member m1 = new Member("박동현");
		Member m2 = new Member("박서현");
		Member m3 = new Member("박남현");
		Member m4 = new Member("박북현");
		Member[] ms = {m1,m2,m3,m4};
		Arrays.sort(ms);		
		for(Member m : ms) {
			System.out.print(m.name + "  ");
		}
		
		// 배열 검색   Arrays.binarySearch(배열,찾을값);
		int index = Arrays.binarySearch(arr1, 93);
		System.out.println("\n찾은 인덱스: " + index);
		
		
		
		
		
		
	}
	
}

//사용자가 정의한 클래스를 정렬할경우에는 사용자 지정 클래스가 Comparable인터페이스를 구현해야 정렬이 가능하다.
class Member implements Comparable<Member> {
	String name;
	
	public Member(String name) {
		this.name = name;
	}

	/* A.compareTo(B)에서 오름차순일 경우
	 * A가 B보다 낮을 경우 음수를 리턴 
	 * A가 B보다 높을 경우 양수를 리턴
	 * A와 B가 같을 경우 0을 리턴
	 */
	@Override
	public int compareTo(Member o) {
		return name.compareTo(o.name);
	}	
	
}
