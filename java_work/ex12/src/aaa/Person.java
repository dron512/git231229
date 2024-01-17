package aaa;

public class Person {

	private String name;
	private String phone;
	
	public Person() {
		doAction();
	}
	
	protected void doAction() {
		System.out.println(name + "이 움직입니다.");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	// alt +shift + s -> r
}
