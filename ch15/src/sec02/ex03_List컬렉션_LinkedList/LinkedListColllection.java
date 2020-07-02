package sec02.ex03_List컬렉션_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListColllection {
	public static void main(String[] args) {
		/* 끝에서부터(순차적으로) 추가/삭제하는 겨우는 ArrayList가 빠르지만,
		 * 중간에서 추가/삭제할 경우는 앞뒤 링크 정보만 변경하면 되는 LinkedList가 더 빠르다. */
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		for(int i=0; i<1000;i++) {
			list1.add(0,String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println(" ArrayList 걸린시간: " + (endTime-startTime));
		
		
		startTime = System.nanoTime();
		for(int i=0; i<1000;i++) {
			list2.add(0,String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList 걸린시간: " + (endTime-startTime)); 
		
		
		
		
	}
}
