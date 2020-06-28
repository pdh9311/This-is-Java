package sec06.ex02_스레드상태제어_join;

public class JoinMethod {
	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		threadA.start();
		/* threadA.join()메소드를 이용하면 threadA가 종료될때 까지 main스레드가 일시정지상태가 되고 threadA가 종료되면 main스레드가 실행된다. 
		 * threadA.join()메소드를 이용하지 않았다면 threadA가 실행되는 동안 main스레드도 같이 실행되기때문에 계산을 완료하기 전의 값이 출력될 수 있다. */
		try { threadA.join(); } catch (InterruptedException e) {}	
		System.out.println("합: " + threadA.sum);
	}
}
