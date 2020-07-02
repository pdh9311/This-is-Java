package sec06.ex02_FIFO_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEX {
	public static void main(String[] args) {
		// Queue는 컬렉션 프레임워크에서 FIFO자료구조를 제공하는 인터페이스이다.(ex. 스레드풀의 작업큐)
		// LinkedList는 List인터페이스를 구현하기도 했지만 Queue인터페이스를 구현한 클래스이기도하다.
		Queue<String> queue = new LinkedList<String>();
		// offer()메소드를 이용해서 주어진 객체를 Queue에 넣는다.
		queue.offer("1번");
		queue.offer("2번");
		queue.offer("3번");
		
		for(int i=0; i<queue.size(); i++) {
			System.out.print(queue.peek() + " ");		// peek()메소드를 이용해서 객체 하나를 가져오지만, 제거하지는 않는다.
		}
		
		System.out.println();
		
		while(!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");		// poll()메소드를 이용해서 객체 하나를 가져오고, Queue에서 제거한다.
		}
		
	}
}
