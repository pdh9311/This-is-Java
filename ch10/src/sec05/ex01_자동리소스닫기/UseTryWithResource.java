package sec05.ex01_�ڵ����ҽ��ݱ�;

public class UseTryWithResource {
	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("file.txt")){
			fis.read();
			throw new Exception();	// ���� ���� �߻�
		} catch(Exception e) {
			System.out.println("���� ó�� �ڵ尡 ����Ǿ����ϴ�.");
		}
	}
}
/*	try-with-resources�� ����ϱ� ���ؼ��� AutoCloseable �������̽��� �����ϰ� �־�� �ϰ�,
 * 	try����� ���������� ������ �Ϸ��߰ų� ���߿� ���ܰ� �߻��ϰ� �Ǹ� �ڵ����� FileInputStream�� close() �޼ҵ尡 ȣ��ȴ�.
 * 	���ܰ� �߻��ߴٸ� �켱 close()�� ���ҽ��� �ݰ� catch����� �����Ѵ�.	*/
