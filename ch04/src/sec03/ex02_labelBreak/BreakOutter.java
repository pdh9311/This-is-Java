package sec03.ex02_labelBreak;

public class BreakOutter {
	public static void main(String[] args) {
		System.out.println("g�� ���̸� ���α׷��� ���� �˴ϴ�.");
		Outter: for(char upper='A' ; upper <= 'Z' ; upper++) {
			for(char lower='a';lower<='z';lower++) {
				System.out.println(upper + "-" + lower);
				if(lower == 'g') {
					break Outter;
				}
			}
		}
		System.out.println("���α׷� ����");
	}
}
