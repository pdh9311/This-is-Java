package sec06.ex01_arrayCreateByValueList;

public class ArrayCreateByValueList {
	public static void main(String[] args) {
		int sum = add(new int[] { 83, 90, 87 } );
		System.out.println("รัวี : " + sum);
	}
	
	public static int add(int[] scores) {
		int sum = 0;
		for(int i=0;i<3;i++) {
			sum += scores[i];
		}
		return sum;
	}
}
