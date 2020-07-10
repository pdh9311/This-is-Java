package sec06.ex04_arrayCopy;

public class ArrayCopy {
	public static void main(String[] args) {
		// 배열복사
		int[] arr1 = new int[] { 1,2,3};
		int[] arr2 = new int[5];
		
		String[] arr3 = new String[] {"java","jsp","spring" };
		String[] arr4 = new String[5];
		
		// 방법1 for문 복사
		for(int i=0;i<arr1.length;i++) {
			arr2[i] = arr1[i];
		}
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i] + "|");
		}
		System.out.println();
		
		// 방법2 System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
		System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i] + "|");
		}
		System.out.println();
		
		System.arraycopy(arr3, 0, arr4, 0, arr3.length);
		for(int i=0;i<arr4.length;i++) {
			System.out.print(arr4[i] + "|");
		}
	}
}
