package sec11_ex03_Stream����ó��_�׷���;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import sec11_ex01_Stream����ó��_����.Student;

public class Grouping {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("���¯",28,Student.Sex.Female,Student.City.Pusan),
				new Student("����¯",30,Student.Sex.Male,Student.City.Seoul),
				new Student("�䳢¯",25,Student.Sex.Female,Student.City.Seoul),
				new Student("�ʹ�¯",29,Student.Sex.Male,Student.City.Pusan) );
		
		/** groupingBy(Function<T,K> classifier)�޼ҵ� 
		 * 	�� Collector<T,?,Map<K,List<T>>>����: T�� K�� �����ϰ� KŰ�� ����� List�� T�� ������ Map ����  - �ڼ��� �ڵ�*/
		Stream<Student> stream1 = list.stream();
		Function<Student,Student.Sex> classifier1 = s -> s.getSex();
		Collector<Student,?,Map<Student.Sex,List<Student>>> collector = Collectors.groupingBy(classifier1);
		Map<Student.Sex,List<Student>> map1 = stream1.collect(collector);
		
		map1.get(Student.Sex.Male).stream().forEach(e -> System.out.print(e.getName() + " "));	
		
		System.out.println("\n");
		
		/** groupingBy(Function<T,K> classifier)�޼ҵ� 
		 * 	�� Collector<T,?,Map<K,List<T>>>����: T�� K�� �����ϰ� KŰ�� ����� List�� T�� ������ Map ����  - ������ �ڵ�*/
		Map<Student.City,List<Student>> map2 = list.stream().collect(Collectors.groupingBy(Student :: getCity));
		
		map2.get(Student.City.Seoul).stream().forEach(e -> System.out.print(e.getName() + " "));
		
		System.out.println("\n");
		
		/** groupingBy(Function<T,K> classifier, Collector<T,A,D> collector)�޼ҵ�
		 * 	�� Collector<T,?,Map<K,D>>����: T�� K�� �����ϰ� KŰ�� ����� D��ü�� T�� ������ Map ���� - �ڼ��� �ڵ� */ 
		Stream<Student> stream2 = list.stream();
		Function<Student,Student.City> classifier2 = Student :: getCity;	// Function<T,K>
			/** mapping(Function<T,U> mapper, Collector<U,A,R> collector)
			 * 	�� Collector<T,?,R>����: T�� ������ ��, U�� R�� ���� */
		Function<Student,String> mapper1 = Student :: getName;	/// Function<T,U>
		Collector<String,?,List<String>> collector1 = Collectors.toList();	/// Collector<U,A,R>
		Collector<Student,?,List<String>> collector2 = Collectors.mapping(mapper1, collector1); 	/// Collector<T,?,R>
		
		Collector<Student,?,Map<Student.City,List<String>>> collector3 = Collectors.groupingBy(classifier2,collector2);		// Collector<T,?,Map<K,D>>
		Map<Student.City, List<String>> map3 = stream2.collect(collector3);
		
		map3.get(Student.City.Pusan).stream().forEach(e -> System.out.print(e + " "));
		
		System.out.println("\n");
		
		/** groupingBy(Function<T,K> classifier, Collector<T,A,D> collector)�޼ҵ� 
		 * 	�� Collector<T,?,Map<K,D>>����: T�� K�� �����ϰ� KŰ�� ����� D��ü�� T�� ������ Map ���� - ������ �ڵ� */ 
		Map<Student.Sex,List<Integer>> map4 = list.stream()
			.collect(
					Collectors.groupingBy(
						Student :: getSex,
						Collectors.mapping(Student :: getAge, Collectors.toList())
					)
			);
		
		map4.get(Student.Sex.Female).stream().forEach(e -> System.out.print(e + " "));
		
		System.out.println("\n");
		
		/** groupingBy(Function<T,K> classifier, Supplier<Map<K,D>> mapFactory, Collector<T,A,D> collector)�޼ҵ� 
		 * 	�� Collector<T,?,Map<K,D>>����: T�� K�� �����ϰ� Supplier�� �����ϴ� Map���� KŰ�� ����� D��ü�� T�� ���� - �ڼ��� �ڵ�  */
		Stream<Student> stream3 = list.stream();
		Function<Student,Student.City> classifier3 = Student :: getCity;		//Function<T,K>
		Supplier<Map<Student.City,List<String>>> supplier = HashMap :: new;		// Supplier<Map<K,D>>
		
		Function<Student,String> mapper2 = Student :: getName;	/// Function<T,U>
		Collector<String,?,List<String>> collector4 = Collectors.toList();	/// Collector<U,A,R>
		Collector<Student,?,List<String>> collector5 = Collectors.mapping(mapper2,collector4);	/// Collector<T,?,R>
		
		Collector<Student,?,Map<Student.City,List<String>>> collector6 = Collectors.groupingBy(classifier3,supplier,collector5);		// Collector<T,?,Map<K,D>>
		Map<Student.City,List<String>> map5 = stream3.collect(collector6);
		
		map5.get(Student.City.Pusan).stream().forEach(e -> System.out.print(e + " "));
		
		System.out.println("\n");

		/** groupingBy(Function<T,K> classifier, Supplier<Map<K,D>> mapFactory, Collector<T,A,D> collector)�޼ҵ� 
		 * 	�� Collector<T,?,Map<K,D>>����: T�� K�� �����ϰ� Supplier�� �����ϴ� Map���� KŰ�� ����� D��ü�� T�� ���� - ������ �ڵ� */
		Map<Student.City,List<String>> map6 = list.stream()
				.collect(
						Collectors.groupingBy(
								Student :: getCity,
								TreeMap :: new,
								Collectors.mapping(Student :: getName, Collectors.toList())
						)
						
				);
		
		map6.get(Student.City.Seoul).stream().forEach(e -> System.out.print(e + " "));
		
		System.out.println("\n");
		
			/** averagingDouble(ToDobuleFunction<T> mapper)�޼ҵ� 
			 * 	�� Collector<T,?,Double>���� : T�� Double�� ������ �� Double�� ��հ��� ���� - �ڼ��� �ڵ�*/
		Stream<Student> stream4 = list.stream();
		Function<Student,Student.City> classifier4 = Student :: getCity;
		
		ToDoubleFunction<Student> mapper3 = e -> (double)e.getAge();
		Collector<Student,?,Double> collector7 = Collectors.averagingDouble(mapper3);  
		
		Collector<Student, ?, Map<Student.City, Double>> collector8 = Collectors.groupingBy(classifier4,collector7);
		
		Map<Student.City,Double> map7 = stream4.collect(collector8);
		
		System.out.println("�λ� �������: " + map7.get(Student.City.Pusan));
		System.out.println("���� �������: " + map7.get(Student.City.Seoul));
		
		System.out.println();
		
			/** averagingDouble(ToDobuleFunction<T> mapper)�޼ҵ� 
			 * 	�� Collector<T,?,Double>���� : T�� Double�� ������ �� Double�� ��հ��� ���� - ������ �ڵ�*/
		Map<Student.City,Double> map8 = list.stream()
				.collect(
						Collectors.groupingBy(
								Student :: getCity,
								Collectors.averagingDouble(Student :: getAge)
						)
						
				);
		System.out.println("�λ� �������: " + map8.get(Student.City.Pusan));
		System.out.println("���� �������: " + map8.get(Student.City.Seoul));
		
		System.out.println();
		
			/** joining(CharSequence delimiter)�޼ҵ� 
			 * 	�� Collector<CharSequence,?,String>����: CharSequence�� �����ڷ� ������ String�� ���� - ������ �ڵ� */
		Map<Student.Sex,String> map9 = list.stream()
				.collect(
						Collectors.groupingBy(
								Student :: getSex,
								Collectors.mapping(
										Student :: getName,
										Collectors.joining(",")
								)
						)
				);
		System.out.println("����: " + map9.get(Student.Sex.Male));
		System.out.println("����: " + map9.get(Student.Sex.Female));
		
	}
}
