package sec03.ex02_��øŬ����this;

public class Use��øŬ����this {
	public static void main(String[] args) {
		OutterClass oc = new OutterClass();
		OutterClass.LocalClass lc = oc.new LocalClass();
		lc.print();
		
	}
}
