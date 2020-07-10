package sec03.ex01_콘솔입출력;

import java.util.Scanner;

public class ScannerEX {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);		
		/* Scanner의 nextLine()메소드를 제외하고는 입력값으로 들어온 Enter나 공백을 기준으로 값을 가져오지만 
		 * nextLine()은 Enter값도 가져올 수 있기 때문에 
		 * nextLine()메소드를 제외한 nextXXX()메소드가 실행되면 Enter값이 Scnaner 버퍼에 남아 있을 수 있으므로 버퍼를 비워주는 작업이 필요하다. */
		System.out.print("String값 입력> ");
		String str1 = scan.nextLine();
		System.out.println(str1);
		scan.nextLine();
		System.out.print("Boolean값 입력> ");
		boolean bool = scan.nextBoolean();
		System.out.println(bool);
		
		System.out.print("byte값 입력> ");
		byte byteVal = scan.nextByte();
		System.out.println(byteVal);
		
		System.out.print("short값 입력> ");
		short shortVal = scan.nextShort();
		System.out.println(shortVal);
		
		System.out.print("int값 입력> ");
		int intVal = scan.nextInt();
		System.out.println(intVal);
		
		System.out.print("long값 입력> ");
		long longVal = scan.nextLong();
		System.out.println(longVal);
		
		System.out.print("float값 입력> ");
		float floatVal = scan.nextFloat();
		System.out.println(floatVal);
		
		System.out.print("double값 입력> ");
		double doubleVal = scan.nextDouble();
		System.out.println(doubleVal);
		
		scan.nextLine();	// Scanner 버퍼에 있는 Enter를 비운다. 
		
		System.out.print("String값 입력> ");
		String str2 = scan.nextLine();
		System.out.println(str2);
		
		scan.close();
		
		
	}
}
