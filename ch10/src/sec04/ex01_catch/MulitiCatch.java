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
			System.out.println("실행 매개값의 수가 부족하거나 숫자로 변환할 수 없습니다.");
		} catch (Exception e) {
			System.out.println("알 수 없는 예외 발생");
		} finally {
			System.out.println("다시 실행하세요.");
		}
	}
}
