package sec04.ex01_synchronized;

public class User2 extends Thread {
	private ShareObject shareObj;

	public void setShareObject(ShareObject shareObj) {
		this.setName("User2");
		this.shareObj  = shareObj;
	}
	
	@Override
	public void run() {
		shareObj.setNumber(5);
	}
	
}
