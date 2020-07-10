package sec05.ex05_객체보조스트림;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class ObjectInputStream_역직렬화 {
	public static void main(String[] args) throws Exception {
		/* 직렬화 : 객체의 데이터를 일렬로 늘어선 연속적인 바이트로 변경하는 작업
		 * 역직렬화 : 일렬로 늘어선 연속적인 바이트를 객체로 복원하는 작업
		 * 객체를 저장할 경우 Serializable 인터페이스를 구현한 클래스만 직렬화 할 수 있도록 제한된다. (단, static이나 transient 키워드가 붙은 필드는 직렬화에서 제외) 
		 * 여러개의 객체를 저장할 경우, 출력된 객체 순서와 동일한 순서로 읽어야 한다. */
		InputStream is = new FileInputStream("D:\\SW PDH\\This is Java\\ch18\\src\\sec05\\ex05_객체보조스트림\\ObjectSave.dat");
		ObjectInputStream ois = new ObjectInputStream(is);
		
		Child objS1 = (Child) ois.readObject();
		System.out.println(objS1.getName() + " " + objS1.getAge() + " " + objS1.parentName);
		
		int[] intArray = (int[]) ois.readObject();
		for(int i : intArray) { System.out.print(i +" "); }

		Integer i = (Integer) ois.readObject();
		System.out.println("\n" + i);
		
		Double d = (Double) ois.readObject();
		System.out.println(d);
		
		String s = (String) ois.readObject();
		System.out.println(s);
		ois.close();
	}
}
