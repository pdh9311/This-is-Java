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
	Run → Run Configurations
	[Main]탭에서 [Project]와 [Main Class]를 확인
	[Arguments]탭에서 [Program arguments]입력란에 "10 20"을 입력한다.
	[Run]버튼을 클릭
	
	명령프롬프트에서 java MainStringArrayArgument 10 20으로 입력한 것과 같다. 
*/