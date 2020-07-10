package sec05.ex01.익명자식객체;

public class UseAnonymousChild {
	public static void main(String[] args) {
		AnonymousChild anony = new AnonymousChild();
		
		// 익명 객체 필드 사용
		anony.field.wake();
		
		// 익명 객체 로컬 변수 사용
		anony.method1();
		
		// 익명 객체 매개값 사용
		anony.method2(
			// 익명 객체 매개값으로 대입
			new Parent() {
				void study() {
					System.out.println("공부합니다.");
				}
	
				@Override
				void wake() {
					System.out.print("3시에 ");
					study();
				}
			}
		);
	}
}
