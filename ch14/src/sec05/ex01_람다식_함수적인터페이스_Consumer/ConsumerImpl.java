package sec05.ex01_���ٽ�_�Լ����������̽�_Consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;

public class ConsumerImpl {
	public static void main(String[] args) {
		// �Լ��� �������̽� XXXConsumer�� accept()�޼ҵ�� �Ű����� ������ ���ϰ��� ����.
		Consumer<String> consumer = t -> System.out.println(t);
		consumer.accept("Consumer<T>");
		
		BiConsumer<String,String> biConsumer = (t1,t2) -> System.out.println(t1 + t2);
		biConsumer.accept("Bi","Consumer<T,U>");
		
		DoubleConsumer doubleConsumer = d -> System.out.println(d);
		doubleConsumer.accept(8.0);
		
		IntConsumer intConsumer = i -> System.out.println(i);
		intConsumer.accept(8);
		
		LongConsumer longConsumer = l -> System.out.println(l);
		longConsumer.accept(1231231231231L);
		
		ObjDoubleConsumer<String> objDoubleConsumer = (t,d) -> System.out.println(t + d);
		objDoubleConsumer.accept("Java", 8.0);
		
		ObjIntConsumer<String> objIntConsumer = (t,i) -> System.out.println(t + i);
		objIntConsumer.accept("Java", 8);
		
		ObjLongConsumer<String> objLongConsumer = (t,l) -> System.out.println(t + l);
		objLongConsumer.accept("Java", 1231231231231L);
	}
}