package sec13.ex01_Math;

public class MathClass {
	public static void main(String[] args) {
		int v1 = -5;
		int v2 = 5;
		double v3 = 3.14;
		double v4 = -3.14;
		
		// 절대값
		int absInt = Math.abs(v1);
		double absDouble = Math.abs(v4);
		System.out.println(absInt);
		System.out.println(absDouble);
		
		// 올림값
		double ceilVal1 = Math.ceil(v3);
		double ceilVal2 = Math.ceil(v4);
		System.out.println(ceilVal1);
		System.out.println(ceilVal2);	 //-3.14를 올림하면 -3.0이된다.
		
		// 버림값
		double floorVal1 = Math.floor(v3);
		double floorVal2 = Math.floor(v4);
		System.out.println(floorVal1);
		System.out.println(floorVal2);
		
		// 최대값
		int maxVal1 = Math.max(v1, v2);
		double maxVal2 = Math.max(v3, v4);
		System.out.println(maxVal1);
		System.out.println(maxVal2);
		
		// 최소값
		int minVal1 = Math.min(v1, v2);
		double minVal2 = Math.min(v3, v4);
		System.out.println(minVal1);
		System.out.println(minVal2);
		
		// 랜덤값 ( 0.0에서 1.0 사이의 값을 리턴 )
		double randVal = Math.random();
		System.out.println(randVal);
		int rand45 = (int)(Math.random()*45) +1;	// 1~45사이의 랜덤한 숫자를 출력
		System.out.println("random45: " + rand45);		
		
		// 가까운 정수의 실수값
		double rintVal1 = Math.rint(v3);
		double rintVal2 = Math.rint(v4);
		System.out.println(rintVal1);
		System.out.println(rintVal2);
		
		// 반올림값
		double roundVal1 = Math.round(v3);
		double roundVal2 = Math.round(v4);
		System.out.println(roundVal1);
		System.out.println(roundVal2);
		
		
	}
}
