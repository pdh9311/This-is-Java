package sec11_ex01_Stream����ó��_����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import sec11_ex01_Stream����ó��_����.Student.Sex;

public class Collect {
	public static void main(String[] args) {
		/* collect()�޼ҵ�� �ʿ��� ��Ҹ� ���͸�,������ �� ���ο� �÷��ǿ� ���� �� �ְ�, ��ҵ��� �׷����� �� ������ �� �ִ�.
		 * collect()�޼ҵ��� �Ű������δ� Collector<T,A,R>�������̽��� ������ ��ü�� ������ 
		 * Collectors�� �����޼ҵ���� Collector<T,A,R>Ÿ������ �����Ѵ�. */
		
		List<Student> list = Arrays.asList(
				new Student("���¯",28,Student.Sex.Female,Student.City.Pusan),
				new Student("����¯",30,Student.Sex.Male,Student.City.Seoul),
				new Student("�䳢¯",25,Student.Sex.Female,Student.City.Seoul),
				new Student("�ʹ�¯",29,Student.Sex.Male,Student.City.Pusan) );
		
		// collect()�� �Ű������� Collectors.toList() - �ڼ��� �ڵ�
		Stream<Student> stream1 = list.stream();
		Stream<Student> maleStream = stream1.filter(s -> s.getSex() == Student.Sex.Male);
		Collector<Student, ?, List<Student>> collector1 = Collectors.toList();
		List<Student> maleList = maleStream.collect(collector1); 
		maleList.stream().forEach(s -> System.out.println(s.getName()));
		
		System.out.println();
		
		// collect()�� �Ű������� Collectors.toList() - ������ �ڵ� 
		List<Student> femaleList = list.stream().filter(s -> s.getSex() == Student.Sex.Female).collect(Collectors.toList());
		femaleList.stream().forEach(s -> System.out.println(s.getName()));
		
		System.out.println();
		
		// collect()�� �Ű������� Collectors.toCollection(Supplier) - �ڼ��� �ڵ�
		Stream<Student> stream2 = list.stream();
		Stream<Student> femaleSeoulStream = stream2.filter(s -> s.getSex() == Student.Sex.Female && s.getCity() == Student.City.Seoul);
		Supplier<HashSet<Student>> supplier = () -> new HashSet<Student>();
		Collector<Student, ?, HashSet<Student>> collector2 = Collectors.toCollection(supplier);
		Set<Student> set = femaleSeoulStream.collect(collector2);
		set.stream().forEach(s -> System.out.println(s.getName()));
		
		System.out.println();
		
		// collect()�� �Ű������� Collectors.toCollection(Supplier) - ������ �ڵ�
		ArrayList<Student> seoul28over = list.stream().filter(s -> s.getAge() >= 28 && s.getCity() == Student.City.Seoul ).collect(Collectors.toCollection(() -> new ArrayList<Student>()));
		seoul28over.stream().forEach(s -> System.out.println(s.getName()));
		
		System.out.println();
		
		// collect()�� �Ű������� Collectors.toMap(Function,Fuction) - ������ �ڵ�
		Map<Integer,String> map = list.stream().collect(Collectors.toMap(Student :: getAge, Student :: getName));
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			Map.Entry<Integer, String> entry = iterator.next();
			System.out.println(entry.getKey() + "��, �̸�: " + entry.getValue());
		}
		
		System.out.println();
		
		// collect()�� �Ű������� Collectors.toConcurrentMap(Function,Function) - ������ �ڵ�
		ConcurrentMap<String, Sex> concurrentMap = list.parallelStream().collect(Collectors.toConcurrentMap(Student :: getName, Student :: getSex));
		Set<String> keySet = concurrentMap.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			System.out.println(key + " : " + concurrentMap.get(key));
		}
	}
}
