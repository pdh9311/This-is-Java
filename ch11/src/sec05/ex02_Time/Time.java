package sec05.ex02_Time;

public class Time {
	public static void main(String[] args) {
		// ��ǻ���� �ð�� ���� ���� �ð� �б�
		long milliTime1 = System.currentTimeMillis();
		long nanoTime1 = System.nanoTime();
		
		System.out.println(milliTime1 + " �и�������");
		System.out.println(nanoTime1 + " ���뼼����");
		long sum = 0;
		for(long i=0;i<1000000;i++) {
			sum+=i;
		}
		
		long milliTime2 = System.currentTimeMillis();
		long nanoTime2 = System.nanoTime();
		System.out.println(milliTime2 + " �и�������");
		System.out.println(nanoTime2 + " ���뼼����");
		
		System.out.println("1���� 1�鸸������ �� : " + sum);
		System.out.println("1���� 1�鸸���� ���ϴµ� �ɸ� �ð� : " + (milliTime2-milliTime1) + " �и�������");
		System.out.println("1���� 1�鸸���� ���ϴµ� �ɸ� �ð� : " + (nanoTime2-nanoTime1) + " ���뼼����");
		
	}
}
