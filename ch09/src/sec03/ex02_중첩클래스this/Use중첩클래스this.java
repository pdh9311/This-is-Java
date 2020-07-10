package sec03.ex02_중첩클래스this;

public class Use중첩클래스this {
	public static void main(String[] args) {
		OutterClass oc = new OutterClass();
		OutterClass.LocalClass lc = oc.new LocalClass();
		lc.print();
		
	}
}
