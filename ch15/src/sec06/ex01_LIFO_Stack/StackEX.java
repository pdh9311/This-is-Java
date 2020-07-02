package sec06.ex01_LIFO_Stack;

import java.util.Stack;

public class StackEX {
	public static void main(String[] args) {
		// Stack�� �÷��� �����ӿ�ũ���� LIFO�ڷᱸ���� �����ϴ� Ŭ�����̴�.(ex. JVM�� ���ø޸�)
		Stack<String> stack = new Stack<String>();
		// push()�޼ҵ带 �̿��ؼ� �־��� ��ü�� Stack�� �ִ´�.
		stack.push("1��");
		stack.push("2��");
		stack.push("3��");
		
		
		for(int i=0; i<stack.size();i++) {
			System.out.print(stack.peek() + " ");	// peek()�޼ҵ�� Stack�� �� �� ��ü�� ���������� Stack���� �������� �ʴ´�.
		}
		
		System.out.println();
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");	// pop()�޼ҵ�� Stack�� ���� ��ü�� �������� Stack���� �����Ѵ�.
		}
		
	}
}
