package sec11_ex01_Stream최종처리_수집;

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

import sec11_ex01_Stream최종처리_수집.Student.Sex;

public class Collect {
	public static void main(String[] args) {
		/* collect()메소드는 필요한 요소만 필터링,매핑한 후 새로운 컬렉션에 담을 수 있고, 요소들을 그룹핑한 후 집계할 수 있다.
		 * collect()메소드의 매개값으로는 Collector<T,A,R>인터페이스를 구현한 객체가 들어오며 
		 * Collectors의 정적메소드들이 Collector<T,A,R>타입으로 리턴한다. */
		
		List<Student> list = Arrays.asList(
				new Student("븝미짱",28,Student.Sex.Female,Student.City.Pusan),
				new Student("만식짱",30,Student.Sex.Male,Student.City.Seoul),
				new Student("토끼짱",25,Student.Sex.Female,Student.City.Seoul),
				new Student("초밥짱",29,Student.Sex.Male,Student.City.Pusan) );
		
		// collect()의 매개값으로 Collectors.toList() - 자세한 코드
		Stream<Student> stream1 = list.stream();
		Stream<Student> maleStream = stream1.filter(s -> s.getSex() == Student.Sex.Male);
		Collector<Student, ?, List<Student>> collector1 = Collectors.toList();
		List<Student> maleList = maleStream.collect(collector1); 
		maleList.stream().forEach(s -> System.out.println(s.getName()));
		
		System.out.println();
		
		// collect()의 매개값으로 Collectors.toList() - 간단한 코드 
		List<Student> femaleList = list.stream().filter(s -> s.getSex() == Student.Sex.Female).collect(Collectors.toList());
		femaleList.stream().forEach(s -> System.out.println(s.getName()));
		
		System.out.println();
		
		// collect()의 매개값으로 Collectors.toCollection(Supplier) - 자세한 코드
		Stream<Student> stream2 = list.stream();
		Stream<Student> femaleSeoulStream = stream2.filter(s -> s.getSex() == Student.Sex.Female && s.getCity() == Student.City.Seoul);
		Supplier<HashSet<Student>> supplier = () -> new HashSet<Student>();
		Collector<Student, ?, HashSet<Student>> collector2 = Collectors.toCollection(supplier);
		Set<Student> set = femaleSeoulStream.collect(collector2);
		set.stream().forEach(s -> System.out.println(s.getName()));
		
		System.out.println();
		
		// collect()의 매개값으로 Collectors.toCollection(Supplier) - 간단한 코드
		ArrayList<Student> seoul28over = list.stream().filter(s -> s.getAge() >= 28 && s.getCity() == Student.City.Seoul ).collect(Collectors.toCollection(() -> new ArrayList<Student>()));
		seoul28over.stream().forEach(s -> System.out.println(s.getName()));
		
		System.out.println();
		
		// collect()의 매개값으로 Collectors.toMap(Function,Fuction) - 간단한 코드
		Map<Integer,String> map = list.stream().collect(Collectors.toMap(Student :: getAge, Student :: getName));
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			Map.Entry<Integer, String> entry = iterator.next();
			System.out.println(entry.getKey() + "살, 이름: " + entry.getValue());
		}
		
		System.out.println();
		
		// collect()의 매개값으로 Collectors.toConcurrentMap(Function,Function) - 간단한 코드
		ConcurrentMap<String, Sex> concurrentMap = list.parallelStream().collect(Collectors.toConcurrentMap(Student :: getName, Student :: getSex));
		Set<String> keySet = concurrentMap.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			System.out.println(key + " : " + concurrentMap.get(key));
		}
	}
}
