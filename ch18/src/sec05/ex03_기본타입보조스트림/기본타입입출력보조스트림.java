package sec05.ex03_기본타입보조스트림;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class 기본타입입출력보조스트림 {
	public static void main(String[] args) throws Exception {
		/* 주의할 점! 
		 * DataOutputStream으로 출력한 순서대로 DataInputStream으로 읽어야한다. */
		OutputStream os = new FileOutputStream("D:\\SW PDH\\This is Java\\ch18\\src\\sec05\\ex03_기본타입보조스트림\\기본타입데이터.dat");
		DataOutputStream dos = new DataOutputStream(os);
		
		dos.writeBoolean(true);
		dos.writeByte(10);
		dos.writeChar(97);
		dos.writeDouble(3.11);
		dos.writeFloat(14.4f);
		dos.writeInt(410);
		dos.writeLong(1231231231231L);
		dos.writeShort(123);
		dos.writeUTF("ggg");
		dos.flush(); dos.close(); os.close();
		
		InputStream is = new FileInputStream("D:\\SW PDH\\This is Java\\ch18\\src\\sec05\\ex03_기본타입보조스트림\\기본타입데이터.dat");
		DataInputStream dis = new DataInputStream(is);
		
		System.out.println(dis.readBoolean());
		System.out.println(dis.readByte());
		System.out.println(dis.readChar());
		System.out.println(dis.readDouble());
		System.out.println(dis.readFloat());
		System.out.println(dis.readInt());
		System.out.println(dis.readLong());
		System.out.println(dis.readShort());
		System.out.println(dis.readUTF());
		dis.close(); 	is.close();
		
	}
}
