package sec05.ex02_Time;

public class Time {
	public static void main(String[] args) {
		// 컴퓨터의 시계로 부터 현재 시간 읽기
		long milliTime1 = System.currentTimeMillis();
		long nanoTime1 = System.nanoTime();
		
		System.out.println(milliTime1 + " 밀리세컨드");
		System.out.println(nanoTime1 + " 나노세컨드");
		long sum = 0;
		for(long i=0;i<1000000;i++) {
			sum+=i;
		}
		
		long milliTime2 = System.currentTimeMillis();
		long nanoTime2 = System.nanoTime();
		System.out.println(milliTime2 + " 밀리세컨드");
		System.out.println(nanoTime2 + " 나노세컨드");
		
		System.out.println("1부터 1백만까지의 합 : " + sum);
		System.out.println("1부터 1백만까지 더하는데 걸린 시간 : " + (milliTime2-milliTime1) + " 밀리세컨드");
		System.out.println("1부터 1백만까지 더하는데 걸린 시간 : " + (nanoTime2-nanoTime1) + " 나노세컨드");
		
	}
}
