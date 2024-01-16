package ex11;

public class Main {

	public static void main(String[] args) {
		BankAccount 윤 = new BankAccount();
		BankAccount 박 = new BankAccount();
		
		윤.입금하기(10000);
		박.입금하기(20000);
		
		윤.출금하기(2000);
		박.출금하기(3000);
		
		윤.확인하기();
		박.확인하기();
		
		윤.입금하기(20000);
		윤.확인하기();
		
		박.출금하기(2000);
		박.확인하기();
	}
}
