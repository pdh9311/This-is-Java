package sec05.ex01_Systemexit;

public class Exit {
	public static void main(String[] args) {
		//���� ������ ����
		System.setSecurityManager(new SecurityManager() {
			@Override
			public void checkExit(int status) {
				if(status != 8) {						//System.exit(status)
					throw new SecurityException();
				}
			}
		});
		
		for(int i=0;i<10;i++) {
			System.out.println(i);
			try {
				System.exit(i);
			} catch (Exception e) {}
		}
		
	}
}
