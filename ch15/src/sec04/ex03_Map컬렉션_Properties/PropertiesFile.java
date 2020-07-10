package sec04.ex03_Map컬렉션_Properties;

import java.io.FileReader;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;

/* (~.properties)파일은 key = value 로 구성되어 있으며 ISO 8859-1문자셋으로 저장된다.
 * 직접 표현할 수 없는 한글은 유니코드(Unicode)로 자동변환된다. */
public class PropertiesFile {
	public static void main(String[] args) throws Exception {
		// Properties는 Hashtable의 하위클래스이기 때문에 Hashtable의 모든 특징을 가지고 있다.
		/* getResource()메소드는 매개값으로 주어진 파일의 상대 경로를 URL객체로 리턴하고,
		 * URL의 getPath()메소드는 파일의 절대 경로를 String객체로 리턴한다. 
		 * 만약 다른 패키지에 있다면 구분자(/)를 사용한다. */
		URL url = PropertiesFile.class.getResource("data/Properties.properties");
		String path = url.getPath();	// String path = PropertiesFile.class.getResource("data/Properties.properties").getPath();
		path = URLDecoder.decode(path,"UTF-8");	// 경로에 한글이 있을 경우 한글을 복원한다.
		System.out.println(path);
		/* .properties 파일을 읽기 위해서는 Properties객체를 생성하고 load()메소드를 호출할 때 매개값으로 FileReader객체를 받아야 한다. */
		Properties properties = new Properties();
		properties.load(new FileReader(path));
		
		System.out.println("국적: " + properties.getProperty("contry"));
		System.out.println("언어: " + properties.getProperty("language"));
	}
}
