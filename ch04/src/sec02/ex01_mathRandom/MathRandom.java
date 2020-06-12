package sec02.ex01_mathRandom;

public class MathRandom {
	public static void main(String[] args) {
		// 0.0 <= Math.random() < 1.0
		int random = (int) (Math.random()*6)+1;
		if(random == 1) {
			System.out.println("1 입니다.");
		} else if (random == 2) {
			System.out.println("2 입니다.");
		} else if (random == 3) {
			System.out.println("3 입니다.");
		} else if (random == 4) {
			System.out.println("4 입니다.");
		} else if (random == 5) {
			System.out.println("5 입니다.");
		} else {
			System.out.println("6 입니다.");
		}
		
	}
}
