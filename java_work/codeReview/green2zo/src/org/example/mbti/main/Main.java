package org.example.mbti.main;

import org.example.mbti.db.DB;
import org.example.mbti.question.Sum;
import org.example.mbti.question.Q1;
import org.example.mbti.question.Q2;
import org.example.mbti.question.Q3;
import org.example.mbti.question.Q4;

import java.util.Scanner;

public class Main {

	private static String mbti;
	private static String type;
	private static String txt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Q1 q11 = new Q1();
		Q2 q22 = new Q2();
		Q3 q33 = new Q3();
		Q4 q44 = new Q4();

		System.out.println("\n1. 이름을 입력해 주세요.");
		String name = sc.nextLine();

		System.out.println("2. 성별을 입력해 주세요.");
		String gender = sc.nextLine();

		System.out.println("3. 나이를 입력해 주세요.");
		String age = sc.nextLine();

		System.out.println("\u001B[90m수집한 개인 정보는 미니 프로젝트 종료 후 파기됩니다.\n\u001B[0m");
		System.out.println("지금부터" + "\u001B[35m" + " ♡나와 어울리는 캐릭터 찾기♡ " + "\u001B[0m" + "테스트를 시작하겠습니다.");
		System.out.println("두 문항 중 " + name + "님과 가장 가까운 문항을 선택해 주시면 됩니다.");
		System.out.println("1 또는 2로 응답해주세요.\n");

		q11.q1();
		q11.q2();
		q11.q3();

		q22.q1();
		q22.q2();
		q22.q3();

		q33.q1();
		q33.q2();
		q33.q3();

		q44.q1();
		q44.q2();
		q44.q3();

