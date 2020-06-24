package sec13.ex01_Math;

import java.util.Random;

public class RandomClass {
	public static void main(String[] args) {
		Random random = new Random();
		
		int irandVal = random.nextInt(45) + 1;		// 0 <= ~ 45
		System.out.println(irandVal);
		
		double dRandVal = random.nextDouble();		// 0.0<= ~ <1.0
		System.out.println(dRandVal);				
		
		boolean bRandVal = random.nextBoolean();	// true , false
		System.out.println(bRandVal);
	}
}
