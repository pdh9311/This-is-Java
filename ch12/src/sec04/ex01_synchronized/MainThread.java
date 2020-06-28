package sec04.ex01_synchronized;

import sec05.ex01_ThreadState.ThreadState;

public class MainThread {
	public static void main(String[] args) {
		ShareObject shareObj = new ShareObject();
		
		User1 user1 = new User1();
		user1.setShareObject(shareObj);
		user1.start();
		
		User2 user2 = new User2();
		user2.setShareObject(shareObj);
		user2.start();
		
		ThreadState user1ThreadState = new ThreadState(user1);
		user1ThreadState.start();
		
		ThreadState user2ThreadState = new ThreadState(user2);
		user2ThreadState.start();
	}
}
