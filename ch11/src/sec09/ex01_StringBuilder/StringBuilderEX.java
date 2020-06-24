package sec09.ex01_StringBuilder;

public class StringBuilderEX {
	public static void main(String[] args) {
		/* String은 문자열을 수정할 수 없다!!! 
		 * 문자열끼리 +연산을 하여 기존 문자열을 수정하고 싶을때 
		 * 기존 문자열이 수정되는것이 아니라 +연산한 새로운 문자열이 만들어지고 새로 만들어진 문자열을 참조하게 된다. 
		 * 따라서 문자를 결합하는 +연산자를 많이 사용할 경우 그 만큼 String객체가 늘어나고 프로그램 성능을 저하시키게 된다.
		 * 하지만 StringBuffer나 StringBuilder는 내부 버퍼(데이티를 임시로 저장하는 메모리)에 문자열을 저장해 두고, 그 안에서 추가,수정,삭제 작업을 할 수 있도록 되어 있다. 
		 * StringBuffer: 멀티스레드환경에서 사용  | StringBuilder: 단일 스레드환경에서만 사용 */
		StringBuilder sb = new StringBuilder();		// StringBuilder()의 매개값으로 문자열을 넣는다면 매개값을 초기버퍼값으로 저장한다.
		sb.append("Java ");
		sb.append("Program ");
		sb.append("Study");
		System.out.println(sb.toString());
		
		sb.insert(4, "2");		// 인덱스 4위치에 2를 삽입
		System.out.println(sb.toString());
		
		sb.setCharAt(4, '6');	// 인덱스 4위치를 6으로 변경
		System.out.println(sb.toString());
		
		sb.replace(6, 13, "Book");	// 인덱스 6위치부터 13전까지를 Book으로 대체
		System.out.println(sb.toString());
		
		sb.delete(4, 5);	// 인덱스 4위치부터 5전까지를 삭제
		System.out.println(sb.toString());
		
		int length = sb.length();		// 버퍼에 있는 문자의 수를 리턴
		System.out.println("총 문자수: " + length);
		
		String result = sb.toString();		// 버퍼에 있는 것을 String타입으로 리턴
		System.out.println(result);
	}
}
