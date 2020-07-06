package sec11_ex02_Stream����ó��_��������������̳ʿ�����;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import sec11_ex01_Stream����ó��_����.Student;

public class ContainedObj {
	public static void main(String[] args) {
		// List, Set, Map�� ���� �÷����� �ƴ϶� ����� �����̳� ��ü�� ����
		List<Student> list = Arrays.asList(
				new Student("���¯",28,Student.Sex.Female,Student.City.Pusan),
				new Student("����¯",30,Student.Sex.Male,Student.City.Seoul),
				new Student("�䳢¯",25,Student.Sex.Female,Student.City.Seoul),
				new Student("�ʹ�¯",29,Student.Sex.Male,Student.City.Pusan) );
		
		// collect()�޼ҵ��� �Ű������� Supplier,BiConsumer, BiConsumer - �ڼ��� �ڵ�
		Stream<Student> stream1 = list.stream();
		Stream<Student> maleStream = stream1.filter(s -> s.getSex() == Student.Sex.Male);
		Supplier<Container> supplier = Container :: new;						// ù��° Supplier�� ��ҵ��� ������ �����̳� ��ü�� �����ϴ� ������ �Ѵ�.
		BiConsumer<Container, Student> accumulator = (c,s) -> c.accumulate(s);	// Container�� accumulate()�޼ҵ�� Student�� �����ϴ� BiConsuemer�� ��´�. 
		BiConsumer<Container, Container> combiner = (c1,c2) -> c1.combine(c2);	// ����ó����Ʈ���� ����Ҷ� �ٸ� Contianer�� ������ �������� ��������� ����ó���� �Ű������� �־��ֱ����� BiConsuemr�� ������ �ʿ䰡 �ִ�. 
		Container container1 = maleStream.collect(supplier, accumulator, combiner);
		
		List<Student> maleList = container1.getList();
		maleList.stream().forEach(s -> System.out.print("[1]" + s.getName() + " "));
		
		System.out.println("\n");	try {Thread.sleep(1000);} catch(Exception e) {}
		
		// collect()�޼ҵ��� �Ű������� Supplier,BiConsumer, BiConsumer - ������ �ڵ�
		/* �����ھ�CPU���� ����Ǳ⶧���� 4���� �����ҷ� ��������, 4���� �����尡 ����ó���Ѵ�.
		 * �� ������� �����Ҹ� �����ؾ��ϹǷ� 4���� Container��ü�� �����ϱ� ���� collect()�޼ҵ��� ù��° �Ű����� Container�� �����ڸ� 4�� �����Ѵ�.
		 * �׸��� ������ �� �ִ� ��ŭ accumulate()�޼ҵ带 �����ϰԵǰ�
		 * �����Ҹ� �����ϱ� ���� combine()�޼ҵ尡 3�� �����ϰ� �ȴ�. */
		Container container2 = list.parallelStream()
		.filter(s-> s.getCity() == Student.City.Seoul)
		.collect(
			() -> new Container(),		
			(r,t) -> r.accumulate(t),
			(r1,r2) -> r1.combine(r2)
		);
		List<Student> seoulList = container2.getList();
		seoulList.stream().forEach(s -> System.out.print("[2]" + s.getName() + " "));
		
		System.out.println("\n");	try {Thread.sleep(1000);} catch(Exception e) {}
		
		// collect()�޼ҵ��� �Ű������� Supplier,BiConsumer, BiConsumer - ������ �ڵ�(����)
		/* parallel()�޼ҵ�� ���� ó�� ��Ʈ���� ���� ó�� ��Ʈ������ ��ȯ���ش�. */
		Container container3 = list.stream().parallel().filter(s->s.getAge() > 26).collect(Container :: new , Container :: accumulate, Container :: combine);
		List<Student> twoeightList = container3.getList();
		twoeightList.stream().forEach(s -> System.out.print("[3]" + s.getName() + " "));
	}
}
