package sec06.ex02_mainStringArrayArgument;

public class MainStringArrayArgument {
	public static void main(String[] args) {
		String str1 = args[0];
		String str2 = args[1];
		
		int val1 = Integer.parseInt(str1);
		int val2 = Integer.parseInt(str2);
		
		int result = val1 + val2 ;
		System.out.println(val1 + "+" + val2 + "=" + result);
	}
}
/* 
	Run �� Run Configurations
	[Main]�ǿ��� [Project]�� [Main Class]�� Ȯ��
	[Arguments]�ǿ��� [Program arguments]�Է¶��� "10 20"�� �Է��Ѵ�.
	[Run]��ư�� Ŭ��
	
	���������Ʈ���� java MainStringArrayArgument 10 20���� �Է��� �Ͱ� ����. 
*/