package sec05.ex01.익명자식객체;

public class AnonymousChild {
	// 필드 초기값으로 대입
	Parent field = new Parent() {
		void work() {
			System.out.println("출근합니다.");
		}

		@Override
		void wake() {
			System.out.print("6시에 일어나서 ");
			work();
		}
	};
	
	//로컬 변수값으로 대입
	void method1() {
		Parent localVar = new Parent() {
			void walk() {
				System.out.println("산책합니다.");
			}

			@Override
			void wake() {
				System.out.print("1시에 ");
				walk();
			}
		};
		localVar.wake();
	}
	
	void method2(Parent parent) {
		parent.wake();
	}
}
