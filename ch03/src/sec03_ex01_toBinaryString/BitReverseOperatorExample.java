package sec03_ex01_toBinaryString;

public class BitReverseOperatorExample {
	public static void main(String[] args) {
		int v1 = 10;
		int v2 = ~v1;
		int v3 = ~v1 + 1;
		System.out.println(toBinaryString(v1) + " (������: "+ v1 + ")"); 
		System.out.println(toBinaryString(v2) + " (������: "+ v2 + ")"); 
		System.out.println(toBinaryString(v3) + " (������: "+ v3 + ")");
		System.out.println();
		
		int v4 = -10;
		int v5 = ~v4;
		int v6 = ~v4 + 1;
		System.out.println(toBinaryString(v1) + " (������: "+ v4 + ")"); 
		System.out.println(toBinaryString(v2) + " (������: "+ v5 + ")"); 
		System.out.println(toBinaryString(v3) + " (������: "+ v6 + ")");
	}
	// �������� �� 32��Ʈ�� ���� ���ڿ��� �����ϴ� Integer.toBinaryString() �޼ҵ�
	public static String toBinaryString(int value) {
		String str = Integer.toBinaryString(value);
		while(str.length() < 32) {
			str = "0" + str;
		}
		return str; 
	}
}
