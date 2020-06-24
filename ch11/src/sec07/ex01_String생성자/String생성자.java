package sec07.ex01_String������;

import java.io.IOException;

public class String������ {
	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[100];
		System.out.print("�Է�: ");
		/* System.in.read()�� Ű����� �Է��� ����(ĳ��������"\r",�����ǵ�"\n" ����)�� 
		 * �Ű������� �־��� byte�迭�� �����ϰ�
		 * ���� ����Ʈ���� �����Ѵ�. */
		int readByte = System.in.read(bytes);	
		
		// byte�迭�� ���ڿ��� ������ش�. 
		String str = new String(bytes);
		System.out.println(str);
		
		// byte�迭�� ������ ���ڼ����� ���ڿ��� ������ش�.
		str = new String(bytes,"UTF-8");
		System.out.println(str);
		
		// byte�迭�� 0��° �ε��� ��ġ���� ���� ����Ʈ��(ĳ�������ϰ� �����ǵ� ����)��ŭ ���ڿ��� ����� �ش�.
		str = new String(bytes,0,readByte-2);
		System.out.println(str);
		
		// byte�迭�� 0��° �ε��� ��ġ���� ���� ����Ʈ��(ĳ�������ϰ� �����ǵ� ����)��ŭ ������ ���ڼ����� ���ڿ��� ����� �ش�.
		str = new String(bytes,0,readByte-2,"UTF-8");
		System.out.println(str);
		
	}
}
