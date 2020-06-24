package sec07.ex02_String�޼ҵ�;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class String�޼ҵ� {
	public static void main(String[] args) {
		charValue();		// ���� ���� charAt()
		equalsValue();		// ���ڿ� �� equals()
		bytesEncoding();	// ����Ʈ �迭�� ��ȯ getBytes()
		searchString();		// ���Ե� ���ڿ��� ���۵Ǵ� �ε����� ��ġ indexOf() 
		lengthStr();		// ���ڿ� ���� length()
		replaceStr();		// ���ڿ� ��ü replace()
		subString();		// ���ڿ� ���� substring()
		alphabet();			// ���ĺ� �롤�ҹ��� toUpperCase() , toLowerCase()
		trimStr();			// ���ڿ� �յ� ���� ���� trim()
		valueOfStr();		// �⺻Ÿ���� ���� ���ڿ��� ��ȯ String.valueOf()
		splitStr();			// �����ڸ� �������� ���ڿ��� �и� split()
	}
	
	public static void charValue() {
		Scanner scan = new Scanner(System.in);
		System.out.print("�ֹε�� ��ȣ �Է�(-����): " );
		String str = scan.nextLine();
		System.out.println("�Է��� ��: "+ str);
		
		// ���� ����
		char charValue = str.charAt(7);
		System.out.println("�Է��� ���� 8��° ����: " + charValue);
	}
	public static void equalsValue() {
		// ���ڿ� ��
		// equals()�޼Ҵ� ���� Object�� ������ ���ϴ� �޼ҵ����� StringŬ������ �������Ͽ� ���ڿ��� ���ϵ��� ��������.
		String str1 = new String("ȫ�浿");
		String str2 = new String("ȫ�浿");
		String str3 = "ȫ�浿";
		String str4 = "ȫ�浿";
		System.out.println(str1 == str2);		// ��ü�� ���� ������ ���ϹǷ� false
		System.out.println(str1.equals(str2));	// ���ڿ��� ���ϹǷ� true
		System.out.println(str1 == str3);		// ��ü�� ���� ������ ���ϹǷ� false
		System.out.println(str1.equals(str3));	// ���ڿ��� ���ϹǷ� true
		System.out.println(str3 == str4);		// ��ü�� ���� ������ ���ϹǷ� true , new �����ڸ� �̿����� �ʾҴٸ� ���� ���ڿ��� ��� ���� ��ü�� �����Ѵ�.
		System.out.println(str3.equals(str4));	// ���ڿ��� ���ϹǷ� true
	}
	public static void bytesEncoding() {
		// ����Ʈ �迭�� ��ȯ
		String str = "�ȳ��ϼ���";
		byte[] bytes1 = str.getBytes();			//���ڿ� �� ����Ʈ(���ڵ�)
		for(int i=0; i<bytes1.length; i++) {	
			System.out.print(bytes1[i] + " ");		
		}
		str = new String(bytes1);				//����Ʈ �� ���ڿ�(���ڵ�)
		System.out.println("\n" + str);		
		
		try {
			byte[] bytes2 = str.getBytes("UTF-8");	//���ڿ� �� ����Ʈ(���ڵ�)
			for(int i=0; i<bytes2.length; i++) {
				System.out.print(bytes2 + " ");		
			}
			str = new String(bytes2,"UTF-8");		//����Ʈ �� ���ڿ�(���ڵ�)
			System.out.println("\n" + str);
			str = new String(bytes2,"EUK-KR");		// ���ڵ��� ���ڵ��������� ���� ���ڼ����� ���ڵ����־���Ѵ�. 
			System.out.println(str);				// ��� �ȵ�
		} catch (UnsupportedEncodingException e) {}		
	}
	public static void searchString() {
		String str = "indexOf() �޼ҵ�� �Ű������� �־��� ���ڿ��� ���۵Ǵ� �ε����� �����Ѵ�. ���� �Ǿ� ���� ������ -1�� ����";
		String searchStr = "�ڹ�";
		int index = str.indexOf(searchStr);	 
		if( index != -1) { 
			System.out.println(searchStr +" ���ڿ��� ���۵Ǵ� �ε����� ��ġ��: " + index);
		} else {
			System.out.println(searchStr + " ���ڿ��� ���ԵǾ� ���� �ʽ��ϴ�.");
		}
	}
	public static void lengthStr() {
		String str = "�迭 ���̰� �ƴ� ���ڿ� ���̸� �˾ƺ���";
		int lenStr = str.length();
		System.out.println("���ڿ� ����: " + lenStr);
	}
	public static void replaceStr() {
		// replace() �޼ҵ�� ù ��° �Ű����� ���ڿ��� ã�� �� ��° �Ű������� ��ġ�� ���ο� ���ڿ��� �����.
		String str ="�ڹ� ���α׷��� ����";
		String newStr = str.replace("�ڹ�", "JAVA");
		System.out.println(newStr);
	}
	public static void subString() {
		String str = "930311-1234567";
		String firstToSecond = str.substring(2,6); // ù��° �ε������� �ι�° �ε��������� ���ڿ��� �����.
		System.out.println(firstToSecond);
		String firstToEnd = str.substring(7);
		System.out.println(firstToEnd);
	}
	public static void alphabet() {
		// ����ε� ���ڿ��� ��ҹ��ڿ� ������� ���� �� �ַ� ����.
		String str = "Java Programming";
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
	}
	public static void trimStr() {
		// trim()�� ���ڿ� �߰��� ������ �������� �ʴ´�.
		String str = "     ���ڿ�  �յ�   ����    ����     ";
		String newStr = str.trim();
		System.out.println(newStr);
		
	}
	public static void valueOfStr() {
		// �⺻Ÿ���� ���� ���ڿ��� ��ȯ
		boolean b1 = true;
		boolean b2 = false;
		char c = '��';
		int i = 12345;
		long l = 12445L;
		double d = 123.123;
		float f = 123.44f;
		String str = String.valueOf(b1);
		System.out.println(str);
		str =String.valueOf(b2);
		System.out.println(str);
		str =String.valueOf(c);
		System.out.println(str);
		str =String.valueOf(i);
		System.out.println(str);
		str =String.valueOf(l);
		System.out.println(str);
		str =String.valueOf(d);
		System.out.println(str);
		str =String.valueOf(f);
		System.out.println(str);
		
	}
	public static void splitStr() {
		// split()�� ����ǥ������ �����ڷ� �ؼ� ���ڿ��� �и��� �� �迭�� �����ϰ� �����Ѵ�.
		String str = "ȫ�浿&ȫ�ϵ�,ȫ�̵�,ȫ�ﵿ-ȫ�絿";
		String[] arrStr = str.split("&|,|-");
		for(String strE : arrStr) {
			System.out.print(strE + " ");
		}
	}
}
