package sec12.ex01_Wrapper;

public class BoxingUnBoxing {
	public static void main(String[] args) {
		// Boxing 
		Byte byteObj = new Byte((byte) 10);
		byteObj = new Byte("10");
		byteObj = Byte.valueOf((byte) 10);
		byteObj = Byte.valueOf("10");
		byteObj = 10;		// 자동 박싱
		
		Character charObj = new Character('가');
		charObj = Character.valueOf('가');
		charObj = '가';		// 자동 박싱
		
		Short shortObj = new Short((short) 10);
		shortObj = new Short("10");
		shortObj = Short.valueOf((short) 10);
		shortObj = Short.valueOf("10");
		shortObj = 10;		// 자동 박싱
		
		Integer intObj = new Integer(10);
		intObj = new Integer("10");
		intObj = Integer.valueOf(10);
		intObj = Integer.valueOf("10");
		intObj = 10;		// 자동 박싱
		
		Long longObj = new Long(10);
		longObj = new Long("10");
		longObj = Long.valueOf(10);
		longObj = Long.valueOf("10");
		longObj = 10l;		// 자동 박싱
		
		Float floatObj = new Float(10.0f);
		floatObj = new Float("10.0f");
		floatObj = Float.valueOf(10.0f);
		floatObj = Float.valueOf("10.0f");
		floatObj = 10.0f;		// 자동 박싱
		
		Double doubleObj = new Double(10.0);
		doubleObj = new Double("10.0");
		doubleObj = Double.valueOf(10.0);
		doubleObj = Double.valueOf("10.0");
		doubleObj = 10.0;		// 자동 박싱
		
		Boolean boolObj = new Boolean(true);
		boolObj = new Boolean("true");
		boolObj = Boolean.valueOf(true);
		boolObj = Boolean.valueOf("true");
		boolObj = true;		// 자동 박싱
		
		// Unboxing
		byte byteVal = byteObj.byteValue();
		byteVal = byteObj;	// 자동 언박싱
		
		char charVal = charObj.charValue();
		charVal = charObj;	// 자동 언박싱
		
		short shortVal = shortObj.shortValue();
		shortVal = shortObj;	// 자동 언박싱
		
		int intVal = intObj.intValue();
		intVal = intObj;	// 자동 언박싱
		
		long longVal = longObj.longValue();
		longVal = longObj;	// 자동 언박싱
		
		float floatVal = floatObj.floatValue();
		floatVal = floatObj;	// 자동 언박싱
		
		double doubleVal = doubleObj.doubleValue();
		doubleVal = doubleObj;	// 자동 언박싱
		
		boolean boolVal = boolObj.booleanValue();
		boolVal = boolObj;	// 자동 언박싱
		
		System.out.println(byteVal);
		System.out.println(charVal);
		System.out.println(shortVal);
		System.out.println(intVal);
		System.out.println(longVal);
		System.out.println(floatVal);
		System.out.println(doubleVal);
		System.out.println(boolVal);
		
		// 문자열을 기본타입 값으로 변환: 포장객체.parse+기본타입
		byteVal = Byte.parseByte("10");
		shortVal = Short.parseShort("10");
		intVal = Integer.parseInt("10");
		longVal = Long.parseLong("10");
		floatVal = Float.parseFloat("10.0f");
		doubleVal = Double.parseDouble("10.0");
		boolVal = Boolean.parseBoolean("true");
		
		//포장값 비교 어떠한 범위를 제외하고는 == 또는 != 로 값을 비교할 수 없으므로 equals()을 이용해서 값을 비교해야 안전하다.
		Integer i1 = 300;
		Integer i2 = 300;
		System.out.println(i1 == i2);
		System.out.println(i1.equals(i2));
	}
	
}
