package sec02.ex03_List�÷���_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListColllection {
	public static void main(String[] args) {
		/* ����������(����������) �߰�/�����ϴ� �ܿ�� ArrayList�� ��������,
		 * �߰����� �߰�/������ ���� �յ� ��ũ ������ �����ϸ� �Ǵ� LinkedList�� �� ������. */
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		for(int i=0; i<1000;i++) {
			list1.add(0,String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println(" ArrayList �ɸ��ð�: " + (endTime-startTime));
		
		
		startTime = System.nanoTime();
		for(int i=0; i<1000;i++) {
			list2.add(0,String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList �ɸ��ð�: " + (endTime-startTime)); 
		
		
		
		
	}
}
