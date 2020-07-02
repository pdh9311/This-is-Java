package sec02.ex01_List�÷���_ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListCollection {
	public static void main(String[] args) {
		/* �Ϲݹ迭�� �����Ҷ� ũ�Ⱑ �����ǰ� ��� �߿� ũ�⸦ ������ �� ����.
		 * ������ List �������̽��� ������ Ŭ������ ����뷮�� �ʰ��Ͽ� ��ü�� ���� ��� �ڵ������� ����뷮�� �þ��.
		 * ����, �ʱ�뷮�� 10������ �������� �Ű������� ���� �־ �ʱ�뷮�� ������ �� �ִ�. */
		String[] strArr = new String[10];	// �Ϲݹ迭
		List<String> list = new ArrayList<String>();	// List�������̽��� ������ ArrayList(�ʱ�뷮:10)
		list = new ArrayList<String>(7);	// �������� �Ű������� �ʱ�뷮�� ����(�ʱ�뷮:7)
		
		// �ǳ��� ��ü�� �߰�
		list.add("day");
		list.add("MON");	
		list.add("THU");
		list.add("FRI");
		list.add("SAT");
		// �־��� �ε����� ��ü�� ����
		list.add(1,"TUE"); 
		list.add(2,"WEN");
		// �־��� �ε����� ����� ��ü�� �־��� ��ü�� �ٲ�
		list.set(0,"SUN");
		
		// contains()�޼ҵ��� �Ű������� �־��� ��ü�� ����Ǿ� �ִ��� �� �� �ִ�.
		if(list.contains("day")) {
			System.out.println("day�� ���ԵǾ��ֽ��ϴ�.");
		} else {
			System.out.println("day�� ���ԵǾ����� �ʽ��ϴ�.");
		}
		
		// size()�޼ҵ�� List�� ����� ��ü�� ���� �� �� �ִ�.
		for(int i=0;i<list.size();i++) {
			System.out.print("  " + i + "  |");
		}
		
		System.out.println();
		
		// isEmpty()�޼ҵ�� List�� ����� ��ü�� ������ Ȯ�� �� �� �ִ�.
		if(!list.isEmpty()) {
			for(int i=0; i<list.size(); i++) {
				System.out.print(" " + list.get(i) + " |");		// 
			}
		}
		
		System.out.println();

		list.remove(3);			// �ε����� ��ü ����
		list.remove(3);			// �ε����� ��ü ����
		list.remove("MON");		// �־��� ��ü�� ����
		
		for(String str : list) {
			System.out.print(" " + str + " |");
		}
		
		list.clear();		// clear()�޼ҵ�� List�� ����� ��� ��ü�� ���� �Ѵ�. 
		if(list.isEmpty()) { System.out.println("\n����� ��ü�� �����ϴ�."); }
		
		// ������ ��ü��� ������ List�� ������ �� Arrays.asList();
		list = Arrays.asList("HTML","Java","JSP/Servlet");
		for(String str : list) {
			System.out.print(" " + str + " |");
		}
	}
}
