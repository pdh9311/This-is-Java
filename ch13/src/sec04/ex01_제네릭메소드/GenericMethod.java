package sec04.ex01_���׸��޼ҵ�;

public class GenericMethod<T> {
	private T t;
	
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	// 	<Ÿ���Ķ����,...> ����Ÿ�� ���׸��޼ҵ��(�Ű�Ÿ��) -1
	public static <T> GenericMethod<T> genericMethod(T t) {
		GenericMethod<T> genericMethod = new GenericMethod<T>();
		genericMethod.setT(t);
		return genericMethod;
	}
	
	// 	<Ÿ���Ķ����,...> ����Ÿ�� ���׸��޼ҵ��(�Ű�Ÿ��) -2
	 public static <T> boolean test(T t) {
		 if(t.getClass().getSimpleName().equals("Integer")) {
			 return true;
		 } else {
			 return false;
		 }
	 }
	 
	 // <Ÿ���Ķ����,...> ����Ÿ�� ���׸��޼ҵ��(�Ű�Ÿ��) -3
	 public static <K,V> boolean compare(Pair<K,V> p1, Pair<K,V> p2) {
		 boolean boolA = p1.getK().equals(p2.getK());
		 boolean boolB = p1.getV().equals(p2.getV());
		 return boolA && boolB;
	 }
	 
	 // <Ÿ���Ķ����,...> ����Ÿ�� ���׸��޼ҵ��(�Ű�Ÿ��) -4
	 /* Ÿ�� �ĸ����͸� �����Ҷ� extends �ڿ� ���� Ŭ������ �������̽��� ����� �� �ְ�, 
	  * {}������ ���� Ÿ���� �ʵ峪 �޼ҵ常 ��� �����ϴ�. */
	 public static <T extends Number> int compareNum(T t1, T t2) {
		 double d1 = t1.doubleValue();
		 double d2 = t2.doubleValue();
		 return Double.compare(d1, d2);
	 }
	
	public static void main(String[] args) {
		GenericMethod<Integer> genericM1 = GenericMethod.<Integer>genericMethod(100);	// Ÿ�� �Ķ���͸� ��������� Integer ����
		Integer intValue = genericM1.getT();
		System.out.println(intValue);
		
		GenericMethod<String> genericM2 = GenericMethod.genericMethod("ȫ�浿");			// Ÿ�� �Ķ���͸� String���� ����
		String str = genericM2.getT();
		System.out.println(str);
		
		System.out.println(GenericMethod.test(1122));
		System.out.println(GenericMethod.test("test") + "\n");
		
		Pair<Integer,String> p1 = new Pair<>(1, "ȫ�浿");
		Pair<Integer,String> p2 = new Pair<>(1, "ȫ�浿");
		boolean p1p2Result = GenericMethod.compare(p1, p2);
		System.out.println(p1p2Result ? "�������� ������ ��ü" : "�������� ������������ ��ü");
		
		Pair<Integer,Integer> p3 = new Pair<>(1, 213);
		Pair<Integer,Integer> p4 = new Pair<>(1, 123);
		boolean p3p4Result = GenericMethod.compare(p3, p4);
		System.out.println(p3p4Result ? "�������� ������ ��ü" : "�������� ������������ ��ü");
		
		System.out.println(GenericMethod.compareNum(123, 1324));	// Integer�� �ڵ� Boxing �ȴ�.
		System.out.println(GenericMethod.compareNum(123.43, 1324)); // Double�� �ڵ� Boxing �ȴ�.
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
