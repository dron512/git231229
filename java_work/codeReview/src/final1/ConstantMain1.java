package final1;

public class ConstantMain1 {

    public static void main(String[] args) {
        System.out.println("프로그램 최대 참여자 수 " + 1000);
        int currentUserCount = 999; //커런트 유저 카운트 999 입력
        process(currentUserCount++);
        process(currentUserCount++);
        process(currentUserCount++);

    }

    private static void process(int currentUserCount){
        System.out.println("참여자 수: " + currentUserCount);
        if (currentUserCount > 1000){
            System.out.println("대기자로 등록됩니다.");
        }else {
            System.out.println("게임에 참여합니다.");
        }
    }
}
