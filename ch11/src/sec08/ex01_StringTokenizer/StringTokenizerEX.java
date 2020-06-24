package sec08.ex01_StringTokenizer;

import java.util.StringTokenizer;

public class StringTokenizerEX {
	public static void main(String[] args) {
		// ���ڿ��� � �ϳ��� �����ڷ� �и������� ��� ���
		String str = "ȫ�浿/ȫ�ϵ�/ȫ�̵�";
		StringTokenizer st = new StringTokenizer(str,"/");
		int countTokens = st.countTokens();
		for(int i=0; i<countTokens; i++) {
			String token = st.nextToken();
			System.out.println(token);			
		}
		
		System.out.println();
		
		str = "ȫ�浿 ȫ�ϵ� ȫ�̵�";
		st = new StringTokenizer(str);		// �Ű������� �����ڸ� �����ϸ� �⺻�����ڸ� �������� �����Ѵ�.
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}
}
