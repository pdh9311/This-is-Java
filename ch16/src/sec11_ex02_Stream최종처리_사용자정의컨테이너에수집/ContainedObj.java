package sec11_ex02_Stream최종처리_사용자정의컨테이너에수집;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import sec11_ex01_Stream최종처리_수집.Student;

public class ContainedObj {
	public static void main(String[] args) {
		// List, Set, Map과 같은 컬렉션이 아니라 사용자 컨테이너 객체에 수집
		List<Student> list = Arrays.asList(
				new Student("븝미짱",28,Student.Sex.Female,Student.City.Pusan),
				new Student("만식짱",30,Student.Sex.Male,Student.City.Seoul),
				new Student("토끼짱",25,Student.Sex.Female,Student.City.Seoul),
				new Student("초밥짱",29,Student.Sex.Male,Student.City.Pusan) );
		
		// collect()메소드의 매개값으로 Supplier,BiConsumer, BiConsumer - 자세한 코드
		Stream<Student> stream1 = list.stream();
		Stream<Student> maleStream = stream1.filter(s -> s.getSex() == Student.Sex.Male);
		Supplier<Container> supplier = Container :: new;						// 첫번째 Supplier는 요소들이 수집될 컨테이너 객체를 생성하는 역할을 한다.
		BiConsumer<Container, Student> accumulator = (c,s) -> c.accumulate(s);	// Container의 accumulate()메소드로 Student를 수집하는 BiConsuemer를 얻는다. 
		BiConsumer<Container, Container> combiner = (c1,c2) -> c1.combine(c2);	// 병렬처리스트림을 사용할때 다른 Contianer와 결합할 목적으로 실행되지만 순차처리라도 매개값으로 넣어주기위해 BiConsuemr를 생성할 필요가 있다. 
		Container container1 = maleStream.collect(supplier, accumulator, combiner);
		
		List<Student> maleList = container1.getList();
		maleList.stream().forEach(s -> System.out.print("[1]" + s.getName() + " "));
		
		System.out.println("\n");	try {Thread.sleep(1000);} catch(Exception e) {}
		
		// collect()메소드의 매개값으로 Supplier,BiConsumer, BiConsumer - 간단한 코드
		/* 쿼드코어CPU에서 실행되기때문에 4개의 서브요소로 나눠지고, 4개의 스레드가 병렬처리한다.
		 * 각 스레드는 서브요소를 수집해야하므로 4개의 Container객체를 생성하기 위해 collect()메소드의 첫번째 매개값인 Container의 생성자를 4번 실행한다.
		 * 그리고 수집할 수 있는 만큼 accumulate()메소드를 실행하게되고
		 * 서브요소를 결합하기 위해 combine()메소드가 3번 실행하게 된다. */
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
		
		// collect()메소드의 매개값으로 Supplier,BiConsumer, BiConsumer - 간단한 코드(참조)
		/* parallel()메소드는 순차 처리 스트림을 병렬 처리 스트림으로 변환해준다. */
		Container container3 = list.stream().parallel().filter(s->s.getAge() > 26).collect(Container :: new , Container :: accumulate, Container :: combine);
		List<Student> twoeightList = container3.getList();
		twoeightList.stream().forEach(s -> System.out.print("[3]" + s.getName() + " "));
	}
}
