package sec08.ex01_methodParameter;

public class MethodParameter {
	
	public static void main(String[] args) {
		int result = add(1,2,3,4,5,6,7,8,9,10);
		System.out.println(result);
		
	}
	
	/*	�޼ҵ��� �Ű������� "..."�� ����ؼ� �����ϸ�,
		�޼ҵ� ȣ�� �� �Ѱ��� ���� ���� ���� �ڵ����� �迭�� �����ǰ� �Ű������� ���ȴ�. */
	public static int add(int ... values) {
		int sum = 0;
		for(int i=0;i<values.length;i++) {
			sum += values[i];
		}
		return sum;
	}
	
}
