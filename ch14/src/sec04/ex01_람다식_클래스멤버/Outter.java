package sec04.ex01_���ٽ�_Ŭ�������;

public class Outter {
	public int outterField = 10;
	public int field = 40;
	
	class Inner {
		public int innerField = 20;
		public String field = "30��";
		
		/* �޼ҵ� ������ ������ �͸� ��ü�� �޼ҵ尡 ������ �� �޸𸮿� �����Ͽ� ��� ����� �� ������ 
		 * �޼ҵ��� �Ű������� ���ú����� �޼ҵ尡 ������ �޸𸮿��� ������� ������
		 * �޼ҵ� ���� �͸�ü���� ���Ǵ� �޼ҵ��� �Ű������� ���ú����� finalƯ���� �����Ƿ�
		 * �Ʒ��� arg�� localVal ���� ������ ������. */
		void method(int arg) {
			int localVal = 80;
			//arg = 25;	(x)
			//localVal = 34; (x)
			InnerClassInterface ici = () -> {
				/* �ٱ� Ŭ������ ���� Ŭ������ �ʵ� ���� ������ �ʵ������ ȣ���ϸ� ����Ŭ������ �ʵ尡 ȣ��ȴ�.
				 * �ٱ� Ŭ������ �ʵ带 ȣ���ϱ� ���ؼ��� "�ٱ�Ŭ����.this.�ʵ��"���� ȣ���ؾ��Ѵ�. */
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
