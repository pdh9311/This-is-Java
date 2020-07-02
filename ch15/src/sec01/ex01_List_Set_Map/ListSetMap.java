package sec01.ex01_List_Set_Map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class ListSetMap {
	public static void main(String[] args) {
		/* List�� Set�� ��ü�� �߰�, ����, �˻��ϴ� ����� ���� �������� �ֱ� ������
		 * List �������̽��� Set �������̽� �� ����� �޼ҵ�鸸 ��� Collection �������̽��� ������ �ΰ� �ִ�. */
		Collection<Object> collectionArrayList = new ArrayList<>();
		Collection<Object> collectionVector = new Vector<>();
		Collection<Object> collectionLinkedList = new LinkedList<>();
		Collection<Object> collectionHashSet = new HashSet<>();
		Collection<Object> collectionTreeSet = new TreeSet<>();
		
		List<Object> arrayList = new ArrayList<>();
		List<Object> vector = new Vector<>();				// ����ȭ�� �޼ҵ�� �����Ǿ� �־� ��Ƽ ������ȯ�濡�� �����ϴ�.
		List<Object> linkedList = new LinkedList<>();		
		
		Set<Object> hashSet = new HashSet<>();
		Set<Object> treeSet = new TreeSet<>();				// �˻� ����� ��ȭ��Ų �÷���
		
		Map<Object,Object> hashMap = new HashMap<>();
		Map<Object,Object> hashtable = new Hashtable<>();	// ����ȭ�� �޼ҵ�� �����Ǿ� �־� ��Ƽ ������ȯ�濡�� �����ϴ�.
		Map<Object,Object> treeMap = new TreeMap<>();		// �˻� ����� ��ȭ��Ų �÷���
		Properties properties = new Properties(); 			// Properties�� Hashtable�� ����Ŭ�����̸� Ű�� ���� StringŸ������ ������ �÷����̴�.	
	}
}
