package sec04.ex01_람다식_클래스멤버;

public class Outter {
	public int outterField = 10;
	public int field = 40;
	
	class Inner {
		public int innerField = 20;
		public String field = "30오";
		
		/* 메소드 내에서 생성된 익명 객체는 메소드가 끝나도 힙 메모리에 존재하여 계속 사용할 수 있지만 
		 * 메소드의 매개변수나 로컬변수는 메소드가 끝나면 메모리에서 사라지기 때문에
		 * 메소드 내의 익명객체에서 사용되는 메소드의 매개변수나 로컬변수는 final특성을 가지므로
		 * 아래의 arg와 localVal 값을 변경할 수없다. */
		void method(int arg) {
			int localVal = 80;
			//arg = 25;	(x)
			//localVal = 34; (x)
			InnerClassInterface ici = () -> {
				/* 바깥 클래스와 내부 클래스의 필드 명이 같을때 필드명으로 호출하면 내부클래스의 필드가 호출된다.
				 * 바깥 클래스의 필드를 호출하기 위해서는 "바깥클래스.this.필드명"으로 호출해야한다. */
				System.out.println("outterField:" + outterField);
				System.out.println("field: " + Outter.this.field);
				System.out.println();
				System.out.println("innerField:" + innerField);
				System.out.println("field: " + this.field);
				System.out.println("field: " + field);
				System.out.println("-----------------------");
				System.out.println(arg + " + " + localVal + " = " + (arg+localVal));
			};
			ici.method();
		}
	}
	
	public static void main(String[] args) {
		Outter outter = new Outter();
		Inner inner = outter.new Inner();
		inner.method(2);
		
	}
}
