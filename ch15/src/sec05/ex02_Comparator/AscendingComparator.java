package sec05.ex02_Comparator;

import java.util.Comparator;

public class AscendingComparator implements Comparator<Man> {

	@Override
	public int compare(Man o1, Man o2) {
		if(o1.age < o2.age) {
			return -1;
		} else if(o1.age > o2.age) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
