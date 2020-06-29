package sec06.ex01_와일드카드타입;

import java.util.Arrays;

public class WildcardType {
	
	/* 와일드 카드 타입을 이용한 타입 파라미터의 타입 제한
	 * ? : 모든 타입
	 * ? extends 상위타입 : 상위타입, 하위타입
	 * ? super 하위타입 : 하위타입, 상위타입
	 */
	public static void registerCourseAll(Course<?> course) {
		System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()) );
	}
	
	public static void registerCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
	}
	
	public static void registerCourseWorker(Course<? super Worker> course) {
		System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
	}
	
	public static void main(String[] args) {
		Person person = new Person("일반인 박동현");
		Worker worker = new Worker("직장인 전태웅");
		Student student = new Student("학생 정대한");
		HighStudent highStudent = new HighStudent("고등학생 랩퍼");
		
		Course<Person> personCourse = new Course<Person>("일반인과정",5);
		personCourse.add(person);
		personCourse.add(worker);
		personCourse.add(student);
		personCourse.add(highStudent);
		
		Course<Student> studentCourse = new Course<Student>("학생과정",5);
		studentCourse.add(student);
		studentCourse.add(highStudent);
		
		Course<HighStudent> highStudentCourse = new Course<HighStudent>("고등학생과정",5);
		highStudentCourse.add(highStudent);
		
		Course<Worker> workerCourse = new Course<Worker>("직장인 과정", 5);
		workerCourse.add(worker);
		
		System.out.println("[ 모든 과정을 등록 ]");
		registerCourseAll(personCourse);
		registerCourseAll(workerCourse);
		registerCourseAll(studentCourse);
		registerCourseAll(highStudentCourse);
		System.out.println();
		
		System.out.println("[ 학생 과정만 등록 ]");	// Student를 상속받는 과정은 등록 대상
		registerCourseStudent(studentCourse);		// 상위과정
		registerCourseStudent(highStudentCourse);	// 하위과정
		
		System.out.println("[ 직장인 과정만 등록 ]");	// Worker의 부모인 과정은 등록 대상
		registerCourseWorker(workerCourse);		// 하위과정
		registerCourseWorker(personCourse);		// 상위과정
		System.out.println();
	}
	
}
