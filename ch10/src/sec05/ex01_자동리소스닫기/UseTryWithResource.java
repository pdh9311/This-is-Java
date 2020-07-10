package sec05.ex01_자동리소스닫기;

public class UseTryWithResource {
	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("file.txt")){
			fis.read();
			throw new Exception();	// 강제 예외 발생
		} catch(Exception e) {
			System.out.println("예외 처리 코드가 실행되었습니다.");
		}
	}
}
/*	try-with-resources를 사용하기 위해서는 AutoCloseable 인터페이스를 구현하고 있어야 하고,
 * 	try블록이 정상적으로 실행을 완료했거나 도중에 예외가 발생하게 되면 자동으로 FileInputStream의 close() 메소드가 호출된다.
 * 	예외가 발생했다면 우선 close()로 리소스를 닫고 catch블록을 실행한다.	*/
