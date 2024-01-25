package japangi;

import java.util.Scanner;

public class Japangi {
	public static void main(String[] args) {
		Drink d = new Drink();
		Coin c = new Coin();
		
		String suscess = "구매 성공! 여기있어! ~_~ 가져가!! : ";

		Scanner scan = new Scanner(System.in);

		stop: while (true) {
			System.out.println("======= 골라보렴 자판기 =======");
			System.out.println("콜라:500원  환타:300원  물:100원");
			System.out.println("1.돈 넣기 , 2.그냥 안 먹을래");
			int a = scan.nextInt();
			System.out.println();

			switch (a) {
				case 1:
					System.out.println("---------------------------");
					System.out.print(" \\\\^V^// 돈 넣어죵 : ");
					c.coin += scan.nextInt();
					System.out.println();
	
					if (c.coin< d.getW()) {
						System.out.println("돈이 너무 부족할걸?");
						System.out.println("돈을 더 넣어볼래??");
						System.out.println();
	
					} else if (c.coin >= d.getC()) {
						System.out.println("==== 뭐 먹을랭?? 골라골라골라 ====");
						System.out.println("1.콜라:500원  2.환타:300원  3.물:100원");
						System.out.print("선택한 번호는 ?!! : ");
						int number = scan.nextInt();
						System.out.println();
	
						switch (number) {
						
							case 1:
								if (c.coin>= d.getC()) {
									System.out.println(suscess + d.getCc());
									c.coin = c.coin - d.c;
									System.out.println();
									System.out.println("---------------------------");
									System.out.println("잔돈은 돌려줄게 : " + c.getCoin());
								}
								break stop;
								
							case 2:
								if (c.coin>= d.getH()) {
									System.out.println(suscess + d.getHh());
									c.coin = c.coin - d.h;
									System.out.println();
									System.out.println("---------------------------");
									System.out.println("잔돈은 돌려줄게 : " + c.getCoin());
								}
								break stop;
								
							case 3:
								if (c.coin >= d.getW()) {
									System.out.println(suscess + d.getWw());
									c.coin = c.coin - d.w;
									System.out.println();
									System.out.println("---------------------------");
									System.out.println("잔돈은 돌려줄게 : " + c.getCoin());
								}
								break stop;
								
						}
					} else if (c.coin< d.getC() &&c.coin>= d.getH()) {
						System.out.println("==== 뭐 먹을랭?? 골라골라골라 ====");
						System.out.println("1.환타:300원  2.물:100원");
						System.out.print("선택한 번호는 ?!! : ");
						int number = scan.nextInt();
						System.out.println();
	
						switch (number) {
								
							case 1:
								if (c.coin>= d.getH()) {
									System.out.println(suscess + d.getHh());
									c.coin = c.coin - d.h;
									System.out.println();
									System.out.println("---------------------------");
									System.out.println("잔돈은 돌려줄게 : " + c.getCoin());
								}
								break stop;
								
							case 2:
								if (c.coin >= d.getW()) {
									System.out.println(suscess + d.getWw());
									c.coin = c.coin - d.w;
									System.out.println();
									System.out.println("---------------------------");
									System.out.println("잔돈은 돌려줄게 : " + c.getCoin());
								}
								break stop;
								
						}
					} else if (c.coin< d.getH() && c.coin>= d.getW()) {
						System.out.println("==== 뭐 먹을랭?? 골라골라골라 ====");
						System.out.println("1.물:100원");
						System.out.print("선택한 번호는 ?!! : ");
						int number = scan.nextInt();
						System.out.println();
	
						switch (number) {								
							case 1:
								System.out.println(suscess + d.getWw());
								c.coin = c.coin - d.w;
								System.out.println();
								System.out.println("---------------------------");
								System.out.println("잔돈은 돌려줄게 : " + c.getCoin());
								break stop;
						}
					} 
					break;
				case 2:
					System.out.println("잘 가");
					if(c.getCoin()!=0) {
						System.out.println("반환돈은 여기있어 :: " + c.getCoin());
					}
					System.exit(0);
					break;
					
				default:
					System.out.println("잘못 눌렀어");
					break;
			}
		}
	}
}

class Coin {
	public int coin;

	Coin() {

	}

	Coin(int coin) {
		this.coin = coin;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	@Override
	public String toString() {
		return "Coin [coin=" + coin + "]";
	}

}

class Drink {
	int c = 500;
	int h = 300;
	int w = 100;
	
	String cc = "콜라";
	String hh = "환타";
	String ww = "물";
	
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getHh() {
		return hh;
	}
	public void setHh(String hh) {
		this.hh = hh;
	}
	public String getWw() {
		return ww;
	}
	public void setWw(String ww) {
		this.ww = ww;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
}


