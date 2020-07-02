package sec06.ex01_LIFO_Stack;

import java.util.Stack;

public class StackEX {
	public static void main(String[] args) {
		// Stack은 컬렉션 프레임워크에서 LIFO자료구조를 제공하는 클래스이다.(ex. JVM의 스택메모리)
		Stack<String> stack = new Stack<String>();
		// push()메소드를 이용해서 주어진 객체를 Stack에 넣는다.
		stack.push("1번");
		stack.push("2번");
		stack.push("3번");
		
		
		for(int i=0; i<stack.size();i++) {
			System.out.print(stack.peek() + " ");	// peek()메소드는 Stack의 맨 위 객체를 가져오지만 Stack에서 제거하진 않는다.
		}
		
		System.out.println();
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");	// pop()메소드는 Stack의 맨위 객체를 가져오며 Stack에서 제거한다.
		}
		
	}
}
