package sec03.ex01_checkValueBeforeCasting;

public class CheckValueBeforeCasting {
	public static void main(String[] args) {
		// ���� Ÿ�� ��ȯ Ȯ�� �۾�
		// byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
		System.out.println("�⺻Ÿ�� : �ּҰ� ~ �ִ밪");
		System.out.print("byte : ");
		System.out.println(Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
		System.out.print("short : ");
		System.out.println(Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
		System.out.print("int : ");
		System.out.println(Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
		System.out.print("long : ");
		System.out.println(Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
		System.out.print("float : ");
		System.out.println(Float.MIN_VALUE + " ~ " + Float.MAX_VALUE);
		System.out.print("dobule : ");
		System.out.println(Double.MIN_VALUE + " ~ " + Double.MAX_VALUE);
		System.out.println("------------------------------------------------------");
		// double�� float,long,int,short,byte�� ��ȯ
		// Math.pow(2,n) ~ Math.pow(2,n)-1
		double d = Math.pow(2,63)-1;
//		double d = Math.pow(2,31)-1;
//		double d = Math.pow(2,15)-1;
//		double d = Math.pow(2,7)-1;
		// double -> float
		if( d < Float.MIN_VALUE || d > Float.MAX_VALUE) {
			System.out.println("Float Ÿ������ ��ȯ �� �� �����ϴ�. ���� �ٽ� Ȯ�����ּ���.");
		} else {
			float f = (float) d;
			System.out.println("Float type : " + f);
		}
		// double ->  long
		if( d < Long.MIN_VALUE || d > Long.MAX_VALUE) {
			System.out.println("Long Ÿ������ ��ȯ �� �� �����ϴ�. ���� �ٽ� Ȯ�����ּ���.");
		} else {
			long l = (long) d;
			System.out.println("Long type : " + l);
		}
		// double -> int
		if( d < Integer.MIN_VALUE || d > Integer.MAX_VALUE) {
			System.out.println("Integer Ÿ������ ��ȯ �� ��  �����ϴ�. ���� �ٽ� Ȯ�����ּ���.");
		} else {
			int i = (int) d;
			System.out.println("Integer type : " + i);
		}
		// double -> short
		if( d < Short.MIN_VALUE || d > Short.MAX_VALUE) {
			System.out.println("Short Ÿ������ ��ȯ �� �� �����ϴ�. ���� �ٽ� Ȯ�����ּ���.");
		} else {
			short s = (short) d;
			System.out.println("Short type : " + s);
		}
		// double -> byte
		if( d < Byte.MIN_VALUE || d > Byte.MAX_VALUE) {
			System.out.println("Byte Ÿ������ ��ȯ �� �� �����ϴ�. ���� �ٽ� Ȯ�����ּ���.");
		} else {
			byte b = (byte) d;
			System.out.println("Byte type : " + b);
		}
	}
}
