package sec03.ex01_콘솔입출력;

import java.io.Console;

public class ConsoleEX {
	public static void main(String[] args) {
		/* System.console()메소드는 이클립스에서 실행시 null을 리턴하기 때문에 
		 * 명령 프롬프트에서 실행해야 합니다. */
		Console console = System.console();
		
		System.out.print("아이디 입력> ");
		String id = console.readLine();
		
		System.out.print("비밀번호 입력> ");
		char[] pw = console.readPassword();
		
		System.out.println("아이디: " + id );
		System.out.print("비밀번호: ");
		for(int i=0; i<pw.length; i++) {
			System.out.print(pw[i]);
		}
	}
}
