package sec04.ex03_Map�÷���_Properties;

import java.io.FileReader;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;

/* (~.properties)������ key = value �� �����Ǿ� ������ ISO 8859-1���ڼ����� ����ȴ�.
 * ���� ǥ���� �� ���� �ѱ��� �����ڵ�(Unicode)�� �ڵ���ȯ�ȴ�. */
public class PropertiesFile {
	public static void main(String[] args) throws Exception {
		// Properties�� Hashtable�� ����Ŭ�����̱� ������ Hashtable�� ��� Ư¡�� ������ �ִ�.
		/* getResource()�޼ҵ�� �Ű������� �־��� ������ ��� ��θ� URL��ü�� �����ϰ�,
		 * URL�� getPath()�޼ҵ�� ������ ���� ��θ� String��ü�� �����Ѵ�. 
		 * ���� �ٸ� ��Ű���� �ִٸ� ������(/)�� ����Ѵ�. */
		URL url = PropertiesFile.class.getResource("data/Properties.properties");
		String path = url.getPath();	// String path = PropertiesFile.class.getResource("data/Properties.properties").getPath();
		path = URLDecoder.decode(path,"UTF-8");	// ��ο� �ѱ��� ���� ��� �ѱ��� �����Ѵ�.
		System.out.println(path);
		/* .properties ������ �б� ���ؼ��� Properties��ü�� �����ϰ� load()�޼ҵ带 ȣ���� �� �Ű������� FileReader��ü�� �޾ƾ� �Ѵ�. */
		Properties properties = new Properties();
		properties.load(new FileReader(path));
		
		System.out.println("����: " + properties.getProperty("contry"));
		System.out.println("���: " + properties.getProperty("language"));
	}
}
