package sec02.ex01_BaseStreamInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Stream���� {
	public static int sum1;
	public static int sum2;
	
	public static void main(String[] args) throws Exception {
		List<Object> list = Arrays.asList("ȫ�浿","��浿","���ֵ�","��ĥ��","�ű���");
		Object[] strArr = new Object[10];
		// �÷������κ��� Stream ���
		Stream<Object> stream1 = list.stream();
		Stream<Object> stream2 = list.parallelStream();
		
		//�迭�κ��� Stream ���
		Stream<Object> stream3 = Arrays.stream(new Object[] {"1����","2����","3����","4����","5����"});
		IntStream stream4 = Arrays.stream(new int[] {1,2,3,4,5});
		LongStream stream5 = Arrays.stream(new long[] {1231231231231L,1231233453453L,1123123123123L,12318012387112L});
		DoubleStream stream6 = Arrays.stream(new double[] {123.13,123.92,123.45,8743.2} );
		
		// ���� �����κ��� Stream ���
		/* rangeClosed()�޼ҵ�� ù ��° �Ű������� ���� �� ��° �Ű������� ���������� IntStream �Ǵ� LongStream�� ����������
		 * range()�޼ҵ�� �ι�° �Ű����� �������� �ʴ´�. */
		IntStream stream7 = IntStream.range(1, 100);
		stream7.forEach(a -> sum1 += a);
		System.out.println(sum1);

		IntStream stream8 = IntStream.rangeClosed(1, 100);
		stream8.forEach(a -> sum2 += a);
		System.out.println(sum2);
		
		LongStream stream9 = LongStream.range(1, 1000);
		LongStream stream10 = LongStream.rangeClosed(1, 1000);
		
		// ���Ϸκ��� Stream ���
		Path path1 = Paths.get("src\\sec01\\ex01_Stream�ݺ���\\IteratorStream.java");
		Stream<String> stream11 = Files.lines(path1,Charset.defaultCharset());
		stream11.forEach(System.out :: println);	// s -> System.out.println(s)
		
		File file = path1.toFile();
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		Stream<String> stream12 = br.lines();
		stream12.forEach(System.out :: println);
		
		// ���丮�κ��� Stream ���
		Path path2 = Paths.get("D:\\SW PDH\\This is Java");
		Stream<Path> stream13 = Files.list(path2);
		stream13.forEach( p -> System.out.println(p.getFileName()));
		
	} 
}
