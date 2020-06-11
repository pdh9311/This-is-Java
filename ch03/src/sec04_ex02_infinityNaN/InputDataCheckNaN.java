package sec04_ex02_infinityNaN;

import java.util.Scanner;

public class InputDataCheckNaN {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("NaN을 입력해보세요> ");
		String inputData = scan.next();	//입력 데이터 "NaN"
		double val = Double.valueOf(inputData);
		
		double currentBalance = 10000.0;
		
		if(!Double.isNaN(val)) {
			currentBalance += val;
		} else {
			System.out.println("NaN이 입력되어 값을 처리할 수 없습니다.");
		}
		System.out.println(currentBalance);
		
	}
}
