package sec07.ex01_사용자정의예외;

import java.io.PrintStream;

public class UseAccount {
	public static void main(String[] args) {
		Account account = new Account();
		
		account.deposit(100000);
		System.out.println("예금액 : " + account.getBalance());
		
		try {
			account.withdraw(110000);
		} catch (BalanceInsufficientException e) {
			System.out.println(e.getMessage()+"\n");
			e.printStackTrace();
		}
	}
}
