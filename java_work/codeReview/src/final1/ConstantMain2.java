package final1;

public class ConstantMain2 {

    public static void main(String[] args) {
        System.out.println("프로그램 최대 참여자 수 " + Constant.MAX_USERS);// 컨스턴스 에 있는 상수 불러옴
        int currentUserCount = 999; //커런트 유저 카운트 999 입력
        process(currentUserCount++);
        process(currentUserCount++);
        process(currentUserCount++);

    }

    private static void process(int currentUserCount){ //프로세스 파라미터에 선언 정의
        System.out.println("참여자 수: " + currentUserCount);
        if (currentUserCount > Constant.MAX_USERS){
            System.out.println("대기자로 등록됩니다.");
        }else {
            System.out.println("게임에 참여합니다.");
        }
    }
}
