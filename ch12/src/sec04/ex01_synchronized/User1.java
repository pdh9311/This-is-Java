package sec04.ex01_synchronized;

public class User1 extends 	Thread {
	private ShareObject shareObj;

	public void setShareObject(ShareObject shareObj) {
		this.setName("User1");
		this.shareObj  = shareObj;
	}
	
	@Override
	public void run() {
		shareObj.setNumber(10);
	}
	
	
}
