package sec08.ex01_����ó���÷���;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentXXX {
	public static void main(String[] args) {
		/* ����ȭ �÷����� ��Ƽ ������ ȯ�濡�� �ϳ��� �����尡 ��Ҹ� �����ϰ� ó���ϵ��� ����������, ��ü ��Ҹ� ������ ó�������� ���Ѵ�.
		 * �ϳ��� �����尡 ��Ҹ� ó���� �� ��ü ����� �߻��Ͽ� �ٸ� ������� ��� ���°� �Ǳ� ������ ��Ƽ �����尡 ���������� �÷����� ��Ҹ� ó���� �� ����.
		 * ConcurrentHashMap Ŭ������ ����ϸ� �κ������ ����ϱ� ������ �����忡 �����ϴ�.
		 * ConcurrentLinkedQueue Ŭ������ ��-���� �˰����� ������ Ŭ�����μ� �������� �����尡 ���ÿ� ������ ���,
		 * ����� ������� �ʰ� �ּ��� �ϳ��� �����尡 �����ϰ� ��Ҹ� �����ϰų� �򵵷� ���ش�. */

		Map<Object,Object> map = new ConcurrentHashMap<Object,Object>();
		
		Queue<Object> queue = new ConcurrentLinkedQueue<Object>();
	}
}
