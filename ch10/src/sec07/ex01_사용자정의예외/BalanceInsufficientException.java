package sec07.ex01_��������ǿ���;

// extends Exception : �Ϲ� ����
// extends RuntimeException : ���� ����
public class BalanceInsufficientException extends Exception {
	
	// �⺻ ������
	public BalanceInsufficientException() { }
	
	// ���� �߻� ����(���� �޽���)�� �����ϱ� ���� String Ÿ���� �Ű� ������ ���� ������
	public BalanceInsufficientException (String message) {
		super(message);
	}
	
}
