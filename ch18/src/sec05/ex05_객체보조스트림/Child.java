package sec05.ex05_객체보조스트림;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Child extends Parent implements Serializable {
	/* 명령 프롬프트에서 ch18의 bin 디렉토리로 이동해서 "serialver sec05.ex05_객체보조스트림.Child"라고 
	 * 입력하면 자동으로 serialVersionUID를 생성해준다. 이렇게 생성한 값을 사용하면 된다. */
	private static final long serialVersionUID = 8425352537894767393L;

	private String name;
	private int age;

	public Child(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	/* 직렬화하지 않은 부모 클래스의 필드 처리를 위해 writeObject(), readObject()메소드를 작성한다.
	 * 직렬화시 자동으로 writeObject()메소드가 호출되고 
	 * 역직렬화시 자동으로 readObject()메소드가 호출된다. */
	private void writeObject(ObjectOutputStream out) throws Exception	 {
		out.writeUTF(super.parentName);
		out.defaultWriteObject();		// 자식클래스에 정의된 필드들을 모두 직렬화한다.
	}
	
	private void readObject(ObjectInputStream in) throws Exception	 {
		super.parentName = in.readUTF();
		in.defaultReadObject();			// 자식클래스에 정의된 필드들을 모두 역직렬화한다.
	}
	
}
