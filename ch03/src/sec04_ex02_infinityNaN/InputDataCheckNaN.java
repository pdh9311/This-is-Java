package sec04_ex02_infinityNaN;

import java.util.Scanner;

public class InputDataCheckNaN {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("NaN�� �Է��غ�����> ");
		String inputData = scan.next();	//�Է� ������ "NaN"
		double val = Double.valueOf(inputData);
		
		double currentBalance = 10000.0;
		
		if(!Double.isNaN(val)) {
			currentBalance += val;
		} else {
			System.out.println("NaN�� �ԷµǾ� ���� ó���� �� �����ϴ�.");
		}
		System.out.println(currentBalance);
		
	}
}