		if (Sum.sum1 < 2 && Sum.sum2 < 2 && Sum.sum3 < 2 && Sum.sum4 < 2) {
			mbti = "ESTP";

			type = "♥쿠로미♥";

			txt = "쿠로미는 귀여운 외모와 더불어 적극적이며 열정적인 쿨내나는 캐릭터입니다.\n" + "\n" + "#YOLO #임기응변 #선입견 없음 #분위기 잘탐\n"
					+ "#스릴♡모험♡여행♡ #쿨함의 대명사 #가끔 공격적\n";

		} else if (Sum.sum1 < 2 && Sum.sum2 < 2 && Sum.sum3 < 2) {

			mbti = "ESTJ";

			type = "♥세일러 마스♥";

			txt = "세일러 마스는 우아하고 열정적인 동료애를 가진 정의롭고 카리스마 있는 캐릭터입니다.\n" + "\n" + "#완벽주의 #자신감 #창의력부족 #결단력\n"
					+ "#빈틈없음 #워커홀릭 #똑부러짐 #꼰대\n";

		} else if (Sum.sum1 < 2 && Sum.sum2 < 2 && Sum.sum4 < 2) {

			mbti = "ESFP";

			type = "♥루피♥";

			txt = "루피는 무모하지만 용감한 해적으로 매사에 최선을 다하는 쾌활하고 긍정적인 원피스의 주인공입니다.\n" + "\n" + "#분위기 메이커 #행동파 #때때로 산만 #낙관주의자\n"
					+ "#매사에 즐거움 #공사구별 어려움 #붙임성 #음식사진 다량보유\n";

		} else if (Sum.sum1 < 2 && Sum.sum2 < 2) {

			mbti = "ESFJ";

			type = "♥도라에몽♥";

			txt = "도라에몽은 착하지만 가끔 고집이 센 로봇 고양이로, 진구의 든든한 조력자입니다.\n" + "\n" + "#칭찬 자판기 #오지랖 #가정적 #관심에 민감\n"
					+ "#팔랑귀 #정많음 #팀플 선호 #서비스 정신 투철\n";

		} else if (Sum.sum1 < 2 && Sum.sum3 < 2 && Sum.sum4 < 2) {

			mbti = "ENTP";

			type = "♥짱구♥";

			txt = "짱구는 호기심 넘치는 장난기 가득한 아이로 친구들과 함께 모험을 즐기는 캐릭터입니다.\n" + "\n" + "#논쟁가 #마이웨이 #겉인싸 속아싸 #고집쎔\n"
					+ "#다재다능 #아이디어 부자 #실행력은 약함 #난 언제나 옳아\n";

		} else if (Sum.sum1 < 2 && Sum.sum3 < 2) {

			mbti = "ENTJ";

			type = "♥프리저♥";

			txt = "프리저는 냉철하고 계산적인 성향을 가진 동시에 독보적인 힘과 권력을 자랑하는 드래곤볼의 캐릭터입니다.\n" + "\n" + "#야망가 #극도의 효율 추구 #독재자 #공감능력부족\n"
					+ "#솔직 #워커홀릭 #철저한 공사구분 #제임스 고슬링\n";

		} else if (Sum.sum1 < 2 && Sum.sum4 < 2) {

			mbti = "ENFP";

			type = "♥뽀로로♥";

			txt = "뽀로로는 호기심 많고 활발한 성격의 펭귄으로, 모험을 즐기며 쾌활한 에너지를 뿜어냅니다.\n" + "\n" + "#이동건 #불타는 열정 #감성 충만 #자유로운 영혼\n"
					+ "#생각하기 전 행동 #친화력의 화신 #관종 #하지만은근낯가림\n";

		} else if (Sum.sum1 < 2) {

			mbti = "ENFJ";

			type = "♥피카츄♥";

			txt = "피카츄는 항상 주인공의 곁을 지키는 정의롭고 충실한 친구같은 포켓몬입니다.\n" + "\n" + "#붙임성 #자기관리 #소수보단 다수의 친구 #손절 잘 못함\n"
					+ "#의리파 #멘탈강함 #핵인싸 #감수성 풍부 #알잘딱깔센\n";

		} else if (Sum.sum2 < 2 && Sum.sum3 < 2 && Sum.sum4 < 2) {

			mbti = "ISTP";

			type = "♡뮬란♡";

			txt = "뮬란은 결단력이 있으며, 전통적인 고정관념에 정면으로 맞서는 자유로운 영혼의 디즈니 캐릭터입니다.\n" + "\n" + "#인생은 혼자 #겉바속촉 #장인정신 #타인에 무관심\n"
					+ "#마이웨이 #기브앤테이크 #빈말 못함 #심플이즈베스트\n";

		} else if (Sum.sum2 < 2 && Sum.sum3 < 2) {

			mbti = "ISTJ";

			type = "♡징징이♡";

			txt = "징징이는 스폰지밥의 이웃으로 늘 예민하지만 정직하고 깊은 인내심을 가진 캐릭터입니다.\n" + "\n" + "#보수적 #질서정연 #남모를 취미 #슈퍼 진지\n"
					+ "#모범생 #동방예의지국 #인내 #현실적 #한국인 표준\n";
		} else if (Sum.sum2 < 2 && Sum.sum4 < 2) {

			mbti = "ISFP";

			type = "♡해리포터♡";

			txt = "해리포터는 강인함을 지닌 마법사로, 소심한 면모가 있지만 누구보다 강인하게 시련에 맞서는 캐릭터입니다.\n" + "\n" + "#겸손 #친절 #평등 #현재를 즐김 #나만의 공간\n"
					+ "#소극적 #부드러움 #서포트특화 #강현욱\n";
		} else if (Sum.sum2 < 2) {

			mbti = "ISFJ";

			type = "♡캡틴 아메리카♡";

			txt = "캡틴 아메리카는 뛰어난 도덕성을 바탕으로 정의를 위해 싸우는 히어로 캐릭터입니다.\n" + "\n" + "#예의바름 #참다가 선넘으면 칼차단 #부담多 #성실\n"
					+ "#속깊음 #주변인 잘챙김 #평화주의자 #박명회 선생님\n";

		} else if (Sum.sum3 < 2 && Sum.sum4 < 2) {

			mbti = "INTP";

			type = "♡셜록홈즈♡";

			txt = "셜록홈즈는 뛰어난 추리력과 냉철한 두뇌를 바탕으로 미스터리한 사건들을 해결해 나가는 탐정입니다.\n" + "\n" + "#인간적인 로봇 #게으른 천재 #개인주의 #팩폭\n"
					+ "#귀차니스트 #빈말 못함 #목적없는 지식탐구 #권수민\n";

		} else if (Sum.sum3 < 2) {

			mbti = "INTJ";

			type = "♡타노스♡";

			txt = "타노스는 극단적인 신념을 가지고 인류를 심판하려 드는 빌런 캐릭터입니다.\n" + "\n" + "#멍청하면 손절 #블랙유머 #독립적 #가장 로봇같은 인간\n"
					+ "지적활동 #은근허당 #능력주의 #귀여운거좋아 #자기반성\n";

		} else if (Sum.sum4 < 2) {

			mbti = "INFP";

			type = "♡마이 멜로디♡";

			txt = "마이 멜로디는 순수하고 착한 토끼로 마음이 약하지만 여차할 때는 용기를 내는 캐릭터입니다.\n" + "\n" + "#감성충만 #평화주의 #잡생각多多 #눈치많이봄\n"
					+ "#감정이입 #이상과 현실의 괴리 #망상多多 #예술적 기질\n";

		} else {

			mbti = "INFJ";

			type = "♡엘사♡";

			txt = "엘사는 언제나 책임감 있고 강인하지만 그 내면에는 따뜻한 마음을 품고 있는 캐릭터입니다.\n" + "\n" + "#외강내유 #좁고 깊은 인간관계 #극단적 #생각多\n"
					+ "#겸손 #완벽주의 #애늙은이 #예수와 히틀러가 공존\n";
		}

		new DB(name, gender, age, mbti, type);

		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println(name + "님과 어울리는 캐릭터는 ");
		System.out.print("\u001B[35m" + type + "\u001B[0m");
		System.out.println(" 입니다.\n");
		System.out.print(txt);
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	}
}