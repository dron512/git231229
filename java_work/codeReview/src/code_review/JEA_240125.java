package code_review;

import java.util.Scanner;

public class JEA_240125 {
	public static void main(String[] args) {		
		String[] game = {"가위","바위","보"};
		Scanner sc = new Scanner(System.in);
		
		int win_cnt = 0;		// 승리 횟수
		int lose_cnt = 0;		// 패배 횟수
		int tie = 0;			// 무승부 횟수
		
		System.out.println("--------------------------------");
		System.out.println(">>        가위바위보 게임        <<");
		System.out.println("-------------종료:0--------------");
		for(int i = 0 ; i < 3 ; i++) {
			int random = (int)(Math.random() * 3); // 0~2의 랜덤 숫자를 가짐
			String bot = game[random];			   // ramdom 변수를 game 배열의 index값으로 활용
			
			System.out.println();
			System.out.println("● " + (i+1) + "판째! 가위~바위~보!");
			String user = sc.next();
			
			switch (user) {
				case "가위":	// user가 가위를 입력하면 아래 코드를 실행
					if(bot == "가위") {
						System.out.println("비겼습니다¯\\(°_o)/¯");
						tie++;		// 무승부 횟수 +1
					} else if(bot == "바위") {
						System.out.println("졌습니다(っ °Д °;)っ");
						lose_cnt++; // 패배 횟수 +1
					} else if(bot == "보") {
						System.out.println("이겼습니다q(≧▽≦q)");
						win_cnt++;	// 승리 횟수 +1
					}
					break;
				case "바위":
					if(bot == "바위") {
						System.out.println("비겼습니다¯\\(°_o)/¯");
						tie++;
					} else if(bot == "보") {
						System.out.println("졌습니다(っ °Д °;)っ");
						lose_cnt++;
					} else if(bot == "가위") {
						System.out.println("이겼습니다q(≧▽≦q)");
						win_cnt++;
					}
					break;
				case "보":
					if(bot == "보") {
						System.out.println("비겼습니다¯\\(°_o)/¯");
						tie++;
					} else if(bot == "가위") {
						System.out.println("졌습니다(っ °Д °;)っ");
						lose_cnt++;
					} else if(bot == "바위") {
						System.out.println("이겼습니다q(≧▽≦q)");
						win_cnt++;
					}
					break;
				case "0":	// 종료
					System.out.println("종료합니다.");
					break;
				default:	// 가위, 바위, 보, 0을 제외한 다른 문자열을 입력할 시 아래 내용 출력
					System.err.println("가위,바위,보 중 하나만 내주세요.");
			}
		}
		
		// 승리 횟수를 통해 가위바위보 게임 결과 출력
		if(win_cnt == 0) {
			
			System.out.println();
			System.out.println("아쉽게도 한번도 이기지 못했습니다 :(");
			System.out.println("-----[결    과]-----");
			System.out.println("     3판 " + tie + "무 " + lose_cnt++ + "패");
			System.out.println("-------------------");
			
		} else if(win_cnt == 3) {
			
			System.out.println();
			System.out.println("Victory!! 세판 모두 이기셨네요! 축하드립니다!");
			
		} else {
			
			System.out.println();
			System.out.println("-----[결    과]-----");
			System.out.println("   3판 " + tie + "무 " + win_cnt + "승 " + lose_cnt++ + "패");
			System.out.println("-------------------");
			
		}
			
	}
}
