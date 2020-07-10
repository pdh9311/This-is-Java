package sec05.ex05_객체보조스트림;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStream_직렬화 {
	public static void main(String[] args) throws Exception {
		/* 직렬화 : 객체의 데이터를 일렬로 늘어선 연속적인 바이트로 변경하는 작업
		 * 역직렬화 : 일렬로 늘어선 연속적인 바이트를 객체로 복원하는 작업
		 * 객체를 저장할 경우 Serializable 인터페이스를 구현한 클래스만 직렬화 할 수 있도록 제한된다. (단, static이나 transient 키워드가 붙은 필드는 직렬화에서 제외) 
		 * 여러개의 객체를 저장할 경우, 출력된 객체 순서와 동일한 순서로 읽어야 한다. */
		Child s1 = new Child("홍길동",99);
		s1.parentName = "홍씨가문장";
		
		OutputStream os = new FileOutputStream("D:\\SW PDH\\This is Java\\ch18\\src\\sec05\\ex05_객체보조스트림\\ObjectSave.dat");
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		oos.writeObject(s1);
		oos.writeObject(new int[] {1,2,3,4});
		oos.writeObject(new Integer(10));
		oos.writeObject(new Double(12.3));
		oos.writeObject(new String("구마적"));
		oos.flush();
		oos.close();
		
	}
}
