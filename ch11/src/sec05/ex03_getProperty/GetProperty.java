package sec05.ex03_getProperty;

import java.util.Properties;
import java.util.Set;

public class GetProperty {
	public static void main(String[] args) {
		// �ý��� �Ӽ� �б�
		String osName = System.getProperty("os.name");
		String userHome = System.getProperty("user.home");
		String userName = System.getProperty("user.name");
		String userDir = System.getProperty("user.dir");
		String fileSeparator = System.getProperty("file.separator");
		String javaVersion = System.getProperty("java.version");
		String javaHome = System.getProperty("java.home");
		
		System.out.println("�ü�� : " + osName);
		System.out.println("Ȩ ���丮 : " + userHome);
		System.out.println("����� ���� : " + userName);
		System.out.println("���� �۾����� ���丮 : " + userDir);
		System.out.println("���丮 ������ : " + fileSeparator);
		System.out.println("�ڹ� ���� : " + javaVersion);
		System.out.println("�ڹ� JRE ��� : " + javaHome);
		
		System.out.println("======================================");
		System.out.println("[ key ] value : ��� System Property");
		System.out.println("--------------------------------------");
		Properties props = System.getProperties();
		Set keys = props.keySet();	//keySet() �޼ҵ带 �̿��ؼ� key������ ������ Set��ü�� ��´�.
		for(Object objKey : keys) {
			String key = (String) objKey;
			String value = System.getProperty(key);
			System.out.println("[" + key + "] " + value);
		}
	
	}
}
