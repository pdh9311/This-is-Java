package sec08.ex01_병렬처리컬렉션;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentXXX {
	public static void main(String[] args) {
		/* 동기화 컬렉션은 멀티 스레드 환경에서 하나의 스레드가 요소를 안전하게 처리하도록 도와주지만, 전체 요소를 빠르게 처리하지는 못한다.
		 * 하나의 스레드가 요소를 처리할 때 전체 잠금이 발생하여 다른 스레드는 대기 상태가 되기 때문에 멀티 스레드가 병렬적으로 컬렉션의 요소를 처리할 수 없다.
		 * ConcurrentHashMap 클래스를 사용하면 부분잠금을 사용하기 때문에 스레드에 안전하다.
		 * ConcurrentLinkedQueue 클래스는 락-프리 알고리즘을 구현한 클래스로서 여러개의 스레드가 동시에 접근할 경우,
		 * 잠금을 사용하지 않고도 최소한 하나의 스레드가 안전하게 요소를 저장하거나 얻도록 해준다. */

		Map<Object,Object> map = new ConcurrentHashMap<Object,Object>();
		
		Queue<Object> queue = new ConcurrentLinkedQueue<Object>();
	}
}
