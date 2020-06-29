package sec04.ex01_제네릭메소드;

public class GenericMethod<T> {
	private T t;
	
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	// 	<타입파라미터,...> 리턴타입 제네릭메소드명(매개타입) -1
	public static <T> GenericMethod<T> genericMethod(T t) {
		GenericMethod<T> genericMethod = new GenericMethod<T>();
		genericMethod.setT(t);
		return genericMethod;
	}
	
	// 	<타입파라미터,...> 리턴타입 제네릭메소드명(매개타입) -2
	 public static <T> boolean test(T t) {
		 if(t.getClass().getSimpleName().equals("Integer")) {
			 return true;
		 } else {
			 return false;
		 }
	 }
	 
	 // <타입파라미터,...> 리턴타입 제네릭메소드명(매개타입) -3
	 public static <K,V> boolean compare(Pair<K,V> p1, Pair<K,V> p2) {
		 boolean boolA = p1.getK().equals(p2.getK());
		 boolean boolB = p1.getV().equals(p2.getV());
		 return boolA && boolB;
	 }
	 
	 // <타입파라미터,...> 리턴타입 제네릭메소드명(매개타입) -4
	 /* 타입 파리미터를 제한할때 extends 뒤에 상위 클래스나 인터페이스를 명시할 수 있고, 
	  * {}에서는 상위 타입의 필드나 메소드만 사용 가능하다. */
	 public static <T extends Number> int compareNum(T t1, T t2) {
		 double d1 = t1.doubleValue();
		 double d2 = t2.doubleValue();
		 return Double.compare(d1, d2);
	 }
	
	public static void main(String[] args) {
		GenericMethod<Integer> genericM1 = GenericMethod.<Integer>genericMethod(100);	// 타입 파라미터를 명시적으로 Integer 지정
		Integer intValue = genericM1.getT();
		System.out.println(intValue);
		
		GenericMethod<String> genericM2 = GenericMethod.genericMethod("홍길동");			// 타입 파라미터를 String으로 추정
		String str = genericM2.getT();
		System.out.println(str);
		
		System.out.println(GenericMethod.test(1122));
		System.out.println(GenericMethod.test("test") + "\n");
		
		Pair<Integer,String> p1 = new Pair<>(1, "홍길동");
		Pair<Integer,String> p2 = new Pair<>(1, "홍길동");
		boolean p1p2Result = GenericMethod.compare(p1, p2);
		System.out.println(p1p2Result ? "논리적으로 동등한 객체" : "논리적으로 동등하지않은 객체");
		
		Pair<Integer,Integer> p3 = new Pair<>(1, 213);
		Pair<Integer,Integer> p4 = new Pair<>(1, 123);
		boolean p3p4Result = GenericMethod.compare(p3, p4);
		System.out.println(p3p4Result ? "논리적으로 동등한 객체" : "논리적으로 동등하지않은 객체");
		
		System.out.println(GenericMethod.compareNum(123, 1324));	// Integer로 자동 Boxing 된다.
		System.out.println(GenericMethod.compareNum(123.43, 1324)); // Double로 자동 Boxing 된다.
	}
	
}

class Pair<K,V> {
	private K k;
	private V v;
	
	public Pair(K k, V v) {
		this.k = k;
		this.v = v;
	}

	public K getK() {
		return k;
	}
	
	public void setK(K k) {
		this.k = k;
	}
	
	public V getV() {
		return v;
	}
	
	public void setV(V v) {
		this.v = v;
	}
	
}
