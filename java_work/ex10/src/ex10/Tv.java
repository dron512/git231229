package ex10;

// 접근제어자
// public default protected private

public class Tv {
	public String color;
	public boolean power;
	public int channel;
	Tv(){ };	// 생성자 호출
	public void power() {
		System.out.println("power 버튼 누름");
		power = !power;
	}
	public void channelUp() { System.out.println("채널 올리기"); channel+=1; }
	public void channdelDown() { 
		System.out.println("채널 내리기"); 
		channel-=1;
		if (channel ==-1) {
			System.out.println("채널이 음수라서 0으로 초기화함");
			channel=0;
		}
	}
}
