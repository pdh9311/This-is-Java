package sec04.ex04_ObjectsisNull;

import java.util.Objects;

public class IsNull {
	public static void main(String[] args) {
		System.out.println(Objects.isNull(null));	//null�� �´��� �Ǵ�
		System.out.println(Objects.nonNull(null));	//null�� �ƴ��� �Ǵ�
		
		String str = "ȫ�浿";
		System.out.println(Objects.requireNonNull(str));	//null���� �ƴϸ� ���� ������.
		
		try {
			Objects.requireNonNull(null);		// null���� ���� NullPointerException���ܸ� �߻���Ŵ
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Objects.requireNonNull(null, "null���� ����ֽ��ϴ�.");	// null���� ���� NullPointerException���ܸ� �߻���Ŵ
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Supplier ���� ��ü�� ���ٽ��� ����
			Objects.requireNonNull(null, ()->"null�� ����־��~!");	// null���� ���� NullPointerException���ܸ� �߻���Ŵ			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
