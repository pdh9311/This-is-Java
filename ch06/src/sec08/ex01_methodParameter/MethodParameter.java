package sec08.ex01_methodParameter;

public class MethodParameter {
	
	public static void main(String[] args) {
		int result = add(1,2,3,4,5,6,7,8,9,10);
		System.out.println(result);
		
	}
	
	/*	메소드의 매개변수에 "..."을 사용해서 선언하면,
		메소드 호출 시 넘겨준 값의 수에 따라 자동으로 배열이 생성되고 매개값으로 사용된다. */
	public static int add(int ... values) {
		int sum = 0;
		for(int i=0;i<values.length;i++) {
			sum += values[i];
		}
		return sum;
	}
	
}
