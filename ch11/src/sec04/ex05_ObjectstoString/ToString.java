package sec04.ex05_ObjectstoString;

import java.util.Objects;

public class ToString {
	public static void main(String[] args) {
		String str = "홍길동";
		
		System.out.println(Objects.toString(str));
		System.out.println(Objects.toString(null));
		System.out.println(Objects.toString(null,"null이 들어있습니다."));
		
	}
}
