package sec02.ex02_List�÷���_Vector;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class VectorCollection {
	public static void main(String[] args) {
		// Vector�� ����ȭ�� �޼ҵ�� �����Ǿ� �ֱ� ������ �����尡 ����(Thread Safe)�ϴ�.
		List<Book> list = new Vector<Book>();
		list.add(new Book("�̰��� �ڹٴ�","�ſ��",1224));
		list.add(new Book("�ڹ� ���� �ٷ�� ���","�̺���",1280));
		list.add(new Book("���� ���� JSP �� ���α׷���","�۹̿�",636));
		list.add(new Book("�ڵ�� ���� ������ �� ������Ʈ","���۰��� �ڵ���",760));
		list.add(new Book("�̰��� MySQL�̴�","���糲",576));
		
		list.remove(2);
		list.remove(2);
		
		for(int i=0; i<list.size(); i++) {
			Book book = list.get(i);
			System.out.println(book.name + "(" + book.writer + ", " + book.page + "������)");
		}

		System.out.print("List�� ���ðڽ��ϱ�? yes or no ");
		while(true) {
			Scanner scan = new Scanner(System.in);
			String yesNo = scan.next();
			if(yesNo.equals("yes")) {
				if(list.isEmpty()) {
					System.out.println("�̹� ��� �ֽ��ϴ�.");
				} else {
					list.clear();
					System.out.println("������ϴ�.");
				}
				break;
			} else if(yesNo.equals("no")){
				break;
			}
			System.out.println("yes �Ǵ� no�� �Է��ϼ���");
		}
		
		if(!list.isEmpty()) {
			for(int i=0; i<list.size(); i++) {
				Book book = list.get(i);
				System.out.println(book.name + "(" + book.writer + ", " + book.page + "������)");
			}
		}
	}
}
class Book {
	String name;
	String writer;
	int page;

	public Book(String name, String writer, int page) {
		this.name = name;
		this.writer = writer;
		this.page = page;
	}
}
