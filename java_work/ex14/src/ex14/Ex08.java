package ex14;

public class Ex08 {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					sb.append("t1 "+i);
					System.out.println(sb);
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					sb.append("t2 "+i);
					System.out.println(sb);
				}
			}
		});
		
		t1.start();
		t2.start();
		
	}
}
