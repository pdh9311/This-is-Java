package sec05.ex03_getProperty;

import java.util.Properties;
import java.util.Set;

public class GetProperty {
	public static void main(String[] args) {
		// 시스템 속성 읽기
		String osName = System.getProperty("os.name");
		String userHome = System.getProperty("user.home");
		String userName = System.getProperty("user.name");
		String userDir = System.getProperty("user.dir");
		String fileSeparator = System.getProperty("file.separator");
		String javaVersion = System.getProperty("java.version");
		String javaHome = System.getProperty("java.home");
		
		System.out.println("운영체제 : " + osName);
		System.out.println("홈 디렉토리 : " + userHome);
		System.out.println("사용자 계정 : " + userName);
		System.out.println("현재 작업중인 디렉토리 : " + userDir);
		System.out.println("디렉토리 구분자 : " + fileSeparator);
		System.out.println("자바 버전 : " + javaVersion);
		System.out.println("자바 JRE 경로 : " + javaHome);
		
		System.out.println("======================================");
		System.out.println("[ key ] value : 모든 System Property");
		System.out.println("--------------------------------------");
		Properties props = System.getProperties();
		Set keys = props.keySet();	//keySet() 메소드를 이용해서 key만으로 구성된 Set객체를 얻는다.
		for(Object objKey : keys) {
			String key = (String) objKey;
			String value = System.getProperty(key);
			System.out.println("[" + key + "] " + value);
		}
	
	}
}
