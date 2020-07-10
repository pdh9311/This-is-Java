package sec05.ex04_getenv;

public class Getenv {
	public static void main(String[] args) {
		// 환경 변수 읽기
		String javaHome = System.getenv("JAVA_HOME");
		System.out.println("[JAVA_HOME] "+javaHome);
	}
}
