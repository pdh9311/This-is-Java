package sec06.ex01_���ϵ�ī��Ÿ��;

import java.util.Arrays;

public class WildcardType {
	
	/* ���ϵ� ī�� Ÿ���� �̿��� Ÿ�� �Ķ������ Ÿ�� ����
	 * ? : ��� Ÿ��
	 * ? extends ����Ÿ�� : ����Ÿ��, ����Ÿ��
	 * ? super ����Ÿ�� : ����Ÿ��, ����Ÿ��
	 */
	public static void registerCourseAll(Course<?> course) {
		System.out.println(course.getName() + " ������: " + Arrays.toString(course.getStudents()) );
	}
	
	public static void registerCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName() + " ������: " + Arrays.toString(course.getStudents()));
	}
	
	public static void registerCourseWorker(Course<? super Worker> course) {
		System.out.println(course.getName() + " ������: " + Arrays.toString(course.getStudents()));
	}
	
	public static void main(String[] args) {
		Person person = new Person("�Ϲ��� �ڵ���");
		Worker worker = new Worker("������ ���¿�");
		Student student = new Student("�л� ������");
		HighStudent highStudent = new HighStudent("����л� ����");
		
		Course<Person> personCourse = new Course<Person>("�Ϲ��ΰ���",5);
		personCourse.add(person);
		personCourse.add(worker);
		personCourse.add(student);
		personCourse.add(highStudent);
		
		Course<Student> studentCourse = new Course<Student>("�л�����",5);
		studentCourse.add(student);
		studentCourse.add(highStudent);
		
		Course<HighStudent> highStudentCourse = new Course<HighStudent>("����л�����",5);
		highStudentCourse.add(highStudent);
		
		Course<Worker> workerCourse = new Course<Worker>("������ ����", 5);
		workerCourse.add(worker);
		
		System.out.println("[ ��� ������ ��� ]");
		registerCourseAll(personCourse);
		registerCourseAll(workerCourse);
		registerCourseAll(studentCourse);
		registerCourseAll(highStudentCourse);
		System.out.println();
		
		System.out.println("[ �л� ������ ��� ]");	// Student�� ��ӹ޴� ������ ��� ���
		registerCourseStudent(studentCourse);		// ��������
		registerCourseStudent(highStudentCourse);	// ��������
		
		System.out.println("[ ������ ������ ��� ]");	// Worker�� �θ��� ������ ��� ���
		registerCourseWorker(workerCourse);		// ��������
		registerCourseWorker(personCourse);		// ��������
		System.out.println();
	}
	
}
