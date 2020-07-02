package sec02.ex02_List컬렉션_Vector;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class VectorCollection {
	public static void main(String[] args) {
		// Vector는 동기화된 메소드로 구성되어 있기 때문에 스레드가 안전(Thread Safe)하다.
		List<Book> list = new Vector<Book>();
		list.add(new Book("이것이 자바다","신용권",1224));
		list.add(new Book("자바 웹을 다루는 기술","이병승",1280));
		list.add(new Book("쉽게 배우는 JSP 웹 프로그래밍","송미영",636));
		list.add(new Book("코드로 배우는 스프링 웹 프로젝트","구멍가게 코딩단",760));
		list.add(new Book("이것이 MySQL이다","우재남",576));
		
		list.remove(2);
		list.remove(2);
		
		for(int i=0; i<list.size(); i++) {
			Book book = list.get(i);
			System.out.println(book.name + "(" + book.writer + ", " + book.page + "페이지)");
		}

		System.out.print("List를 비우시겠습니까? yes or no ");
		while(true) {
			Scanner scan = new Scanner(System.in);
			String yesNo = scan.next();
			if(yesNo.equals("yes")) {
				if(list.isEmpty()) {
					System.out.println("이미 비어 있습니다.");
				} else {
					list.clear();
					System.out.println("비웠습니다.");
				}
				break;
			} else if(yesNo.equals("no")){
				break;
			}
			System.out.println("yes 또는 no만 입력하세요");
		}
		
		if(!list.isEmpty()) {
			for(int i=0; i<list.size(); i++) {
				Book book = list.get(i);
				System.out.println(book.name + "(" + book.writer + ", " + book.page + "페이지)");
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
