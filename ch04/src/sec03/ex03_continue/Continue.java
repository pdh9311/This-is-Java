package sec03.ex03_continue;

public class Continue {
	public static void main(String[] args) {
		System.out.println("1~100 사이 숫자중 3의 배수는 제외하고 출력하시요");
		for(int i=1 ; i<=100 ; i++) {
			if(i%3 == 0) {
				continue;
			}
			System.out.print(i + "|");
			if(i==50) {
				System.out.println();
			}
		}
		
		System.out.println("\n1~3 사이의 3의 배수만 출력하시요.");
		int i = 1;
		while(i<=100) {
			if(i%3 == 0) {
				System.out.print(i + "|");
			}
			i++;
		}
	}
}
