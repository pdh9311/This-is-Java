package sec04.ex01_File;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URI;

public class FileClass {
	public static void main(String[] args) throws Exception {
		/* mkdir()메소드는 새로운 디렉토리를 생성하지만 mkdirs()메소드는 경로상에 없는 모든 디렉토리를 생성한다.
		 * exists()메소드는 디렉토리 또는 파일이 존재하는지 확인할 수 있다.
		 * delete()메소드는 디렉토리 또는 파일을 삭제할 수 있다. 단, 디렉토리를 삭제할 경우 디렉토리안에 파일이나 디렉토리가 존재하지 않아야 한다.*/
		File directory = new File("C:/dir1");
		if(!directory.exists()) { directory.mkdir(); }
		
		File directories = new File("C:/dir1/dir2/dir3/dir4");
		if(!directories.exists()) { directories.mkdirs(); }
		
		File file1 = new File("C:/dir1/file1.txt");
		if(!file1.exists()) { file1.createNewFile(); }
		
		File file2 = new File(new URI("file:///C:/dir1/file2.txt"));	// 파일 경로를 URI객체로 생성해서 매개값으로 제공해도 됨.
		if(!file2.exists()) { file2.createNewFile(); }
		
		File deleteDir = new File("C:/dir1/dir2/dir3");				
		if(deleteDir.exists()) { deleteDir.delete(); }					// dir3디렉토리안에 dir4디렉토리가 있기 때문에 삭제하지 못한다.
		
		// 어떤 디렉토리안의 모든 디렉토리와 파일을 출력하기위해서 재귀함수를 이용해야하므로 메소드로 작성하였음.
		exploreDir("C:/ProgramData");	
	}
	
	public static void exploreDir(String directory) {
		File dir = new File(directory);
		File[] files = dir.listFiles();
		try {
			for(File file : files) {
				if(file.isDirectory()) {
					System.out.println(file.getName());
					exploreDir(file.getPath());		// 재귀 호출
				}else if(file.isFile()) {
					System.out.println(" -" + file.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				Writer os = new FileWriter("D:\\SW PDH\\This is Java\\ch18\\src\\sec04\\ex01_File\\error.txt");
				String errorStr	= e.toString();
				os.write(errorStr);
				os.flush();
				os.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
	}
}