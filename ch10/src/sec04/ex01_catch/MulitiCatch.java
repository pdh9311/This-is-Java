package sec04.ex01_catch;

public class MulitiCatch {
	public static void main(String[] args) {
		try {
			String data1 = args[0];
			String data2 = args[1];
			int value1 = Integer.parseInt(data1);
			double value2 = Double.parseDouble(data2);
			double result = value1 + value2;
			System.out.println(data1 + " + " + data2 + " = " + result);
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("���� �Ű����� ���� �����ϰų� ���ڷ� ��ȯ�� �� �����ϴ�.");
		} catch (Exception e) {
			System.out.println("�� �� ���� ���� �߻�");
		} finally {
			System.out.println("�ٽ� �����ϼ���.");
		}
	}
}
