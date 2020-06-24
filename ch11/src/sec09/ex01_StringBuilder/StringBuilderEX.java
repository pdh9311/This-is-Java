package sec09.ex01_StringBuilder;

public class StringBuilderEX {
	public static void main(String[] args) {
		/* String�� ���ڿ��� ������ �� ����!!! 
		 * ���ڿ����� +������ �Ͽ� ���� ���ڿ��� �����ϰ� ������ 
		 * ���� ���ڿ��� �����Ǵ°��� �ƴ϶� +������ ���ο� ���ڿ��� ��������� ���� ������� ���ڿ��� �����ϰ� �ȴ�. 
		 * ���� ���ڸ� �����ϴ� +�����ڸ� ���� ����� ��� �� ��ŭ String��ü�� �þ�� ���α׷� ������ ���Ͻ�Ű�� �ȴ�.
		 * ������ StringBuffer�� StringBuilder�� ���� ����(����Ƽ�� �ӽ÷� �����ϴ� �޸�)�� ���ڿ��� ������ �ΰ�, �� �ȿ��� �߰�,����,���� �۾��� �� �� �ֵ��� �Ǿ� �ִ�. 
		 * StringBuffer: ��Ƽ������ȯ�濡�� ���  | StringBuilder: ���� ������ȯ�濡���� ��� */
		StringBuilder sb = new StringBuilder();		// StringBuilder()�� �Ű������� ���ڿ��� �ִ´ٸ� �Ű����� �ʱ���۰����� �����Ѵ�.
		sb.append("Java ");
		sb.append("Program ");
		sb.append("Study");
		System.out.println(sb.toString());
		
		sb.insert(4, "2");		// �ε��� 4��ġ�� 2�� ����
		System.out.println(sb.toString());
		
		sb.setCharAt(4, '6');	// �ε��� 4��ġ�� 6���� ����
		System.out.println(sb.toString());
		
		sb.replace(6, 13, "Book");	// �ε��� 6��ġ���� 13�������� Book���� ��ü
		System.out.println(sb.toString());
		
		sb.delete(4, 5);	// �ε��� 4��ġ���� 5�������� ����
		System.out.println(sb.toString());
		
		int length = sb.length();		// ���ۿ� �ִ� ������ ���� ����
		System.out.println("�� ���ڼ�: " + length);
		
		String result = sb.toString();		// ���ۿ� �ִ� ���� StringŸ������ ����
		System.out.println(result);
	}
}
