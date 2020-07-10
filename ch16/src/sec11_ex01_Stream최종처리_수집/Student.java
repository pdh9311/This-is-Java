package sec11_ex01_Stream최종처리_수집;

public class Student {
	public enum Sex { Male, Female }
	public enum City { Pusan, Seoul }
	
	private String name;
	private int age;
	private Sex sex;
	private City city;
	
	public Student(String name, int age, Sex sex, City city) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.city = city;
	}

	public String getName() { return name; }

	public int getAge() { return age; }

	public Sex getSex() { return sex; }

	public City getCity() { return city; }
	
}
