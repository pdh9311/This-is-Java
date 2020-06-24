package sec12.ex01_Wrapper;

public class BoxingUnBoxing {
	public static void main(String[] args) {
		// Boxing 
		Byte byteObj = new Byte((byte) 10);
		byteObj = new Byte("10");
		byteObj = Byte.valueOf((byte) 10);
		byteObj = Byte.valueOf("10");
		byteObj = 10;		// �ڵ� �ڽ�
		
		Character charObj = new Character('��');
		charObj = Character.valueOf('��');
		charObj = '��';		// �ڵ� �ڽ�
		
		Short shortObj = new Short((short) 10);
		shortObj = new Short("10");
		shortObj = Short.valueOf((short) 10);
		shortObj = Short.valueOf("10");
		shortObj = 10;		// �ڵ� �ڽ�
		
		Integer intObj = new Integer(10);
		intObj = new Integer("10");
		intObj = Integer.valueOf(10);
		intObj = Integer.valueOf("10");
		intObj = 10;		// �ڵ� �ڽ�
		
		Long longObj = new Long(10);
		longObj = new Long("10");
		longObj = Long.valueOf(10);
		longObj = Long.valueOf("10");
		longObj = 10l;		// �ڵ� �ڽ�
		
		Float floatObj = new Float(10.0f);
		floatObj = new Float("10.0f");
		floatObj = Float.valueOf(10.0f);
		floatObj = Float.valueOf("10.0f");
		floatObj = 10.0f;		// �ڵ� �ڽ�
		
		Double doubleObj = new Double(10.0);
		doubleObj = new Double("10.0");
		doubleObj = Double.valueOf(10.0);
		doubleObj = Double.valueOf("10.0");
		doubleObj = 10.0;		// �ڵ� �ڽ�
		
		Boolean boolObj = new Boolean(true);
		boolObj = new Boolean("true");
		boolObj = Boolean.valueOf(true);
		boolObj = Boolean.valueOf("true");
		boolObj = true;		// �ڵ� �ڽ�
		
		// Unboxing
		byte byteVal = byteObj.byteValue();
		byteVal = byteObj;	// �ڵ� ��ڽ�
		
		char charVal = charObj.charValue();
		charVal = charObj;	// �ڵ� ��ڽ�
		
		short shortVal = shortObj.shortValue();
		shortVal = shortObj;	// �ڵ� ��ڽ�
		
		int intVal = intObj.intValue();
		intVal = intObj;	// �ڵ� ��ڽ�
		
		long longVal = longObj.longValue();
		longVal = longObj;	// �ڵ� ��ڽ�
		
		float floatVal = floatObj.floatValue();
		floatVal = floatObj;	// �ڵ� ��ڽ�
		
		double doubleVal = doubleObj.doubleValue();
		doubleVal = doubleObj;	// �ڵ� ��ڽ�
		
		boolean boolVal = boolObj.booleanValue();
		boolVal = boolObj;	// �ڵ� ��ڽ�
		
		System.out.println(byteVal);
		System.out.println(charVal);
		System.out.println(shortVal);
		System.out.println(intVal);
		System.out.println(longVal);
		System.out.println(floatVal);
		System.out.println(doubleVal);
		System.out.println(boolVal);
		
		// ���ڿ��� �⺻Ÿ�� ������ ��ȯ: ���尴ü.parse+�⺻Ÿ��
		byteVal = Byte.parseByte("10");
		shortVal = Short.parseShort("10");
		intVal = Integer.parseInt("10");
		longVal = Long.parseLong("10");
		floatVal = Float.parseFloat("10.0f");
		doubleVal = Double.parseDouble("10.0");
		boolVal = Boolean.parseBoolean("true");
		
		//���尪 �� ��� ������ �����ϰ�� == �Ǵ� != �� ���� ���� �� �����Ƿ� equals()�� �̿��ؼ� ���� ���ؾ� �����ϴ�.
		Integer i1 = 300;
		Integer i2 = 300;
		System.out.println(i1 == i2);
		System.out.println(i1.equals(i2));
	}
	
}
