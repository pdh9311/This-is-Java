package sec07.ex01_사용자정의예외;

// extends Exception : 일반 예외
// extends RuntimeException : 실행 예외
public class BalanceInsufficientException extends Exception {
	
	// 기본 생성자
	public BalanceInsufficientException() { }
	
	// 예외 발생 원인(예외 메시지)을 전달하기 위해 String 타입의 매객 변수를 갖는 생성자
	public BalanceInsufficientException (String message) {
		super(message);
	}
	
}
