package sec07.ex01_ListSetMap����ȭ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsSynchroniezedXXX {
	public static void main(String[] args) {
		/* ��쿡 ���� ArrayList, HashSet, HashMap�� �̱� ������ ȯ�濡�� ����ϴٰ� ��Ƽ������ ȯ������ ������ �ʿ䰡 ���� ���̴�.
		 * �̶� Collections�� �����޼ҵ��� synchronizedXXX()�޼ҵ忡 �Ű������� �񵿱�ȭ�� �÷����� �־��ָ� ����ȭ�� �÷����� �������ش�. */
		
		List<Object> list = Collections.synchronizedList(new ArrayList<Object>());
		
		Set<Object> set = Collections.synchronizedSet(new HashSet<Object>());
		
		Map<Object,Object> map = Collections.synchronizedMap(new HashMap<Object,Object>());
		
	}
}
