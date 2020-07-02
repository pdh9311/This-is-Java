package sec06.ex02_FIFO_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEX {
	public static void main(String[] args) {
		// Queue�� �÷��� �����ӿ�ũ���� FIFO�ڷᱸ���� �����ϴ� �������̽��̴�.(ex. ������Ǯ�� �۾�ť)
		// LinkedList�� List�������̽��� �����ϱ⵵ ������ Queue�������̽��� ������ Ŭ�����̱⵵�ϴ�.
		Queue<String> queue = new LinkedList<String>();
		// offer()�޼ҵ带 �̿��ؼ� �־��� ��ü�� Queue�� �ִ´�.
		queue.offer("1��");
		queue.offer("2��");
		queue.offer("3��");
		
		for(int i=0; i<queue.size(); i++) {
			System.out.print(queue.peek() + " ");		// peek()�޼ҵ带 �̿��ؼ� ��ü �ϳ��� ����������, ���������� �ʴ´�.
		}
		
		System.out.println();
		
		while(!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");		// poll()�޼ҵ带 �̿��ؼ� ��ü �ϳ��� ��������, Queue���� �����Ѵ�.
		}
		
	}
}
