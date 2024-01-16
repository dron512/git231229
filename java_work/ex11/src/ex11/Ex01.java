package ex11;

/*
 * 연락처 관리 프로그램
 */
public class Ex01 {

	public static void main(String[] args) {
		Person[] p = new Person[10];
		
		p[0] = new Person();
		p[0].name = "홍길동";
		
		p[0].setPerson("이길동", "010-9946-2662",
				"남자", "음.. 뭐 적어 놓을까...");
		
		System.out.println(p[0]);
		System.out.println(p[1]);
		System.out.println(p[2]);
		
//		String[] name = new String[10];
//		String[] phone = new String[10];
//		String[] gender = new String[10];
//		String[] remark = new String[10];
		
	}
}
