package sec05.ex01.�͸��ڽİ�ü;

public class AnonymousChild {
	// �ʵ� �ʱⰪ���� ����
	Parent field = new Parent() {
		void work() {
			System.out.println("����մϴ�.");
		}

		@Override
		void wake() {
			System.out.print("6�ÿ� �Ͼ�� ");
			work();
		}
	};
	
	//���� ���������� ����
	void method1() {
		Parent localVar = new Parent() {
			void walk() {
				System.out.println("��å�մϴ�.");
			}

			@Override
			void wake() {
				System.out.print("1�ÿ� ");
				walk();
			}
		};
		localVar.wake();
	}
	
	void method2(Parent parent) {
		parent.wake();
	}
}
