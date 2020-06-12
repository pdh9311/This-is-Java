package sec06.ex03_arrayInArray;

public class ArrayInArray {
	public static void main(String[] args) {
		int[][] intArr1 = new int[2][3];
		for(int i=0;i<intArr1.length;i++) {
			for(int j=0;j<intArr1[i].length;j++) {
				System.out.println("intArr1["+i+"]["+j+"] = " + intArr1[i][j]);
			}
		}
		System.out.println();
		int[][] intArr2 = new int[2][];
		intArr2[0] = new int[2];
		intArr2[1] = new int[3];
		for(int i=0;i<intArr2.length;i++) {
			for(int j=0;j<intArr2[i].length;j++) {
				System.out.println("intArr2["+i+"]["+j+"] = " + intArr2[i][j]);
			}
		}
		System.out.println();
		int[][] intArr3 = { {95,80},
							{92,96,80} };
		for(int i=0;i<intArr3.length;i++) {
			for(int j=0;j<intArr3[i].length;j++) {
				System.out.println("intArr3["+i+"]["+j+"] = " + intArr3[i][j]);
			}
		}
	}
}
