package sec11.ex01_Arrayscopy;

import java.util.Arrays;

public class ArraysCopy {
	public static void main(String[] args) {
		char[] arr1 = {'J','A','V','A'};
		// 배열 복사 방법1
		char[] arr2 = Arrays.copyOf(arr1, arr1.length);
		System.out.println(Arrays.toString(arr2));

		// 배열 복사 방법2
		arr2 = Arrays.copyOfRange(arr1, 0, 3);
		System.out.println(Arrays.toString(arr2));

		// 배열 복사 방법3
		arr2 = new char[arr1.length];
		System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		System.out.println(Arrays.toString(arr2));
		
		for(int i=0;i<arr2.length;i++) {
			System.out.println("arr2["+i+"]=" + arr2[i]);
		}
		
		int[][] array1 = { {1,2}, {3,4} };
		// 얕은 배열 복사
		int[][] cloned1 = Arrays.copyOf(array1, array1.length);
		System.out.println("array1: " + array1);
		System.out.println("cloned1: " + cloned1);
		System.out.println(array1.equals(cloned1));
		
		System.out.println("array1[0], array1[1]: " + Arrays.toString(array1));	
		System.out.println("cloned1[0], cloned1[1] : " + Arrays.toString(cloned1));
		System.out.println(Arrays.equals(array1,cloned1));
		
		System.out.print(array1[0][0] + "" + array1[0][1] + "" + array1[1][0] + "" + array1[1][1]+"\n");
		System.out.print(cloned1[0][0] + "" + cloned1[0][1]+ "" + cloned1[1][0] + "" + cloned1[1][1]+"\n");
		System.out.println(Arrays.deepEquals(array1, cloned1)+"\n");
		
		// 깊은 배열 복사
		System.out.println("[깊은 배열 복사]");
		cloned1[0] = Arrays.copyOf(array1[0], array1[0].length);
		cloned1[1] = Arrays.copyOf(array1[1], array1[1].length);
		
		System.out.println("array1[0], array1[1]: " + Arrays.toString(array1));	
		System.out.println("cloned1[0], cloned1[1] : " + Arrays.toString(cloned1));
		System.out.println(Arrays.equals(array1,cloned1));
		
		System.out.print(array1[0][0] + "" + array1[0][1] + "" + array1[1][0] + "" + array1[1][1]+"\n");
		System.out.print(cloned1[0][0] + "" + cloned1[0][1]+ "" + cloned1[1][0] + "" + cloned1[1][1]+"\n");
		System.out.println(Arrays.deepEquals(array1, cloned1));
		
	}
}
